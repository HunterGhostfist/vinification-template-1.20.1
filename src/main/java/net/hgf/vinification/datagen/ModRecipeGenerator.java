package net.hgf.vinification.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
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
        //seeds from grapes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SEEDS_BLUE)
                .input(ModItems.GRAPES_BLUE)
                .criterion(hasItem(ModItems.GRAPES_BLUE),conditionsFromItem(ModItems.GRAPES_BLUE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SEEDS_BLUE) + "_from_grapes"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SEEDS_GREEN)
                .input(ModItems.GRAPES_GREEN)
                .criterion(hasItem(ModItems.GRAPES_GREEN),conditionsFromItem(ModItems.GRAPES_GREEN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SEEDS_GREEN) + "_from_grapes"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SEEDS_PURPLE)
                .input(ModItems.GRAPES_PURPLE)
                .criterion(hasItem(ModItems.GRAPES_PURPLE),conditionsFromItem(ModItems.GRAPES_PURPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SEEDS_PURPLE) + "_from_grapes"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SEEDS_RED)
                .input(ModItems.GRAPES_RED)
                .criterion(hasItem(ModItems.GRAPES_RED),conditionsFromItem(ModItems.GRAPES_RED))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SEEDS_RED) + "_from_grapes"));

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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AGING_BARREL)
                .pattern("LRL")
                .pattern("RBR")
                .pattern("LRL")
                .input('L', ItemTags.LOGS)
                .input('R', ModItems.JAR_RESIN)
                .input('B', Items.BARREL)
                .criterion(hasItem(ModItems.JAR_RESIN),conditionsFromItem(ModItems.JAR_RESIN))
                .criterion(hasItem(Items.BARREL),conditionsFromItem(Items.BARREL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AGING_BARREL) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STOMPING_BARREL)
                .pattern("SBS")
                .pattern("SSS")
                .input('S', ItemTags.WOODEN_SLABS)
                .input('B', Items.BARREL)
                .criterion(hasItem(Items.BARREL),conditionsFromItem(Items.BARREL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STOMPING_BARREL) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TAPPER)
                .pattern(" I ")
                .pattern(" B ")
                .pattern(" S ")
                .input('I', Items.IRON_INGOT)
                .input('B', Items.BUCKET)
                .input('S', Items.SMOOTH_STONE_SLAB)
                .criterion(hasItem(Items.BUCKET),conditionsFromItem(Items.BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TAPPER) + "_recipe"));


        //Keg Recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_ACACIA)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.ACACIA_LOG)
                .input('S', Items.ACACIA_SLAB)
                .criterion(hasItem(Items.ACACIA_LOG),conditionsFromItem(Items.ACACIA_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_ACACIA) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_BIRCH)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.BIRCH_LOG)
                .input('S', Items.BIRCH_SLAB)
                .criterion(hasItem(Items.BIRCH_LOG),conditionsFromItem(Items.BIRCH_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_BIRCH) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_CHERRY)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.CHERRY_LOG)
                .input('S', Items.CHERRY_SLAB)
                .criterion(hasItem(Items.CHERRY_LOG),conditionsFromItem(Items.CHERRY_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_CHERRY) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_CRIMSON)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.CRIMSON_HYPHAE)
                .input('S', Items.CRIMSON_SLAB)
                .criterion(hasItem(Items.CRIMSON_HYPHAE),conditionsFromItem(Items.CRIMSON_HYPHAE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_CRIMSON) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_DARK_OAK)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.DARK_OAK_LOG)
                .input('S', Items.DARK_OAK_SLAB)
                .criterion(hasItem(Items.DARK_OAK_LOG),conditionsFromItem(Items.DARK_OAK_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_DARK_OAK) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_JUNGLE)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.JUNGLE_LOG)
                .input('S', Items.JUNGLE_SLAB)
                .criterion(hasItem(Items.JUNGLE_LOG),conditionsFromItem(Items.JUNGLE_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_JUNGLE) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_MANGROVE)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.MANGROVE_LOG)
                .input('S', Items.MANGROVE_SLAB)
                .criterion(hasItem(Items.MANGROVE_LOG),conditionsFromItem(Items.MANGROVE_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_MANGROVE) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_OAK)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.OAK_LOG)
                .input('S', Items.OAK_SLAB)
                .criterion(hasItem(Items.OAK_LOG),conditionsFromItem(Items.OAK_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_OAK) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_SPRUCE)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.SPRUCE_LOG)
                .input('S', Items.SPRUCE_SLAB)
                .criterion(hasItem(Items.SPRUCE_LOG),conditionsFromItem(Items.SPRUCE_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_SPRUCE) + "_recipe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.KEG_WARPED)
                .pattern("LLL")
                .pattern("S S")
                .pattern("LLL")
                .input('L', Items.WARPED_HYPHAE)
                .input('S', Items.WARPED_SLAB)
                .criterion(hasItem(Items.WARPED_HYPHAE),conditionsFromItem(Items.WARPED_HYPHAE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.KEG_WARPED) + "_recipe"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_BLUE, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_BLUE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_GREEN, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_GREEN);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_PURPLE, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_PURPLE);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAPES_RED, RecipeCategory.MISC, ModBlocks.GRAPE_CRATE_RED);


    }
}
