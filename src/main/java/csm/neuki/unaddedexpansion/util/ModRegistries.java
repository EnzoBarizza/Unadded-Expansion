package csm.neuki.unaddedexpansion.util;

import csm.neuki.unaddedexpansion.blocks.EndRepawnAnchorBlock;
import csm.neuki.unaddedexpansion.blocks.ModBlocks;
import csm.neuki.unaddedexpansion.items.tools.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.*;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 2),
                    new ItemStack(ModItems.EMERALD_SWORD),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 3),
                    new ItemStack(ModItems.EMERALD_PICKAXE),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 3),
                    new ItemStack(ModItems.EMERALD_AXE),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 2),
                    new ItemStack(ModItems.EMERALD_HOE),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(ModItems.EMERALD_SHOVEL),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 5),
                    new ItemStack(ModItems.EMERALD_HELMET),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 8),
                    new ItemStack(ModItems.EMERALD_CHESTPLATE),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 7),
                    new ItemStack(ModItems.EMERALD_LEGS),
                    12,
                    20,
                    0.08f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(Items.DIAMOND, 4),
                    new ItemStack(ModItems.EMERALD_BOOTS),
                    12,
                    20,
                    0.08f
            ));

        });
    }

    public static void registerDipenserBehavior() {
        DispenserBlock.registerBehavior(Items.ENDER_PEARL, new FallibleItemDispenserBehavior(){
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
                BlockPos blockPos = pointer.getPos().offset(direction);
                ServerWorld world = pointer.getWorld();
                BlockState blockState = world.getBlockState(blockPos);
                this.setSuccess(true);
                if (blockState.isOf(ModBlocks.END_RESPAWN_ANCHOR)) {
                    if (blockState.get(EndRepawnAnchorBlock.CHARGES) != 4) {
                        EndRepawnAnchorBlock.charge(world, blockPos, blockState);
                        stack.decrement(1);
                    } else {
                        this.setSuccess(false);
                    }
                    return stack;
                }
                return super.dispenseSilently(pointer, stack);
            }
        });
    }

    public static void vanillaModifiers() {
        Items.END_PORTAL_FRAME.fireproof = true;
        Items.OBSIDIAN.fireproof = true;
        Items.CRYING_OBSIDIAN.fireproof = true;
    }
}
