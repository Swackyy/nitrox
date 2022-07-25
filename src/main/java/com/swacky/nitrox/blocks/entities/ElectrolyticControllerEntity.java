package com.swacky.nitrox.blocks.entities;

import com.swacky.nitrox.core.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ElectrolyticControllerEntity extends BlockEntity implements BlockEntityTicker<ElectrolyticControllerEntity> {
    public ElectrolyticControllerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTROLYTIC_CONTROLLER.get(), pos, state);
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state, ElectrolyticControllerEntity block) {

    }
}
