package csm.neuki.unaddedexpansion.items.tools.base.emerald;

import csm.neuki.unaddedexpansion.items.tools.base.ModHoeItem;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EmeraldHoeItem extends ModHoeItem {

    public EmeraldHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!stack.hasEnchantments()) {
            if(!stack.getOrCreateNbt().getBoolean("putEnchantment")) {
                stack.addEnchantment(Enchantments.MENDING, 1);
                stack.getOrCreateNbt().putBoolean("putEnchantment", true);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
