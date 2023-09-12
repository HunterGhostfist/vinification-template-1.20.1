package net.hgf.vinification.recipe;

import net.hgf.vinification.Vinification;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Vinification.MOD_ID, StompingBarrelRecipe.Serializer.ID),
                StompingBarrelRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Vinification.MOD_ID, StompingBarrelRecipe.Type.ID),
                StompingBarrelRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Vinification.MOD_ID, KegRecipe.Serializer.ID),
                KegRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Vinification.MOD_ID, KegRecipe.Type.ID),
                KegRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Vinification.MOD_ID, AgingRecipe.Serializer.ID),
                AgingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Vinification.MOD_ID, AgingRecipe.Type.ID),
                AgingRecipe.Type.INSTANCE);
    }
}
