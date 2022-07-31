package com.swacky.nitrox.blocks.entities;

import com.swacky.nitrox.client.render.DiamondDrillHeadRenderer;
import com.swacky.nitrox.core.init.ModBlockEntities;
import com.swacky.nitrox.multiblock.PatternedMultiblock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DiamondDrillHeadEntity extends BlockEntity implements BlockEntityTicker<DiamondDrillHeadEntity> {
    public DiamondDrillHeadEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DIAMOND_DRILL_HEAD.get(), pos, state);
    }

    @Override
    public void tick(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull DiamondDrillHeadEntity block) {
        DiamondDrillHeadRenderer.rot++;
    }
}
