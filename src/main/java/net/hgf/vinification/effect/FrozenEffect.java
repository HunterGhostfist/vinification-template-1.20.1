package net.hgf.vinification.effect;

import net.hgf.vinification.damagesource.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FrozenEffect extends StatusEffect {
    public FrozenEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.setInPowderSnow(true);
        entity.setVelocity(0.0, 0.0, 0.0);
        entity.damage(ModDamageSources.create(entity.getWorld(), ModDamageSources.FROZEN), 1f);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
