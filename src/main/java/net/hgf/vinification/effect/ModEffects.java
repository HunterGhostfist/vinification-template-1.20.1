package net.hgf.vinification.effect;

import net.hgf.vinification.Vinification;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEffects {

    public static final StatusEffect STICKY = registerStatusEffect("sticky",
            new StickyEffect(StatusEffectCategory.BENEFICIAL, 0x78AE00));
    public static final StatusEffect INCINERATE = registerStatusEffect("incinerate",
            new IncinerateEffect(StatusEffectCategory.BENEFICIAL, 0x78AE00));
    public static final StatusEffect FROZEN = registerStatusEffect("frozen",
            new FrozenEffect(StatusEffectCategory.HARMFUL, 0x78AE00));
    public static final StatusEffect GLACIATE = registerStatusEffect("glaciate",
            new GlaciateEffect(StatusEffectCategory.BENEFICIAL, 0x78AE00));
    public static final StatusEffect VOID_CRAWLER = registerStatusEffect("void_crawler",
            new VoidCrawlerEffect(StatusEffectCategory.BENEFICIAL, 0x78AE00));
    public static final StatusEffect HUNGOVER = registerStatusEffect("hungover",
            new HungoverEffect(StatusEffectCategory.HARMFUL, 0x78AE00));

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Vinification.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        Vinification.LOGGER.info("Registering Mod Effects for " + Vinification.MOD_ID);
    }
}

//.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
//        "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f, EntityAttributeModifier
//                .Operation.MULTIPLY_TOTAL));