package net.hgf.vinification.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.hgf.vinification.Vinification;
import net.hgf.vinification.block.ModBlocks;
import net.hgf.vinification.util.ModTags;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<StompingBarrelBlockEntity> STOMPING_BARREL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "stomping_barrel_block_entity"),
                    FabricBlockEntityTypeBuilder.create(StompingBarrelBlockEntity::new,
                            ModBlocks.STOMPING_BARREL).build(null));

    public static final BlockEntityType<KegAcaciaBlockEntity> KEG_ACACIA_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "acacia_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegAcaciaBlockEntity::new,
                            ModBlocks.KEG_ACACIA).build(null));

    public static final BlockEntityType<KegBirchBlockEntity> KEG_BIRCH_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "birch_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegBirchBlockEntity::new,
                            ModBlocks.KEG_BIRCH).build(null));

    public static final BlockEntityType<KegCherryBlockEntity> KEG_CHERRY_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "cherry_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegCherryBlockEntity::new,
                            ModBlocks.KEG_CHERRY).build(null));

    public static final BlockEntityType<KegCrimsonBlockEntity> KEG_CRIMSON_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "crimson_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegCrimsonBlockEntity::new,
                            ModBlocks.KEG_CRIMSON).build(null));

    public static final BlockEntityType<KegDarkOakBlockEntity> KEG_DARK_OAK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "dark_oak_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegDarkOakBlockEntity::new,
                            ModBlocks.KEG_DARK_OAK).build(null));

    public static final BlockEntityType<KegJungleBlockEntity> KEG_JUNGLE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "jungle_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegJungleBlockEntity::new,
                            ModBlocks.KEG_JUNGLE).build(null));

    public static final BlockEntityType<KegMangroveBlockEntity> KEG_MANGROVE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "mangrove_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegMangroveBlockEntity::new,
                            ModBlocks.KEG_MANGROVE).build(null));

    public static final BlockEntityType<KegOakBlockEntity> KEG_OAK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "oak_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegOakBlockEntity::new,
                            ModBlocks.KEG_OAK).build(null));

    public static final BlockEntityType<KegSpruceBlockEntity> KEG_SPRUCE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "birch_spruce_entity"),
                    FabricBlockEntityTypeBuilder.create(KegSpruceBlockEntity::new,
                            ModBlocks.KEG_SPRUCE).build(null));

    public static final BlockEntityType<KegWarpedBlockEntity> KEG_WARPED_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "warped_keg_entity"),
                    FabricBlockEntityTypeBuilder.create(KegWarpedBlockEntity::new,
                            ModBlocks.KEG_WARPED).build(null));

    public static final BlockEntityType<AgingBarrelBlockEntity> AGING_BARREL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "aging_barrel_entity"),
                    FabricBlockEntityTypeBuilder.create(AgingBarrelBlockEntity::new,
                            ModBlocks.AGING_BARREL).build(null));

    public static final BlockEntityType<TapperBlockEntity> TAPPER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Vinification.MOD_ID, "tapper_entity"),
                    FabricBlockEntityTypeBuilder.create(TapperBlockEntity::new,
                            ModBlocks.TAPPER).build(null));


    public static void registerBlockEntities(){

        Vinification.LOGGER.info("Registering Block Entities for " + Vinification.MOD_ID);
    }
}
