package net.hgf.vinification.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hgf.vinification.Vinification;
import net.hgf.vinification.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GRAPE_CRATE_BLUE = registerBlock("grape_crate_blue",
            new Block(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.BLUE)));
    public static final Block GRAPE_CRATE_GREEN = registerBlock("grape_crate_green",
            new Block(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.LIME)));
    public static final Block GRAPE_CRATE_PURPLE = registerBlock("grape_crate_purple",
            new Block(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.PURPLE)));
    public static final Block GRAPE_CRATE_RED = registerBlock("grape_crate_red",
            new Block(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.DARK_CRIMSON)));

    //grape crops
    public static final Block GRAPE_BUSH_BLUE = registerBlockWithoutBlockItem("grape_bush_blue",
            new GrapeBushBlue(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block GRAPE_BUSH_GREEN = registerBlockWithoutBlockItem("grape_bush_green",
            new GrapeBushGreen(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block GRAPE_BUSH_PURPLE = registerBlockWithoutBlockItem("grape_bush_purple",
            new GrapeBushPurple(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block GRAPE_BUSH_RED = registerBlockWithoutBlockItem("grape_bush_red",
            new GrapeBushRed(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    //cheese slices
    public static final Block CHEESE_BLOCK = registerBlock("cheese",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).mapColor(MapColor.OAK_TAN)));
//KEGS REGISTER
    public static final Block KEG_ACACIA = registerBlock("keg_acacia",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.ORANGE).nonOpaque()));
    public static final Block KEG_BIRCH = registerBlock("keg_birch",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.PALE_YELLOW).nonOpaque()));
    public static final Block KEG_CHERRY = registerBlock("keg_cherry",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_WHITE).nonOpaque()));
    public static final Block KEG_CRIMSON = registerBlock("keg_crimson",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.DARK_CRIMSON).nonOpaque()));
    public static final Block KEG_DARK_OAK = registerBlock("keg_dark_oak",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.BROWN).nonOpaque()));
    public static final Block KEG_JUNGLE = registerBlock("keg_jungle",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.DIRT_BROWN).nonOpaque()));
    public static final Block KEG_MANGROVE = registerBlock("keg_mangrove",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.SPRUCE_BROWN).nonOpaque()));
    public static final Block KEG_OAK = registerBlock("keg_oak",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.OAK_TAN).nonOpaque()));
    public static final Block KEG_SPRUCE = registerBlock("keg_spruce",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.SPRUCE_BROWN).nonOpaque()));
    public static final Block KEG_WARPED = registerBlock("keg_warped",
            new KegOak(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.DARK_AQUA).nonOpaque()));
    public static final Block AGING_BARREL = registerBlock("aging_barrel",
            new AgingBarrel(FabricBlockSettings.copyOf(Blocks.BARREL).nonOpaque()));
    public static final Block STOMPING_BARREL = registerBlock("stomping_barrel",
            new StompingBarrel(FabricBlockSettings.copyOf(Blocks.BARREL).nonOpaque()));
    public static final Block TAPPER = registerBlock("tapper",
            new Tapper(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Vinification.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Vinification.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Vinification.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Vinification.LOGGER.info("Registering ModBlocks for " + Vinification.MOD_ID);
    }
}
