package csm.neuki.unaddedexpansion.mixin;

import csm.neuki.unaddedexpansion.blocks.EndRepawnAnchorBlock;
import csm.neuki.unaddedexpansion.items.tools.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Inject(method = "updateSwimming()V", at = @At("HEAD"), cancellable = true)
    protected void swimInject(CallbackInfo info) {
        this.getArmorItems().forEach(itemStack -> {
            if(itemStack.getItem() == ModItems.OBSIDIAN_BOOTS || itemStack.getItem() == ModItems.OBSIDIAN_CHESTPLATE || itemStack.getItem() == ModItems.OBSIDIAN_HELMET || itemStack.getItem() == ModItems.OBSIDIAN_LEGS) {
                info.cancel();
            }
        });
    }

    @Inject(method = "findRespawnPosition(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;FZZ)Ljava/util/Optional;", at = @At("HEAD"), cancellable = true)
    private static void findRespawnPositionInject(ServerWorld world, BlockPos pos, float f, boolean bl, boolean bl2, CallbackInfoReturnable<Optional<Vec3d>> info) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();

        if (block instanceof EndRepawnAnchorBlock && blockState.get(EndRepawnAnchorBlock.CHARGES) > 0 && EndRepawnAnchorBlock.isEnd(world)) {
            Optional<Vec3d> optional = EndRepawnAnchorBlock.findRespawnPosition(EntityType.PLAYER, world, pos);
            if (!bl2 && optional.isPresent()) {
                world.setBlockState(pos, (BlockState)blockState.with(EndRepawnAnchorBlock.CHARGES, blockState.get(EndRepawnAnchorBlock.CHARGES) - 1), Block.NOTIFY_ALL);
            }
            info.setReturnValue(optional);
            info.cancel();
        }
    }
}
