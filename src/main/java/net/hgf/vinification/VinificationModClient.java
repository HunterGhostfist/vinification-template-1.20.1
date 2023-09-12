package net.hgf.vinification;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.screen.*;
import net.hgf.vinification.util.ModModelPredicateProvider;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class VinificationModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEG_OAK, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEESE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_BUSH_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_BUSH_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_BUSH_PURPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_BUSH_RED, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        HandledScreens.register(ModScreenHandlers.STOMPING_BARREL_SCREEN_HANDLER, StompingBarrelScreen::new);
        HandledScreens.register(ModScreenHandlers.KEG_SCREEN_HANDLER, KegScreen::new);
        HandledScreens.register(ModScreenHandlers.AGING_BARREL_SCREEN_HANDLER, AgingBarrelScreen::new);
        HandledScreens.register(ModScreenHandlers.TAPPER_SCREEN_HANDLER, TapperScreen::new);
    }
}
