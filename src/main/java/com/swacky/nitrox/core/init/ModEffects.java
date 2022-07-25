package com.swacky.nitrox.core.init;

import com.swacky.nitrox.core.Nitrox;
import com.swacky.nitrox.effects.TrueBlindness;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Nitrox.MODID);

    public static final RegistryObject<MobEffect> TRUE_BLINDNESS = EFFECTS.register("true_blindness", TrueBlindness::new);
}
