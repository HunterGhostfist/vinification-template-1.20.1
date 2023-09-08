package net.hgf.vinification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.block.custom.GrapeBushBlue;
import net.hgf.vinification.block.custom.GrapeBushGreen;
import net.hgf.vinification.block.custom.GrapeBushPurple;
import net.hgf.vinification.block.custom.GrapeBushRed;
import net.hgf.vinification.item.ModItems;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

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
        addDrop(ModBlocks.TAPPER);
        addDrop(ModBlocks.AGING_BARREL);
        addDrop(ModBlocks.STOMPING_BARREL);

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.GRAPE_BUSH_BLUE)
                        .properties(StatePredicate.Builder.create().exactMatch(GrapeBushBlue.AGE, 3));
        this.addDrop(ModBlocks.GRAPE_BUSH_BLUE, this.cropDrops(ModBlocks.GRAPE_BUSH_BLUE, ModItems.GRAPES_BLUE, ModItems.SEEDS_BLUE, builder2));

        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.GRAPE_BUSH_GREEN)
                        .properties(StatePredicate.Builder.create().exactMatch(GrapeBushGreen.AGE, 3));
        this.addDrop(ModBlocks.GRAPE_BUSH_GREEN, this.cropDrops(ModBlocks.GRAPE_BUSH_GREEN, ModItems.GRAPES_GREEN, ModItems.SEEDS_GREEN, builder3));

        BlockStatePropertyLootCondition.Builder builder4 = BlockStatePropertyLootCondition.builder(ModBlocks.GRAPE_BUSH_PURPLE)
                        .properties(StatePredicate.Builder.create().exactMatch(GrapeBushPurple.AGE, 3));
        this.addDrop(ModBlocks.GRAPE_BUSH_PURPLE, this.cropDrops(ModBlocks.GRAPE_BUSH_PURPLE, ModItems.GRAPES_PURPLE, ModItems.SEEDS_PURPLE, builder4));

        BlockStatePropertyLootCondition.Builder builder5 = BlockStatePropertyLootCondition.builder(ModBlocks.GRAPE_BUSH_RED)
                        .properties(StatePredicate.Builder.create().exactMatch(GrapeBushRed.AGE, 3));
        this.addDrop(ModBlocks.GRAPE_BUSH_RED, this.cropDrops(ModBlocks.GRAPE_BUSH_RED, ModItems.GRAPES_RED, ModItems.SEEDS_RED, builder5));
    }
}
