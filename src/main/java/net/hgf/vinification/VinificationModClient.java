package net.hgf.vinification;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;

public class VinificationModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEG_OAK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESE_BLOCK, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();
    }
}
