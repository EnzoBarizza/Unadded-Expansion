package csm.neuki.unaddedexpansion.items.tools.base.dragonscale;

import csm.neuki.unaddedexpansion.items.tools.base.ModPickaxeItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DragonScalePickaxe extends ModPickaxeItem {
    public DragonScalePickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        BooleanProperty EYE = Properties.EYE;

        if (state.getBlock() == Blocks.END_PORTAL_FRAME) {
            if (state.get(EYE)) {
                Block.dropStack(world, pos, Items.ENDER_EYE.getDefaultStack());
            }
            Block.dropStack(world, pos, state.getBlock().asItem().getDefaultStack());
        }

        return super.postMine(stack, world, state, pos, miner);
    }
}
