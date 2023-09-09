package net.hgf.vinification.damagesource;

import net.hgf.vinification.Vinification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class ModDamageSources {
    public static final RegistryKey<DamageType> FROZEN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Vinification.MOD_ID("frozen"));

    public static DamageSource create(World world, RegistryKey<DamageType> key, @Nullable Entity source, @Nullable Entity attacker) {
		return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key), source, attacker);
	}

	public static DamageSource create(World world, RegistryKey<DamageType> key, @Nullable Entity attacker) {
		return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key), attacker);
	}

	public static DamageSource create(World world, RegistryKey<DamageType> key) {
		return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
	}

	public static float handleDamage(LivingEntity entity, DamageSource source, float amount) {
		return amount;
	}
    public static void registerModDamageTypes(){
        Vinification.LOGGER.info("Registering Mod Damage Types for " + Vinification.MOD_ID);
    }
}
