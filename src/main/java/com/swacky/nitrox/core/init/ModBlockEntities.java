package com.swacky.nitrox.core.init;

import com.swacky.nitrox.blocks.entities.DiamondDrillHeadEntity;
import com.swacky.nitrox.blocks.entities.ElectrolyticControllerEntity;
import com.swacky.nitrox.core.Nitrox;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Nitrox.MODID);

    public static final RegistryObject<BlockEntityType<ElectrolyticControllerEntity>> ELECTROLYTIC_CONTROLLER = BLOCK_ENTITIES.register("electrolytic_controller",
            () -> BlockEntityType.Builder.of(ElectrolyticControllerEntity::new, ModBlocks.ELECTROLYTIC_CONTROLLER.get()).build(null));
    public static final RegistryObject<BlockEntityType<DiamondDrillHeadEntity>> DIAMOND_DRILL_HEAD = BLOCK_ENTITIES.register("diamond_drill_head",
            () -> BlockEntityType.Builder.of(DiamondDrillHeadEntity::new, ModBlocks.DIAMOND_DRILL_HEAD.get()).build(null));
}
