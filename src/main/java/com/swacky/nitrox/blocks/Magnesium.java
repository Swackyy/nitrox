package com.swacky.nitrox.blocks;

import com.swacky.nitrox.core.init.ModBlocks;
import com.swacky.nitrox.core.init.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Magnesium extends Block {
    public Magnesium(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        boolean hasTag = Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(ModTags.Blocks.INFERNAL_FIRE_BURNABLE).contains(level.getBlockState(pos).getBlock());
        if (player.getItemInHand(hand).is(Items.FLINT_AND_STEEL)) {
            if (level.getBlockState(pos.above()).is(ModBlocks.MAGNESIUM.get()) || Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(ModTags.Blocks.INFERNAL_FIRE_BURNABLE).contains(level.getBlockState(pos.above()).getBlock())) {
                while (level.getBlockState(pos).is(ModBlocks.MAGNESIUM.get())) {
                    pos = pos.above();
                    hasTag = Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(ModTags.Blocks.INFERNAL_FIRE_BURNABLE).contains(level.getBlockState(pos).getBlock());
                }
                if(hasTag) {
                    level.setBlock(pos, Blocks.FIRE.defaultBlockState(), 0);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
