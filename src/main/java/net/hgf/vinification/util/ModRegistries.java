package net.hgf.vinification.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.item.ModItems;
import net.hgf.vinification.villager.ModVillagers;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModRegistries {

    public static  void registerModStuffs(){
        registerModCompostables();
        registerCustomTrades();
    }
    public static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_BLUE, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_GREEN, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_PURPLE, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_RED, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_BLUE, 0.2f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_GREEN, 0.2f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_PURPLE, 0.2f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_RED, 0.2f);


        }
        private static void registerCustomTrades(){


        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModBlocks.STOMPING_BARREL, 1), 6, 2, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModBlocks.CHEESE_BLOCK, 5),
                    new ItemStack(Items.EMERALD, 9), 4, 2, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.JAR_EMPTY, 4), 6, 2, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.JAR_BLUE, 1),
                    new ItemStack(Items.EMERALD, 5), 6, 5, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.JAR_GREEN, 1),
                    new ItemStack(Items.EMERALD, 5), 6, 5, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.JAR_PURPLE, 1),
                    new ItemStack(Items.EMERALD, 5), 6, 5, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.JAR_RED, 1),
                    new ItemStack(Items.EMERALD, 5), 6, 5, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.WINE_BOTTLE_EMPTY, 5), 6, 5, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_ACACIA, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_BIRCH, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_CHERRY, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_DARK_OAK, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_JUNGLE, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_MANGROVE, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_OAK, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.KEG_SPRUCE, 1), 6, 10, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 22),
                    new ItemStack(ModBlocks.AGING_BARREL, 1), 6, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.MILK_BUCKET, 1),
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModBlocks.CHEESE_BLOCK, 6), 6, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ModItems.GRAPES_BLUE, 1), 1, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ModItems.GRAPES_GREEN, 1), 1, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.WINE_BOTTLE_BLUE_QUALITY, 1),
                    new ItemStack(Items.EMERALD, 48), 6, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.WINE_BOTTLE_GREEN_QUALITY, 1),
                    new ItemStack(Items.EMERALD, 48), 6, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.WINE_BOTTLE_PURPLE_QUALITY, 1),
                    new ItemStack(Items.EMERALD, 48), 6, 15, 0.02f
                    ));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOMMELIER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.WINE_BOTTLE_RED_QUALITY, 1),
                    new ItemStack(Items.EMERALD, 48), 6, 15, 0.02f
                    ));
        });
    }
}