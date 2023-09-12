package net.hgf.vinification.effect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VoidCrawlerEffect extends StatusEffect {
    private static final int TELEPORT_DELAY_TICKS = 10;
    private int teleportTicks = 0;

    protected VoidCrawlerEffect(StatusEffectCategory category, int color) {
        super(category, color);

    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getEntityWorld().getRegistryKey() == World.END) {
            if (entity.getY() < 1) {
                if (teleportTicks < TELEPORT_DELAY_TICKS) {
        teleportTicks++;
    } else {
        teleportToNearestSolidBlock(entity);
        teleportTicks = 0; // Reset the teleportation delay
                if (!entity.isOnGround()) {
                    teleportToNearestSolidBlock(entity);
                }
            }
            }
        }
    }
private BlockPos findNearestSolidBlock(World world, BlockPos pos, int radius) {
    // Define the search area boundaries
    int minX = pos.getX() - radius;
    int minY = Math.max(1, pos.getY() - radius); // Ensure minY is not below 1
    int minZ = pos.getZ() - radius;
    int maxX = pos.getX() + radius;
    int maxY = Math.min(world.getHeight(), pos.getY() + radius); // Limit maxY to the world height
    int maxZ = pos.getZ() + radius;

    double nearestDistanceSquared = Double.POSITIVE_INFINITY;
    BlockPos nearestSolidBlock = null;

    // Iterate through the search area
    for (int x = minX; x <= maxX; x++) {
        for (int y = minY; y <= maxY; y++) {
            for (int z = minZ; z <= maxZ; z++) {
                BlockPos checkPos = new BlockPos(x, y, z);
                if (world.getBlockState(checkPos).isSolidBlock(world, checkPos)) {
                    //Check for air
                    BlockPos aboveBlockPos = checkPos.up();
                    BlockPos aboveAboveBlockPos = aboveBlockPos.up();
                    if (world.isAir(aboveBlockPos) && world.isAir(aboveAboveBlockPos)) {
                        // Calculate the squared distance between the entity and the solid block
                        double distanceSquared = getSquaredDistance(pos, checkPos);

                        // Update the nearest solid block if closer
                        if (distanceSquared < nearestDistanceSquared) {
                            nearestDistanceSquared = distanceSquared;
                            nearestSolidBlock = checkPos;
                        }
                    }
                }
            }
        }
    }

    return nearestSolidBlock;
}

private double getSquaredDistance(BlockPos pos1, BlockPos pos2) {
    double dx = pos1.getX() - pos2.getX();
    double dy = pos1.getY() - pos2.getY();
    double dz = pos1.getZ() - pos2.getZ();
    return dx * dx + dy * dy + dz * dz;
}
private void teleportToNearestSolidBlock(LivingEntity entity) {
    // Get the world and position of the entity
    World world = entity.getEntityWorld();
    BlockPos entityPos = entity.getBlockPos();

    // Define the search radius
    int searchRadius = 64; // Adjust this value as needed

    // Search for the nearest solid block within the defined radius
    BlockPos targetPos = findNearestSolidBlock(world, entityPos, searchRadius);

    if (targetPos != null) {
        // Teleport the entity to the target position
        double targetX = targetPos.getX() + 0.5;
        double targetY = targetPos.getY() + 1.0;
        double targetZ = targetPos.getZ() + 0.5;

        // Set the entity's position
        entity.teleport(targetX, targetY, targetZ);

        //play tp sound
        world.playSound(null, targetPos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS,
                1.0F, 1.0F);

        // Spawn particles on the client side using MinecraftClient
        MinecraftClient mc = MinecraftClient.getInstance();
        for (int i = 0; i < 50; i++) { // Adjust the number of particles as needed
            double xOffset = (world.random.nextDouble() - 0.5) * 1.0; // Random offset between -1.0 and 1.0
            double yOffset = (world.random.nextDouble() - 0.5) * 2.0; // Random offset between -1.0 and 1.0
            double zOffset = (world.random.nextDouble() - 0.5) * 1.0; // Random offset between -1.0 and 1.0

            // Random velocity between -0.1 and 0.1 for each axis
            double velocityX = (world.random.nextDouble() - 0.5) * 0.2;
            double velocityY = (world.random.nextDouble() - 0.5) * 0.2;
            double velocityZ = (world.random.nextDouble() - 0.5) * 0.2;

            mc.particleManager.addParticle(
                ParticleTypes.PORTAL,
                targetX + xOffset, targetY + yOffset, targetZ + zOffset,
                velocityX, velocityY, velocityZ // Set the velocity for the particle
            );
        }
    }
}

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier){
        // Apply a new status effect when this effect is removed
        StatusEffectInstance hungoverEffect = new StatusEffectInstance(ModEffects.HUNGOVER, 7*20*60, amplifier);
        entity.addStatusEffect(hungoverEffect);

        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect ( int duration, int amplifier){
        return true;
    }
}
