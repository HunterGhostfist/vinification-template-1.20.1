package net.hgf.vinification;

import net.fabricmc.api.ModInitializer;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.block.entity.ModBlockEntities;
import net.hgf.vinification.effect.ModEffects;
import net.hgf.vinification.item.ModItemGroup;
import net.hgf.vinification.item.ModItems;
import net.hgf.vinification.recipe.ModRecipes;
import net.hgf.vinification.screen.ModScreenHandlers;
import net.hgf.vinification.util.ModAttackEventHandler;
import net.hgf.vinification.util.ModLootTableModifiers;
import net.hgf.vinification.util.ModRegistries;
import net.hgf.vinification.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vinification implements ModInitializer {
	public static final String MOD_ID = "vinification";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Vinification says Hello");

		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
		ModLootTableModifiers.modifyLootTables();

		ModEffects.registerEffects();

		ModAttackEventHandler.registerEvents();
		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerScreenHandler();
		ModRecipes.registerRecipes();

		ModVillagers.registerVillagers();

	}
		public static String makeStringID(String name) {
		return MOD_ID + ":" + name;
	}
}