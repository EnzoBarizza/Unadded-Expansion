package csm.neuki.unaddedexpansion.items.tools;

import csm.neuki.unaddedexpansion.UnaddedExpansionMod;
import csm.neuki.unaddedexpansion.items.tools.base.*;
import csm.neuki.unaddedexpansion.items.tools.base.dragonscale.DragonScalePickaxe;
import csm.neuki.unaddedexpansion.items.tools.base.emerald.*;
import csm.neuki.unaddedexpansion.materials.ModArmorMaterials;
import csm.neuki.unaddedexpansion.materials.ModToolMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

/******************************************************************************/
/*************************** AMETHYST RELATED INIT ****************************/
    /******************************************************************************/
    public static final Item AMETHYST_GEM = registerItem(
            "amethyst_gem",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)
            )
    );

    public static final Item AMETHYST_SWORD = registerItem(
            "amethyst_sword",
            new ModSwordItem(
                    ModToolMaterials.AMETHYST,
                    3,
                    -2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item AMETHYST_PICKAXE = registerItem(
            "amethyst_pickaxe", new ModPickaxeItem(
                    ModToolMaterials.AMETHYST,
                    1,
                    -1.2f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item AMETHYST_AXE = registerItem(
            "amethyst_axe",
            new ModAxeItem(
                    ModToolMaterials.AMETHYST,
                    5.0f,
                    -2.5f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item AMETHYST_HOE = registerItem(
            "amethyst_hoe",
            new ModHoeItem(
                    ModToolMaterials.AMETHYST,
                    -3,
                    0.0f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item AMETHYST_SHOVEL = registerItem(
            "amethyst_shovel",
            new ModShovelItem(
                    ModToolMaterials.AMETHYST,
                    1.5f,
                    -2.0f,
                    new FabricItemSettings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item AMETHYST_HELMET = registerItem(
            "amethyst_helmet",
            new ArmorItem(
                    ModArmorMaterials.AMETHYST,
                    EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item AMETHYST_CHESTPLATE = registerItem(
            "amethyst_chestplate",
            new ArmorItem(
                    ModArmorMaterials.AMETHYST,
                    EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item AMETHYST_LEGS = registerItem(
            "amethyst_leggings",
            new ArmorItem(
                    ModArmorMaterials.AMETHYST,
                    EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item AMETHYST_BOOTS = registerItem(
            "amethyst_boots",
            new ArmorItem(
                    ModArmorMaterials.AMETHYST,
                    EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

/******************************************************************************/
/*************************** AMETHYST RELATED END *****************************/
/******************************************************************************/

/******************************************************************************/
/************************** DEEPSLATE RELATED INIT ****************************/
    /******************************************************************************/

    public static final Item DEEPSLATE_SWORD = registerItem(
            "deepslate_sword",
            new ModSwordItem(
                    ModToolMaterials.DEEPSLATE,
                    3,
                    -3,
                    new Item.Settings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item DEEPSLATE_PICKAXE = registerItem(
            "deepslate_pickaxe",
            new ModPickaxeItem(
                    ModToolMaterials.DEEPSLATE,
                    1,
                    -3,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item DEEPSLATE_SHOVEL = registerItem(
            "deepslate_shovel",
            new ModShovelItem(
                    ModToolMaterials.DEEPSLATE,
                    1.5f,
                    -3.5f,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item DEEPSLATE_AXE = registerItem(
            "deepslate_axe",
            new ModAxeItem(
                    ModToolMaterials.DEEPSLATE,
                    6,
                    -3.8f,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item DEEPSLATE_HOE = registerItem(
            "deepslate_hoe",
            new ModHoeItem(
                    ModToolMaterials.DEEPSLATE,
                    0,
                    -3.0f,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

/******************************************************************************/
/************************** DEEPSLATE RELATED END *****************************/
/******************************************************************************/

/******************************************************************************/
/************************** EMERALD RELATED INIT ******************************/
    /******************************************************************************/
    public static final Item EMERALD_HELMET = registerItem(
            "emerald_helmet",
            new EmeraldArmorItem(
                    ModArmorMaterials.EMERALD,
                    EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item EMERALD_CHESTPLATE = registerItem(
            "emerald_chestplate",
            new EmeraldArmorItem(
                    ModArmorMaterials.EMERALD,
                    EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item EMERALD_LEGS = registerItem(
            "emerald_leggings",
            new EmeraldArmorItem(
                    ModArmorMaterials.EMERALD,
                    EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item EMERALD_BOOTS = registerItem(
            "emerald_boots",
            new EmeraldArmorItem(
                    ModArmorMaterials.EMERALD,
                    EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item EMERALD_SWORD = registerItem(
            "emerald_sword",
            new EmeraldSwordItem(
                    ModToolMaterials.EMERALD,
                    3,
                    -2.4f,
                    new Item.Settings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item EMERALD_PICKAXE = registerItem(
            "emerald_pickaxe",
            new EmeraldPickaxeItem(
                    ModToolMaterials.EMERALD,
                    1,
                    -2.8f,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item EMERALD_AXE = registerItem(
            "emerald_axe",
            new EmeraldAxeItem(
                    ModToolMaterials.EMERALD,
                    5,
                    -3.0f,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item EMERALD_SHOVEL = registerItem(
            "emerald_shovel",
            new EmeraldShovelItem(
                    ModToolMaterials.EMERALD,
                    1.5f,
                    -3,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );

    public static final Item EMERALD_HOE = registerItem(
            "emerald_hoe",
            new EmeraldHoeItem(
                    ModToolMaterials.EMERALD,
                    -3,
                    -0,
                    new Item.Settings().group(ItemGroup.TOOLS)
            )
    );
/******************************************************************************/
/************************** EMERALD RELATED END *******************************/
/******************************************************************************/

/******************************************************************************/
/************************** OBSIDIAN RELATED INIT *****************************/
    /******************************************************************************/

    public static final Item OBSIDIAN_HELMET = registerItem(
            "obsidian_helmet",
            new ArmorItem(
                    ModArmorMaterials.OBSIDIAN,
                    EquipmentSlot.HEAD,
                    new Item.Settings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item OBSIDIAN_CHESTPLATE = registerItem(
            "obsidian_chestplate",
            new ArmorItem(
                    ModArmorMaterials.OBSIDIAN,
                    EquipmentSlot.CHEST,
                    new Item.Settings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item OBSIDIAN_LEGS = registerItem(
            "obsidian_leggings",
            new ArmorItem(
                    ModArmorMaterials.OBSIDIAN,
                    EquipmentSlot.LEGS,
                    new Item.Settings().group(ItemGroup.COMBAT)
            )
    );

    public static final Item OBSIDIAN_BOOTS = registerItem(
            "obsidian_boots",
            new ArmorItem(
                    ModArmorMaterials.OBSIDIAN,
                    EquipmentSlot.FEET,
                    new Item.Settings().group(ItemGroup.COMBAT)
            )
    );
/******************************************************************************/
/************************** OBSIDIAN RELATED END ******************************/
/******************************************************************************/

/******************************************************************************/
/************************** DRAGONSCALE RELATED INIT **************************/
    /******************************************************************************/

    public static final Item DAMAGED_DRAGON_SCALE = registerItem(
            "damaged_dragon_scale",
            new Item(
                    new FabricItemSettings()
                            .fireproof()
                            .rarity(Rarity.UNCOMMON)
                            .group(ItemGroup.MATERIALS)
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE = registerItem(
            "dragon_scale",
            new Item(
                    new FabricItemSettings()
                            .fireproof()
                            .rarity(Rarity.EPIC)
                            .group(ItemGroup.MATERIALS)
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_HELMET = registerItem(
            "dragon_scale_helmet",
            new ArmorItem(
                    ModArmorMaterials.DRAGON_SCALE,
                    EquipmentSlot.HEAD,
                    new FabricItemSettings()
                            .group(ItemGroup.COMBAT)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_CHESTPLATE = registerItem(
            "dragon_scale_chestplate",
            new ArmorItem(
                    ModArmorMaterials.DRAGON_SCALE,
                    EquipmentSlot.CHEST,
                    new FabricItemSettings()
                            .group(ItemGroup.COMBAT)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_LEGS = registerItem(
            "dragon_scale_leggings",
            new ArmorItem(
                    ModArmorMaterials.DRAGON_SCALE,
                    EquipmentSlot.LEGS,
                    new FabricItemSettings()
                            .group(ItemGroup.COMBAT)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_BOOTS = registerItem(
            "dragon_scale_boots",
            new ArmorItem(
                    ModArmorMaterials.DRAGON_SCALE,
                    EquipmentSlot.FEET,
                    new FabricItemSettings()
                            .group(ItemGroup.COMBAT)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_SWORD = registerItem(
            "dragon_scale_sword",
            new ModSwordItem(
                    ModToolMaterials.DRAGON_SCALE,
                    5,
                    -2.4f,
                    new Item.Settings()
                            .group(ItemGroup.COMBAT)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_PICKAXE = registerItem(
            "dragon_scale_pickaxe",
            new DragonScalePickaxe(
                    ModToolMaterials.DRAGON_SCALE,
                    1,
                    -2.8f,
                    new Item.Settings()
                            .group(ItemGroup.TOOLS)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_AXE = registerItem(
            "dragon_scale_axe",
            new ModAxeItem(
                    ModToolMaterials.DRAGON_SCALE,
                    7,
                    -3.0f,
                    new Item.Settings()
                            .group(ItemGroup.TOOLS)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_SHOVEL = registerItem(
            "dragon_scale_shovel",
            new ModShovelItem(
                    ModToolMaterials.DRAGON_SCALE,
                    1.5f,
                    -3,
                    new Item.Settings()
                            .group(ItemGroup.TOOLS)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item DRAGON_SCALE_HOE = registerItem(
            "dragon_scale_hoe",
            new ModHoeItem(
                    ModToolMaterials.DRAGON_SCALE,
                    -3,
                    -0,
                    new Item.Settings()
                            .group(ItemGroup.TOOLS)
                            .fireproof()
                            .rarity(Rarity.EPIC)
            )
    );
/******************************************************************************/
/************************** DRAGONSCALE RELATED END ***************************/
    /******************************************************************************/


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(UnaddedExpansionMod.MOD_ID, name), item);
    }

    public static void registerItemsAndTools() {

    }
}
