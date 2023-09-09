package net.hgf.vinification;

import net.fabricmc.api.ModInitializer;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.damagesource.ModDamageSources;
import net.hgf.vinification.effect.ModEffects;
import net.hgf.vinification.item.ModItemGroup;
import net.hgf.vinification.item.ModItems;
import net.hgf.vinification.util.AttackEventHandler;
import net.hgf.vinification.util.ModLootTableModifiers;
import net.hgf.vinification.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vinification implements ModInitializer {
	public static final String MOD_ID = "vinification";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
		ModLootTableModifiers.modifyLootTables();

		ModEffects.registerEffects();
		AttackEventHandler.registerEvents();

		ModDamageSources.registerModDamageTypes();
	}

}