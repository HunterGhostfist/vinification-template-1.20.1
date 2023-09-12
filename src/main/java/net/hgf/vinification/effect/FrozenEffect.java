package net.hgf.vinification.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class FrozenEffect extends StatusEffect {
    public FrozenEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.setInPowderSnow(true);
        entity.setVelocity(0.0, 0.0, 0.0);
       // entity.damage(new DamageSource(.getSource()));
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier){
        // Apply a new status effect when this effect is removed
        StatusEffectInstance hungoverEffect = new StatusEffectInstance(ModEffects.HUNGOVER, 7*20*60, amplifier);
        entity.addStatusEffect(hungoverEffect);

        super.onRemoved(entity, attributes, amplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
