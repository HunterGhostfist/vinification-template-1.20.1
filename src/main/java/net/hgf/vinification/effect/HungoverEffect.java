package net.hgf.vinification.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.UUID;

public class HungoverEffect extends StatusEffect {
    private static final UUID DAMAGE_DEALT_MODIFIER_UUID = UUID.fromString("406259e2-b216-4e81-93f6-336b48d949af"); // Replace with a unique UUID
    private static final UUID MAX_HEALTH_MODIFIER_UUID = UUID.fromString("c880db14-ac97-40e6-ba67-c95b05131a77"); // Replace with a unique UUID
    private static final EntityAttributeModifier DAMAGE_DEALT_MODIFIER = new EntityAttributeModifier(
            DAMAGE_DEALT_MODIFIER_UUID,
            "Hungover Damage Dealt Modifier",
            -0.3, // 30% less damage
            EntityAttributeModifier.Operation.MULTIPLY_BASE
    );

    private static final EntityAttributeModifier MAX_HEALTH_MODIFIER = new EntityAttributeModifier(
            MAX_HEALTH_MODIFIER_UUID,
            "Hungover Max Health Modifier",
            -0.3, // 30% less health (1.0 is normal damage)
            EntityAttributeModifier.Operation.MULTIPLY_BASE
    );
    protected HungoverEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getEntityWorld();
        BlockPos entityPos = entity.getBlockPos();

// Check if it's daytime and there are no blocks above the entity OR if you're on a block with light level 12 or more
        boolean isDaytime = world.getTimeOfDay() >= 0 && world.getTimeOfDay() < 12000;
        boolean isDaytimeAndSkyVisible = isDaytime && isExposedToSky(world, entityPos);
        boolean isStandingOnBrightBlock = isStandingOnBrightBlock(world, entityPos);

        // Remove the modifiers first to avoid adding them multiple times
        entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(DAMAGE_DEALT_MODIFIER_UUID);
        entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(MAX_HEALTH_MODIFIER_UUID);

        // Apply damage modifiers
if (!isDaytimeAndSkyVisible || !isStandingOnBrightBlock) {
    entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).addTemporaryModifier(DAMAGE_DEALT_MODIFIER);
    entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(MAX_HEALTH_MODIFIER);
} else {
    entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).addTemporaryModifier(DAMAGE_DEALT_MODIFIER);
    entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(MAX_HEALTH_MODIFIER);

                // Apply a 30% slowdown effect
                double slowdownFactor = 0.7; // 30% slowdown (adjust as needed)
                Vec3d motion = entity.getVelocity();
                entity.setVelocity(motion.x * slowdownFactor, motion.y * 1, motion.z * slowdownFactor);
            }

            super.applyUpdateEffect(entity, amplifier);
        }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        // Remove the modifiers when the effect is removed
        entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(DAMAGE_DEALT_MODIFIER);
        entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(MAX_HEALTH_MODIFIER);

        super.onRemoved(entity, attributes, amplifier);
    }


    private boolean isExposedToSky(World world, BlockPos pos) {
        // Check if there are no non-air blocks directly above the entity
        for (int i = 1; i <= 64; i++) { // You can adjust the height based on your requirements
            BlockPos checkPos = pos.up(i);
            if (!world.isAir(checkPos) && world.getBlockState(checkPos).getBlock() != Blocks.WATER) {
                return false;
            }
        }
        return true;
    }
    private boolean isStandingOnBrightBlock(World world, BlockPos pos) {
    // Check if the block directly below the entity has a light level of 12 or more
    BlockPos BlockPos = pos;
    int lightLevel = world.getLightLevel(BlockPos);
    return lightLevel >= 12;
}
}
