package com.swacky.nitrox.core.init;

import com.swacky.nitrox.blocks.*;
import com.swacky.nitrox.core.Nitrox;
import com.swacky.nitrox.core.base.BlockBase;
import com.swacky.nitrox.core.base.UnbreakableBlockBase;
import com.swacky.nitrox.multiblock.ConstantMultiblock;
import com.swacky.nitrox.multiblock.nanodrill.BaseNanoDrillBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nitrox.MODID);

    public static final RegistryObject<Block> MAGNESITE = BLOCKS.register("magnesite",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.COLOR_PURPLE).strength(3.5f, 3.5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> MAGNESIUM_OXIDE = BLOCKS.register("magnesium_oxide",
            () -> new MagnesiumOxide(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> MAGNESIUM = BLOCKS.register("magnesium",
            () -> new Magnesium(BlockBehaviour.Properties.of(Material.METAL).color(MaterialColor.COLOR_PURPLE).strength(4f, 5.5f)));
    public static final RegistryObject<Block> INFERNAL_FIRE = BLOCKS.register("infernal_fire",
            () -> new InfernalFire(BlockBehaviour.Properties.copy(Blocks.FIRE)));
    public static final RegistryObject<Block> SILICA_GLASS = BLOCKS.register("silica_glass",
            () -> new SilicaGlass(BlockBehaviour.Properties.of(Material.GLASS).strength(4f, 4f).noOcclusion().sound(SoundType.GLASS).isViewBlocking(Blocks::never)));
    public static final RegistryObject<Block> OBSIDIAN_GLASS = BLOCKS.register("obsidian_glass",
            () -> new ObsidianGlass(BlockBehaviour.Properties.of(Material.GLASS).strength(12f, 24f).noOcclusion().sound(SoundType.GLASS).isViewBlocking(Blocks::never)));
    public static final RegistryObject<Block> ELECTROLYTIC_CONTROLLER = BLOCKS.register("electrolytic_controller",
            () -> new ElectrolyticController(BlockBehaviour.Properties.of(Material.GLASS).strength(4f, 4f).noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ZINC_ORE = BLOCKS.register("zinc_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f, 4f).sound(SoundType.STONE), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> ANCIENT_FOSSIL = BLOCKS.register("ancient_fossil", UnbreakableBlockBase::new);
    public static final RegistryObject<Block> STEEL_CASING = BLOCKS.register("steel_casing",
            () -> new BlockBase(BlockBehaviour.Properties.of(Material.METAL).strength(4f, 4f).noOcclusion().sound(SoundType.STONE)));
    public static final RegistryObject<Block> REINFORCED_CASING = BLOCKS.register("reinforced_casing",
            () -> new BaseNanoDrillBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(16f, 24f).noOcclusion().sound(SoundType.METAL)));
    public static final RegistryObject<Block> DIAMOND_DRILL_HEAD = BLOCKS.register("diamond_drill_head",
            () -> new DiamondDrillHead(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(12f, 16f).noOcclusion().sound(SoundType.METAL)));
}