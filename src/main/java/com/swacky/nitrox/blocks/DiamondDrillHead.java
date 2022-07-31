package com.swacky.nitrox.blocks;

import com.swacky.nitrox.blocks.entities.DiamondDrillHeadEntity;
import com.swacky.nitrox.multiblock.nanodrill.BaseNanoDrillBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class DiamondDrillHead extends BaseNanoDrillBlock.DrillHead implements EntityBlock {
    public static final DirectionProperty DIRECTION = DirectionalBlock.FACING;
    public DiamondDrillHead(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(DIRECTION, Direction.UP));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new DiamondDrillHeadEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level world, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return world.isClientSide ? null : (level0, pos, state0, blockEntity) -> ((DiamondDrillHeadEntity) blockEntity).tick(world, pos, state, new DiamondDrillHeadEntity(pos, state));
    }

    @Override
    public void animateTick(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Random rand) {
        level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, level.getBlockState(pos.below())).setPos(pos), pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5, 0, 0, 0);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(DIRECTION, context.getNearestLookingDirection().getOpposite());
    }
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
    }
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(DIRECTION)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DIRECTION);
    }


    /*@SuppressWarnings("deprecation")
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.INVISIBLE;
    }*/

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(7, 7, 0, 9, 9, 1),
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(1, 1, 10, 15, 15, 12),
            Block.box(2, 2, 8, 14, 14, 10),
            Block.box(3, 3, 6, 13, 13, 8),
            Block.box(4, 4, 3, 12, 12, 6),
            Block.box(5, 5, 2, 11, 11, 3),
            Block.box(6, 6, 1, 10, 10, 2)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(15, 7, 7, 16, 9, 9),
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 1, 1, 6, 15, 15),
            Block.box(6, 2, 2, 8, 14, 14),
            Block.box(8, 3, 3, 10, 13, 13),
            Block.box(10, 4, 4, 13, 12, 12),
            Block.box(13, 5, 5, 14, 11, 11),
            Block.box(14, 6, 6, 15, 10, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(7, 7, 15, 9, 9, 16),
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(1, 1, 4, 15, 15, 6),
            Block.box(2, 2, 6, 14, 14, 8),
            Block.box(3, 3, 8, 13, 13, 10),
            Block.box(4, 4, 10, 12, 12, 13),
            Block.box(5, 5, 13, 11, 11, 14),
            Block.box(6, 6, 14, 10, 10, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.box(0, 7, 7, 1, 9, 9),
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(10, 1, 1, 12, 15, 15),
            Block.box(8, 2, 2, 10, 14, 14),
            Block.box(6, 3, 3, 8, 13, 13),
            Block.box(3, 4, 4, 6, 12, 12),
            Block.box(2, 5, 5, 3, 11, 11),
            Block.box(1, 6, 6, 2, 10, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_U = Stream.of(
            Block.box(7, 15, 7, 9, 16, 9),
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(1, 4, 1, 15, 6, 15),
            Block.box(2, 6, 2, 14, 8, 14),
            Block.box(3, 8, 3, 13, 10, 13),
            Block.box(4, 10, 4, 12, 13, 12),
            Block.box(5, 13, 5, 11, 14, 11),
            Block.box(6, 14, 6, 10, 15, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_D = Stream.of(
            Block.box(7, 0, 7, 9, 1, 9),
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(1, 10, 1, 15, 12, 15),
            Block.box(2, 8, 2, 14, 10, 14),
            Block.box(3, 6, 3, 13, 8, 13),
            Block.box(4, 3, 4, 12, 6, 12),
            Block.box(5, 2, 5, 11, 3, 11),
            Block.box(6, 1, 6, 10, 2, 10)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(DIRECTION)) {
            case NORTH -> SHAPE_N;
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case UP -> SHAPE_U;
            case DOWN -> SHAPE_D;
        };
    }
}
