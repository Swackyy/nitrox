package com.swacky.nitrox.core.init;

import com.swacky.nitrox.blocks.InfernalFire;
import com.swacky.nitrox.blocks.Magnesium;
import com.swacky.nitrox.blocks.MagnesiumOxide;
import com.swacky.nitrox.blocks.QuartzInfusedGlass;
import com.swacky.nitrox.core.Nitrox;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
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
    public static final RegistryObject<Block> QUARTZ_INFUSED_GLASS = BLOCKS.register("quartz_infused_glass", QuartzInfusedGlass::new);
}
