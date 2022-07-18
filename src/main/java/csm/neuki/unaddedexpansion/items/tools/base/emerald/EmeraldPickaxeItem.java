package csm.neuki.unaddedexpansion.items.tools.base.emerald;

import csm.neuki.unaddedexpansion.items.tools.base.ModPickaxeItem;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class EmeraldPickaxeItem extends ModPickaxeItem {
    public EmeraldPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!stack.hasEnchantments()) {
            if(!stack.getOrCreateNbt().getBoolean("putEnchantment")) {
                stack.addEnchantment(Enchantments.FORTUNE, 5);
                stack.addEnchantment(Enchantments.MENDING, 5);
                stack.getOrCreateNbt().putBoolean("putEnchantment", true);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
