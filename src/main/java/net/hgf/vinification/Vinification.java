package net.hgf.vinification;

import net.fabricmc.api.ModInitializer;

import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.item.ModItemGroup;
import net.hgf.vinification.item.ModItems;
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
	}

}