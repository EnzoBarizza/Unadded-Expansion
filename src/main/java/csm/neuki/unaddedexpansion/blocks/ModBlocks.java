package csm.neuki.unaddedexpansion.blocks;

import csm.neuki.unaddedexpansion.UnaddedExpansionMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block END_RESPAWN_ANCHOR = registerBlock("end_respawn_anchor",
            new EndRepawnAnchorBlock(
                    AbstractBlock
                            .Settings
                            .of(Material.STONE, MapColor.TERRACOTTA_WHITE)
                            .requiresTool()
                            .strength(20.0f, 200.0f)
                            .luminance(state -> EndRepawnAnchorBlock.getLightLevel(state, 15))
            )
    );

    public static final Item END_RESPAWN_BLOCK_ITEM = registerBlockItem("end_respawn_anchor", END_RESPAWN_ANCHOR, ItemGroup.DECORATIONS, new FabricItemSettings().fireproof());

    public static void registerBlocks() {
    }

    protected static Item registerBlockItem(String name, Block block, ItemGroup group, Item.Settings settings) {
        return Registry.register(
                Registry.ITEM,
                new Identifier(UnaddedExpansionMod.MOD_ID, name),
                new BlockItem(block, settings.group(group))
        );
    }

    protected static Block registerBlock(String name, Block block) {
        return Registry.register(
                Registry.BLOCK,
                new Identifier(UnaddedExpansionMod.MOD_ID, name),
                block
        );
    }
}
