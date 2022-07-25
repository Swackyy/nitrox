package com.swacky.nitrox.blocks;

import com.swacky.nitrox.multiblock.electrolysis.BaseElectrolysisBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class QuartzInfusedGlass extends BaseElectrolysisBlock {
    public QuartzInfusedGlass() {
        super(BlockBehaviour.Properties.of(Material.GLASS)
                .strength(4f, 4f)
                .noOcclusion()
                .sound(SoundType.GLASS));
    }
}
