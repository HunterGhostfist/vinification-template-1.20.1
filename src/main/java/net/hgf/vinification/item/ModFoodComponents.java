package net.hgf.vinification.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent GRAPES_BLUE = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
    public static final FoodComponent GRAPES_GREEN = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
    public static final FoodComponent GRAPES_PURPLE = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
    public static final FoodComponent GRAPES_RED = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
    public static final FoodComponent JAR_BLUE = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).build();
    public static final FoodComponent JAR_GREEN = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).build();
    public static final FoodComponent JAR_PURPLE = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).build();
    public static final FoodComponent JAR_RED = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).build();

}
