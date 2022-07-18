package csm.neuki.unaddedexpansion.items.tools.base;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        return super.getDefaultStack();
    }
}
