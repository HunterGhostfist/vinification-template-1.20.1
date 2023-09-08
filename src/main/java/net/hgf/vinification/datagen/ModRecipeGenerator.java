package net.hgf.vinification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR_RESIN)
                .input(ModItems.JAR_EMPTY)
                .input(ModItems.SAP)
                .input(Items.SLIME_BALL)
                .criterion(hasItem(ModItems.JAR_EMPTY),conditionsFromItem(ModItems.JAR_EMPTY))
                .criterion(hasItem(ModItems.SAP),conditionsFromItem(ModItems.SAP))
                .criterion(hasItem(Items.SLIME_BALL),conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JAR_RESIN) + "_recipe"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR_BLUE)
                .input(ModItems.JAR_EMPTY)
                .input(ModItems.GRAPES_BLUE)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.JAR_EMPTY),conditionsFromItem(ModItems.JAR_EMPTY))
                .criterion(hasItem(ModItems.GRAPES_BLUE),conditionsFromItem(ModItems.GRAPES_BLUE))
                .criterion(hasItem(Items.SUGAR),conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JAR_BLUE) + "_recipe"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR_GREEN)
                .input(ModItems.JAR_EMPTY)
                .input(ModItems.GRAPES_GREEN)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.JAR_EMPTY),conditionsFromItem(ModItems.JAR_EMPTY))
                .criterion(hasItem(ModItems.GRAPES_GREEN),conditionsFromItem(ModItems.GRAPES_GREEN))
                .criterion(hasItem(Items.SUGAR),conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JAR_GREEN) + "_recipe"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR_PURPLE)
                .input(ModItems.JAR_EMPTY)
                .input(ModItems.GRAPES_PURPLE)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.JAR_EMPTY),conditionsFromItem(ModItems.JAR_EMPTY))
                .criterion(hasItem(ModItems.GRAPES_PURPLE),conditionsFromItem(ModItems.GRAPES_PURPLE))
                .criterion(hasItem(Items.SUGAR),conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JAR_PURPLE) + "_recipe"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR_RED)
                .input(ModItems.JAR_EMPTY)
                .input(ModItems.GRAPES_RED)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.JAR_EMPTY),conditionsFromItem(ModItems.JAR_EMPTY))
                .criterion(hasItem(ModItems.GRAPES_RED),conditionsFromItem(ModItems.GRAPES_RED))
                .criterion(hasItem(Items.SUGAR),conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JAR_RED) + "_recipe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR_EMPTY)
                .pattern("G G")
                .pattern("G G")
                .pattern("GGG")
                .input('G', Items.GLASS)
                .criterion(hasItem(Items.GLASS),conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JAR_EMPTY) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WINE_BOTTLE_EMPTY)
                .pattern("G G")
                .pattern("G G")
                .pattern(" G ")
                .input('G', Items.GLASS)
                .criterion(hasItem(Items.GLASS),conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WINE_BOTTLE_EMPTY) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WINE_GLASS_ITEM)
                .pattern(" B ")
                .pattern(" P ")
                .pattern("GGG")
                .input('B', Items.GLASS_BOTTLE)
                .input('P', Items.GLASS_PANE)
                .input('G', Items.GLASS)
                .criterion(hasItem(Items.GLASS_BOTTLE),conditionsFromItem(Items.GLASS))
                .criterion(hasItem(Items.GLASS_PANE),conditionsFromItem(Items.GLASS))
                .criterion(hasItem(Items.GLASS),conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WINE_GLASS_ITEM) + "_recipe"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_BLUE, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_BLUE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_GREEN, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_GREEN);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_PURPLE, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_PURPLE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_RED, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_RED);


    }
}
