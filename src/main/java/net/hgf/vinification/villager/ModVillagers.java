package net.hgf.vinification.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.hgf.vinification.Vinification;
import net.hgf.vinification.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> AGING_BARREL_POI_KEY = registerPoiKey("aging_barrerpoi");

    public static final PointOfInterestType AGING_BARREL_POI = registerPoi("aging_barrelpoi", ModBlocks.AGING_BARREL);

    public static final VillagerProfession SOMMELIER = registerProfession("sommelier", AGING_BARREL_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Vinification.MOD_ID, name),
                new VillagerProfession(name, entry -> true, entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CLERIC));
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(Vinification.MOD_ID, name));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(Vinification.MOD_ID, name),
                1, 1, block);
    }

    public static void registerVillagers() {
        Vinification.LOGGER.info("Registering Villagers for" + Vinification.MOD_ID);
    }
}
