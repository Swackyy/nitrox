package com.swacky.nitrox.multiblock.nanodrill;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class BaseNanoDrillBlock extends Block {
    public BaseNanoDrillBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        return InteractionResult.SUCCESS;
    }

    public static class DrillHead extends BaseNanoDrillBlock {
        public DrillHead(Properties properties) {
            super(properties);
        }
    }
}
