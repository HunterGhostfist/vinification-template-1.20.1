package net.hgf.vinification.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.hgf.vinification.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier IGLOO_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/igloo_chest");
    private static final Identifier END_CITY_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier BASTION_TREASURE_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_treasure");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (IGLOO_STRUCTURE_CHEST_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Spawns 100% of the time
                        .with(ItemEntry.builder(ModItems.GRAPES_BLUE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.1f, 4.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_STRUCTURE_CHEST_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.65f)) // Spawns 65% of the time
                        .with(ItemEntry.builder(ModItems.GRAPES_PURPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.1f, 4.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if (BASTION_TREASURE_STRUCTURE_CHEST_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.85f)) // Spawns 65% of the time
                        .with(ItemEntry.builder(ModItems.GRAPES_RED))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.1f, 4.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


        });
    }
}
