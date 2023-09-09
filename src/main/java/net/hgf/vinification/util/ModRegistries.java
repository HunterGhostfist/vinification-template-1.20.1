package net.hgf.vinification.util;

import net.hgf.vinification.item.ModItems;
import net.minecraft.block.ComposterBlock;

public class ModRegistries {
    public static  void registerModStuffs(){
        registerModCompostables();
    }
    public static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_BLUE, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_GREEN, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_PURPLE, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPES_RED, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_BLUE, 0.2f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_GREEN, 0.2f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_PURPLE, 0.2f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SEEDS_RED, 0.2f);
    }
}