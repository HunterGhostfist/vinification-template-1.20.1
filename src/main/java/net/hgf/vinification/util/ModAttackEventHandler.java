package net.hgf.vinification.util;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.hgf.vinification.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.ActionResult;

public class ModAttackEventHandler {
    public static void registerEvents() {
        // Register an event listener for player attacks
        AttackEntityCallback.EVENT.register((player, world, hand, target, entityHitResult) -> {
            if (target instanceof LivingEntity) {
                // Check if the player has the effect that sets mobs on fire
                if (player.hasStatusEffect(ModEffects.INCINERATE)) {
                    // Set the targeted mob on fire
                    ((LivingEntity) target).setOnFireFor(5); // Set on fire for 5 seconds (adjust as needed)
                }
            }
            return ActionResult.PASS; // Continue with default attack behavior
        });
        AttackEntityCallback.EVENT.register((player, world, hand, target, entityHitResult) -> {
            if (target instanceof LivingEntity) {
                // Check if the player has the effect that sets mobs to be frozen
                if (player.hasStatusEffect(ModEffects.GLACIATE)) {
                    // Set the targeted mob frozen
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.FROZEN, 200)); // Set Frozen for 10 (in ticks) seconds (adjust as needed)
                }
            }
            return ActionResult.PASS; // Continue with default attack behavior
        });
    }
}
