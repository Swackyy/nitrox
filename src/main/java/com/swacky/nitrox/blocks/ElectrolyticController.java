package com.swacky.nitrox.blocks;

import com.swacky.nitrox.blocks.entities.ElectrolyticControllerEntity;
import com.swacky.nitrox.multiblock.electrolysis.BaseElectrolysisBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElectrolyticController extends BaseElectrolysisBlock implements EntityBlock {
    public ElectrolyticController(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ElectrolyticControllerEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level world, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return world.isClientSide ? null : (level0, pos, state0, blockEntity) -> ((ElectrolyticControllerEntity) blockEntity).tick(world, pos, state, new ElectrolyticControllerEntity(pos, state));
    }
}
