package com.swacky.nitrox.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.swacky.nitrox.blocks.entities.DiamondDrillHeadEntity;
import com.swacky.nitrox.core.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Rotation;
import net.minecraftforge.client.model.data.IModelData;
import org.jetbrains.annotations.NotNull;

public class DiamondDrillHeadRenderer implements BlockEntityRenderer<DiamondDrillHeadEntity> {
    Minecraft mc = Minecraft.getInstance();
    public static float rot;
    public DiamondDrillHeadRenderer(BlockEntityRendererProvider.Context context) {
        rot = 0;
    }


    @Override // a - combinedOverlay        b - lightLevel
    public void render(@NotNull DiamondDrillHeadEntity block, float partialTicks, PoseStack stack, @NotNull MultiBufferSource source, int a, int b) {
        stack.pushPose();
        //stack.mulPose(Vector3f.YP.rotationDegrees(rot));
        stack.translate(0, 0, 0);
        IModelData model = block.getModelData();
        mc.getBlockRenderer().renderSingleBlock(block.getBlockState(), stack, source, a, b, model);
        stack.popPose();
    }
}