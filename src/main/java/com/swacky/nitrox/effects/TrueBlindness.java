package com.swacky.nitrox.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class TrueBlindness extends MobEffect {
    public TrueBlindness() {
        super(MobEffectCategory.HARMFUL, 0xffffff);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
