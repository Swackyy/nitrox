package com.swacky.nitrox.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MagnesiumOxide extends GravelBlock {
    public MagnesiumOxide(Properties properties) {
        super(properties);
    }

    @Override
    public int getDustColor(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return -9999999;
    }
}
