package net.hgf.vinification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.block.custom.GrapeBushBlue;
import net.hgf.vinification.block.custom.GrapeBushGreen;
import net.hgf.vinification.block.custom.GrapeBushPurple;
import net.hgf.vinification.block.custom.GrapeBushRed;
import net.hgf.vinification.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPE_CRATE_BLUE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPE_CRATE_GREEN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPE_CRATE_PURPLE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPE_CRATE_RED);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_ACACIA);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_BIRCH);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_CHERRY);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_CRIMSON);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_DARK_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_JUNGLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_MANGROVE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_OAK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_SPRUCE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEG_WARPED);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.AGING_BARREL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TAPPER);
        blockStateModelGenerator.registerSimpleState(ModBlocks.STOMPING_BARREL);

        blockStateModelGenerator.registerCrop(ModBlocks.GRAPE_BUSH_BLUE, GrapeBushBlue.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.GRAPE_BUSH_GREEN, GrapeBushGreen.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.GRAPE_BUSH_PURPLE, GrapeBushPurple.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.GRAPE_BUSH_RED, GrapeBushRed.AGE, 0, 1, 2, 3);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GRAPES_BLUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPES_GREEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPES_PURPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPES_RED, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR_BLUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR_EMPTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR_GREEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR_PURPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR_RED, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR_RESIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_BLUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_BLUE_QUALITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_EMPTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_GREEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_GREEN_QUALITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_HONEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_PURPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_PURPLE_QUALITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_RED, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE_BOTTLE_RED_QUALITY, Models.GENERATED);



    }
}
