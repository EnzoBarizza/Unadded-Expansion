package csm.neuki.unaddedexpansion.mixin;

import csm.neuki.unaddedexpansion.items.tools.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public abstract class AbstractBlockMixin {

    @Inject(method = "calcBlockBreakingDelta(Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)F", at = @At("HEAD"), cancellable = true)
    public void calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos, CallbackInfoReturnable<Float> info) {
        if (state.getBlock() == Blocks.END_PORTAL_FRAME && player.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.DRAGON_SCALE_PICKAXE) {
            info.setReturnValue(0.0053333333f);
            info.cancel();
        }

        if (state.getBlock() == Blocks.END_PORTAL && player.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.DRAGON_SCALE_PICKAXE) {
            info.setReturnValue(1.0f);
            info.cancel();
        }
    }
}

