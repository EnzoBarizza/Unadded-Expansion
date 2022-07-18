package csm.neuki.unaddedexpansion.mixin;

import csm.neuki.unaddedexpansion.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldProperties;
import net.minecraft.world.biome.source.BiomeAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Mixin(PlayerManager.class)
public abstract class PlayerManagerMixin {

    @Shadow @Final private MinecraftServer server;
    @Shadow @Final private List<ServerPlayerEntity> players;

    @Shadow public abstract void sendWorldInfo(ServerPlayerEntity player, ServerWorld world);

    @Shadow public abstract void sendCommandTree(ServerPlayerEntity player);

    @Shadow @Final private Map<UUID, ServerPlayerEntity> playerMap;
    boolean last = false;

    @Inject(method = "respawnPlayer(Lnet/minecraft/server/network/ServerPlayerEntity;Z)Lnet/minecraft/server/network/ServerPlayerEntity;", at = @At("HEAD"), cancellable = true)
    private void respawnPlayerInject(ServerPlayerEntity player, boolean alive, CallbackInfoReturnable<ServerPlayerEntity> info) {
        this.players.remove(player);
        player.getWorld().removePlayer(player, Entity.RemovalReason.DISCARDED);
        BlockPos blockPos = player.getSpawnPointPosition();
        float f = player.getSpawnAngle();
        boolean bl = player.isSpawnForced();
        ServerWorld serverWorld = this.server.getWorld(player.getSpawnPointDimension());
        Optional<Vec3d> optional = serverWorld != null && blockPos != null ? PlayerEntity.findRespawnPosition(serverWorld, blockPos, f, bl, alive) : Optional.empty();
        ServerWorld serverWorld2 = serverWorld != null && optional.isPresent() ? serverWorld : this.server.getOverworld();
        ServerPlayerEntity serverPlayerEntity = new ServerPlayerEntity(this.server, serverWorld2, player.getGameProfile(), player.getPublicKey());
        serverPlayerEntity.networkHandler = player.networkHandler;
        serverPlayerEntity.copyFrom(player, alive);
        serverPlayerEntity.setId(player.getId());
        serverPlayerEntity.setMainArm(player.getMainArm());
        for (String string : player.getScoreboardTags()) {
            serverPlayerEntity.addScoreboardTag(string);
        }
        boolean bl2 = false;
        if (optional.isPresent()) {
            float g;
            BlockState blockState = serverWorld2.getBlockState(blockPos);
            boolean bl3 = blockState.isOf(Blocks.RESPAWN_ANCHOR) || blockState.isOf(ModBlocks.END_RESPAWN_ANCHOR);
            Vec3d vec3d = (Vec3d)optional.get();
            if (blockState.isIn(BlockTags.BEDS) || bl3) {
                Vec3d vec3d2 = Vec3d.ofBottomCenter(blockPos).subtract(vec3d).normalize();
                g = (float)MathHelper.wrapDegrees(MathHelper.atan2(vec3d2.z, vec3d2.x) * 57.2957763671875 - 90.0);
            } else {
                g = f;
            }
            serverPlayerEntity.refreshPositionAndAngles(vec3d.x, vec3d.y, vec3d.z, g, 0.0f);
            serverPlayerEntity.setSpawnPoint(serverWorld2.getRegistryKey(), blockPos, f, bl, false);
            bl2 = !alive && bl3;
        } else if (blockPos != null) {
            serverPlayerEntity.networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.NO_RESPAWN_BLOCK, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
        }
        while (!serverWorld2.isSpaceEmpty(serverPlayerEntity) && serverPlayerEntity.getY() < (double)serverWorld2.getTopY()) {
            serverPlayerEntity.setPosition(serverPlayerEntity.getX(), serverPlayerEntity.getY() + 1.0, serverPlayerEntity.getZ());
        }
        WorldProperties worldProperties = serverPlayerEntity.world.getLevelProperties();
        serverPlayerEntity.networkHandler.sendPacket(new PlayerRespawnS2CPacket(serverPlayerEntity.world.getDimensionKey(), serverPlayerEntity.world.getRegistryKey(), BiomeAccess.hashSeed(serverPlayerEntity.getWorld().getSeed()), serverPlayerEntity.interactionManager.getGameMode(), serverPlayerEntity.interactionManager.getPreviousGameMode(), serverPlayerEntity.getWorld().isDebugWorld(), serverPlayerEntity.getWorld().isFlat(), alive, serverPlayerEntity.getLastDeathPos()));
        serverPlayerEntity.networkHandler.requestTeleport(serverPlayerEntity.getX(), serverPlayerEntity.getY(), serverPlayerEntity.getZ(), serverPlayerEntity.getYaw(), serverPlayerEntity.getPitch());
        serverPlayerEntity.networkHandler.sendPacket(new PlayerSpawnPositionS2CPacket(serverWorld2.getSpawnPos(), serverWorld2.getSpawnAngle()));
        serverPlayerEntity.networkHandler.sendPacket(new DifficultyS2CPacket(worldProperties.getDifficulty(), worldProperties.isDifficultyLocked()));
        serverPlayerEntity.networkHandler.sendPacket(new ExperienceBarUpdateS2CPacket(serverPlayerEntity.experienceProgress, serverPlayerEntity.totalExperience, serverPlayerEntity.experienceLevel));
        this.sendWorldInfo(serverPlayerEntity, serverWorld2);
        this.sendCommandTree(serverPlayerEntity);
        serverWorld2.onPlayerRespawned(serverPlayerEntity);
        this.players.add(serverPlayerEntity);
        this.playerMap.put(serverPlayerEntity.getUuid(), serverPlayerEntity);
        serverPlayerEntity.onSpawn();
        serverPlayerEntity.setHealth(serverPlayerEntity.getHealth());
        if (bl2) {
            serverPlayerEntity.networkHandler.sendPacket(new PlaySoundS2CPacket(SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE, SoundCategory.BLOCKS, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, serverWorld2.getRandom().nextLong()));
        }
        info.setReturnValue(serverPlayerEntity);
        info.cancel();
    }
}
