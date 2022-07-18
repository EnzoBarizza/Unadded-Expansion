package csm.neuki.unaddedexpansion;

import csm.neuki.unaddedexpansion.blocks.ModBlocks;
import csm.neuki.unaddedexpansion.items.tools.ModItems;
import csm.neuki.unaddedexpansion.util.ModRegistries;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnaddedExpansionMod implements ModInitializer {
	public static final String MOD_ID = "unaddedexpansion";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerItemsAndTools();
		ModBlocks.registerBlocks();
		ModRegistries.registerTrades();
		ModRegistries.registerDipenserBehavior();
		ModRegistries.vanillaModifiers();
		LOGGER.info("VPP Mod loading...");

	}
}
