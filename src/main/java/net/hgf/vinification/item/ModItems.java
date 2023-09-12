package net.hgf.vinification.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.hgf.vinification.Vinification;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.item.custom.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item GRAPES_BLUE = registerItem("grapes_blue",
        new Item(new FabricItemSettings().food(ModFoodComponents.GRAPES_BLUE)));
    public static final Item GRAPES_GREEN = registerItem("grapes_green",
            new Item(new FabricItemSettings().food(ModFoodComponents.GRAPES_GREEN)));
    public static final Item GRAPES_PURPLE = registerItem("grapes_purple",
            new Item(new FabricItemSettings().food(ModFoodComponents.GRAPES_PURPLE)));
    public static final Item GRAPES_RED = registerItem("grapes_red",
            new Item(new FabricItemSettings().food(ModFoodComponents.GRAPES_RED)));
    public static final Item JAR_BLUE = registerItem("jar_blue",
            new Item(new FabricItemSettings().food(ModFoodComponents.JAR_BLUE).maxCount(16)));
    public static final Item JAR_EMPTY = registerItem("jar_empty",
            new Item(new FabricItemSettings()));
    public static final Item JAR_GREEN = registerItem("jar_green",
            new Item(new FabricItemSettings().food(ModFoodComponents.JAR_GREEN).maxCount(16)));
    public static final Item JAR_PURPLE = registerItem("jar_purple",
            new Item(new FabricItemSettings().food(ModFoodComponents.JAR_PURPLE).maxCount(16)));
    public static final Item JAR_RED = registerItem("jar_red",
            new Item(new FabricItemSettings().food(ModFoodComponents.JAR_RED).maxCount(16)));
    public static final Item JAR_RESIN = registerItem("jar_resin",
            new Item(new FabricItemSettings().maxCount(16)));
    public static final Item SAP = registerItem("sap",
            new Item(new FabricItemSettings()));
    public static final Item WINE_BOTTLE_EMPTY = registerItem("wine_bottle_empty",
            new Item(new FabricItemSettings()));
    public static final Item WINE_BOTTLE_BLUE = registerItem("wine_bottle_blue",
            new WineBottleBlue(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_BLUE_QUALITY = registerItem("wine_bottle_blue_quality",
            new WineBottleBlueQuality(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_GREEN = registerItem("wine_bottle_green",
            new WineBottleGreen(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_GREEN_QUALITY = registerItem("wine_bottle_green_quality",
            new WineBottleGreenQuality(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_HONEY = registerItem("wine_bottle_honey",
            new WineBottleHoney(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_PURPLE = registerItem("wine_bottle_purple",
            new WineBottlePurple(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_PURPLE_QUALITY = registerItem("wine_bottle_purple_quality",
            new WineBottlePurpleQuality(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_RED = registerItem("wine_bottle_red",
            new WineBottleRed(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item WINE_BOTTLE_RED_QUALITY = registerItem("wine_bottle_red_quality",
            new WineBottleRedQuality(new FabricItemSettings().recipeRemainder(WINE_BOTTLE_EMPTY).maxCount(16)));
    public static final Item SEEDS_BLUE = registerItem("seeds_blue",
            new AliasedBlockItem(ModBlocks.GRAPE_BUSH_BLUE, new FabricItemSettings()));
    public static final Item SEEDS_GREEN = registerItem("seeds_green",
            new AliasedBlockItem(ModBlocks.GRAPE_BUSH_GREEN, new FabricItemSettings()));
    public static final Item SEEDS_PURPLE = registerItem("seeds_purple",
            new AliasedBlockItem(ModBlocks.GRAPE_BUSH_PURPLE, new FabricItemSettings()));
    public static final Item SEEDS_RED = registerItem("seeds_red",
            new AliasedBlockItem(ModBlocks.GRAPE_BUSH_RED, new FabricItemSettings()));
    public static final Item BOTTLE_BLUE = registerItem("bottle_blue",
        new Item(new FabricItemSettings().maxCount(16)));
    public static final Item BOTTLE_GREEN = registerItem("bottle_green",
            new Item(new FabricItemSettings().maxCount(16)));
    public static final Item BOTTLE_PURPLE = registerItem("bottle_purple",
            new Item(new FabricItemSettings().maxCount(16)));
    public static final Item BOTTLE_RED = registerItem("bottle_red",
            new Item(new FabricItemSettings().maxCount(16)));



    private static Item registerItem(String  name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Vinification.MOD_ID, name), item);
    }

    public static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(GRAPES_BLUE);
        entries.add(GRAPES_GREEN);
        entries.add(GRAPES_PURPLE);
        entries.add(GRAPES_RED);
        entries.add(JAR_BLUE);
        entries.add(JAR_EMPTY);
        entries.add(JAR_GREEN);
        entries.add(JAR_PURPLE);
        entries.add(JAR_RED);
        entries.add(JAR_RESIN);
        entries.add(BOTTLE_BLUE);
        entries.add(BOTTLE_GREEN);
        entries.add(BOTTLE_PURPLE);
        entries.add(BOTTLE_RED);
        entries.add(SAP);
        entries.add(WINE_BOTTLE_BLUE);
        entries.add(WINE_BOTTLE_BLUE_QUALITY);
        entries.add(WINE_BOTTLE_EMPTY);
        entries.add(WINE_BOTTLE_GREEN);
        entries.add(WINE_BOTTLE_GREEN_QUALITY);
        entries.add(WINE_BOTTLE_HONEY);
        entries.add(WINE_BOTTLE_PURPLE);
        entries.add(WINE_BOTTLE_PURPLE_QUALITY);
        entries.add(WINE_BOTTLE_RED);
        entries.add(WINE_BOTTLE_RED_QUALITY);

        entries.add(ModBlocks.GRAPE_CRATE_BLUE);
        entries.add(ModBlocks.GRAPE_CRATE_GREEN);
        entries.add(ModBlocks.GRAPE_CRATE_PURPLE);
        entries.add(ModBlocks.GRAPE_CRATE_RED);
    }
    public static void registerModItems() {
        Vinification.LOGGER.info("Registering Mod Items for " + Vinification.MOD_ID);


    }
}
