package com.swacky.nitrox.blocks.entities;

import com.swacky.nitrox.core.init.ModBlockEntities;
import com.swacky.nitrox.multiblock.PatternedMultiblock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ElectrolyticControllerEntity extends BlockEntity implements BlockEntityTicker<ElectrolyticControllerEntity> {
    public ElectrolyticControllerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTROLYTIC_CONTROLLER.get(), pos, state);
    }

    @Override
    public void tick(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ElectrolyticControllerEntity block) {
        System.out.println(PatternedMultiblock.Electrolysis.wallsValid(pos, level));
    }
}
