package com.swacky.nitrox.blocks;

import com.swacky.nitrox.multiblock.electrolysis.BaseElectrolysisBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SilicaGlass extends BaseElectrolysisBlock {
    public SilicaGlass(BlockBehaviour.Properties properties) {
        super(properties);
    }
    @Override
    public boolean skipRendering(@NotNull BlockState p_53972_, BlockState p_53973_, @NotNull Direction p_53974_) {
        return p_53973_.is(this) || super.skipRendering(p_53972_, p_53973_, p_53974_);
    }
    public @NotNull VoxelShape getVisualShape(@NotNull BlockState p_48735_, @NotNull BlockGetter p_48736_, @NotNull BlockPos p_48737_, @NotNull CollisionContext p_48738_) {
        return Shapes.empty();
    }

    public float getShadeBrightness(@NotNull BlockState p_48731_, @NotNull BlockGetter p_48732_, @NotNull BlockPos p_48733_) {
        return 1.0F;
    }

    public boolean propagatesSkylightDown(@NotNull BlockState p_48740_, @NotNull BlockGetter p_48741_, @NotNull BlockPos p_48742_) {
        return true;
    }
}
