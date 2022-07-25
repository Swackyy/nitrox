package com.swacky.nitrox.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.swacky.nitrox.core.init.ModEffects;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class MixinGui {
    protected static final ResourceLocation BLINDNESS_BLUR_LOCATION = new ResourceLocation("./textures/misc/trueblindnessblur.png");

    @Inject(at = @At(value = "HEAD"), method = "render")
    protected void onRender(PoseStack p_93031_, float p_93032_, CallbackInfo info) {

        Gui gui = (Gui)((Object)this);

        assert gui.minecraft.player != null;
        if (gui.minecraft.player.hasEffect(ModEffects.TRUE_BLINDNESS.get())) {
            gui.renderTextureOverlay(BLINDNESS_BLUR_LOCATION, 1f);
        }
    }
}
