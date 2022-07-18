package csm.neuki.unaddedexpansion.materials;

import csm.neuki.unaddedexpansion.items.tools.ModItems;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    AMETHYST(MiningLevels.DIAMOND, 1001, 20.0f, 4f, 18, () -> Ingredient.ofItems(ModItems.AMETHYST_GEM)),
    DEEPSLATE(MiningLevels.STONE, 262, 4.0f, 1.0f, 7, () -> Ingredient.ofItems(Items.COBBLED_DEEPSLATE)),
    EMERALD(MiningLevels.DIAMOND, 1561, 8.0f, 3.0f, 80, () -> Ingredient.ofItems(Items.EMERALD)),
    DRAGON_SCALE(20, 4062, 50.0f, 6.0f, 50, () -> Ingredient.ofItems(ModItems.DRAGON_SCALE));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
