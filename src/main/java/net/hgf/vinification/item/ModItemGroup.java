package net.hgf.vinification.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hgf.vinification.Vinification;
import net.hgf.vinification.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup WINE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Vinification.MOD_ID, "wine"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.wine"))
                    .icon(() -> new ItemStack(ModItems.WINE_BOTTLE_PURPLE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CHEESE_BLOCK);
                        entries.add(ModItems.GRAPES_BLUE);
                        entries.add(ModItems.GRAPES_GREEN);
                        entries.add(ModItems.GRAPES_PURPLE);
                        entries.add(ModItems.GRAPES_RED);
                        entries.add(ModItems.JAR_BLUE);
                        entries.add(ModItems.JAR_EMPTY);
                        entries.add(ModItems.JAR_GREEN);
                        entries.add(ModItems.JAR_PURPLE);
                        entries.add(ModItems.JAR_RED);
                        entries.add(ModItems.JAR_RESIN);
                        entries.add(ModItems.SAP);
                        entries.add(ModItems.WINE_BOTTLE_BLUE);
                        entries.add(ModItems.WINE_BOTTLE_BLUE_QUALITY);
                        entries.add(ModItems.WINE_BOTTLE_EMPTY);
                        entries.add(ModItems.WINE_BOTTLE_GREEN);
                        entries.add(ModItems.WINE_BOTTLE_GREEN_QUALITY);
                        entries.add(ModItems.WINE_BOTTLE_HONEY);
                        entries.add(ModItems.WINE_BOTTLE_PURPLE);
                        entries.add(ModItems.WINE_BOTTLE_PURPLE_QUALITY);
                        entries.add(ModItems.WINE_BOTTLE_RED);
                        entries.add(ModItems.WINE_BOTTLE_RED_QUALITY);
                        entries.add(ModItems.WINE_GLASS_ITEM);
                        entries.add(ModItems.SEEDS_BLUE);
                        entries.add(ModItems.SEEDS_GREEN);
                        entries.add(ModItems.SEEDS_PURPLE);
                        entries.add(ModItems.SEEDS_RED);

                        entries.add(ModBlocks.GRAPE_CRATE_BLUE);
                        entries.add(ModBlocks.GRAPE_CRATE_GREEN);
                        entries.add(ModBlocks.GRAPE_CRATE_PURPLE);
                        entries.add(ModBlocks.GRAPE_CRATE_RED);
                        entries.add(ModBlocks.AGING_BARREL);
                        entries.add(ModBlocks.TAPPER);
                        entries.add(ModBlocks.STOMPING_BARREL);

                        entries.add(ModBlocks.KEG_ACACIA);
                        entries.add(ModBlocks.KEG_BIRCH);
                        entries.add(ModBlocks.KEG_CHERRY);
                        entries.add(ModBlocks.KEG_CRIMSON);
                        entries.add(ModBlocks.KEG_DARK_OAK);
                        entries.add(ModBlocks.KEG_JUNGLE);
                        entries.add(ModBlocks.KEG_MANGROVE);
                        entries.add(ModBlocks.KEG_OAK);
                        entries.add(ModBlocks.KEG_SPRUCE);
                        entries.add(ModBlocks.KEG_WARPED);


                    }).build());


    public static void registerItemGroups() {

    }
}
