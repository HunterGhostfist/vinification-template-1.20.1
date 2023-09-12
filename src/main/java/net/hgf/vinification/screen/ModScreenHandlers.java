package net.hgf.vinification.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.hgf.vinification.Vinification;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<StompingBarrelScreenHandler> STOMPING_BARREL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Vinification.MOD_ID, "stomping_barrel_screen_handler"),
            new ExtendedScreenHandlerType<>(StompingBarrelScreenHandler::new));

    public static final ScreenHandlerType<KegScreenHandler> KEG_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Vinification.MOD_ID, "keg_screen_handler"),
            new ExtendedScreenHandlerType<>(KegScreenHandler::new));

    public static final ScreenHandlerType<AgingBarrelScreenHandler> AGING_BARREL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Vinification.MOD_ID, "aging_barrel_screen_handler"),
            new ExtendedScreenHandlerType<>(AgingBarrelScreenHandler::new));

    public static final ScreenHandlerType<TapperScreenHandler> TAPPER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Vinification.MOD_ID, "tapper_screen_handler"),
            new ExtendedScreenHandlerType<>(TapperScreenHandler::new));


    public static void registerScreenHandler(){
        Vinification.LOGGER.info("Registering Screen Handlers for " + Vinification.MOD_ID);
    }
}
