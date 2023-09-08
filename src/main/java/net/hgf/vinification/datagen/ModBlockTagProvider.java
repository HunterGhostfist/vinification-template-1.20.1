package net.hgf.vinification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hgf.vinification.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(
                ModBlocks.GRAPE_CRATE_BLUE,
                ModBlocks.GRAPE_CRATE_GREEN,
                ModBlocks.GRAPE_CRATE_PURPLE,
                ModBlocks.GRAPE_CRATE_RED,
                ModBlocks.KEG_ACACIA,
                ModBlocks.KEG_BIRCH,
                ModBlocks.KEG_CHERRY,
                ModBlocks.KEG_CRIMSON,
                ModBlocks.KEG_DARK_OAK,
                ModBlocks.KEG_JUNGLE,
                ModBlocks.KEG_MANGROVE,
                ModBlocks.KEG_OAK,
                ModBlocks.KEG_SPRUCE,
                ModBlocks.KEG_WARPED,
                ModBlocks.AGING_BARREL,
                ModBlocks.STOMPING_BARREL
        );
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.TAPPER
        );



    }
}
