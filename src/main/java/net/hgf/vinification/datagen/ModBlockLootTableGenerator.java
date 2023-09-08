package net.hgf.vinification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hgf.vinification.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.GRAPE_CRATE_BLUE);
        addDrop(ModBlocks.GRAPE_CRATE_GREEN);
        addDrop(ModBlocks.GRAPE_CRATE_PURPLE);
        addDrop(ModBlocks.GRAPE_CRATE_RED);
        addDrop(ModBlocks.KEG_ACACIA);
        addDrop(ModBlocks.KEG_BIRCH);
        addDrop(ModBlocks.KEG_CHERRY);
        addDrop(ModBlocks.KEG_CRIMSON);
        addDrop(ModBlocks.KEG_DARK_OAK);
        addDrop(ModBlocks.KEG_JUNGLE);
        addDrop(ModBlocks.KEG_MANGROVE);
        addDrop(ModBlocks.KEG_OAK);
        addDrop(ModBlocks.KEG_SPRUCE);
        addDrop(ModBlocks.KEG_WARPED);
    }
}
