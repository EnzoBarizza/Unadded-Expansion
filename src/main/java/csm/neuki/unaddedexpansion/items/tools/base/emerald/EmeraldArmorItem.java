package csm.neuki.unaddedexpansion.items.tools.base.emerald;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmeraldArmorItem extends ArmorItem {
    public EmeraldArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!stack.getOrCreateNbt().getBoolean("putEnchanted")) {
            stack.addEnchantment(Enchantments.MENDING, 1);
            stack.getOrCreateNbt().putBoolean("putEnchanted", true);
            stack.getOrCreateNbt().putBoolean("unenchanted", false);
        }

        if (!stack.hasEnchantments()) {
            stack.getOrCreateNbt().putBoolean("unenchanted", true);
        } else {
            stack.getOrCreateNbt().putBoolean("unenchanted", false);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
