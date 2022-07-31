package com.swacky.nitrox.core.init;

import com.swacky.nitrox.core.Nitrox;
import com.swacky.nitrox.core.base.BlockItemBase;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nitrox.MODID);

    public static final RegistryObject<BlockItem> MAGNESITE = BLOCK_ITEMS.register("magnesite",
            () -> new BlockItemBase(ModBlocks.MAGNESITE.get()));
    public static final RegistryObject<BlockItem> MAGNESIUM_OXIDE = BLOCK_ITEMS.register("magnesium_oxide",
            () -> new BlockItemBase(ModBlocks.MAGNESIUM_OXIDE.get()));
    public static final RegistryObject<BlockItem> MAGNESIUM = BLOCK_ITEMS.register("magnesium",
            () -> new BlockItemBase(ModBlocks.MAGNESIUM.get()));
    public static final RegistryObject<BlockItem> ELECTROLYTIC_CONTROLLER = BLOCK_ITEMS.register("electrolytic_controller",
            () -> new BlockItemBase(ModBlocks.ELECTROLYTIC_CONTROLLER.get()));
    public static final RegistryObject<BlockItem> QUARTZ_INFUSED_GLASS = BLOCK_ITEMS.register("quartz_infused_glass",
            () -> new BlockItemBase(ModBlocks.SILICA_GLASS.get()));
    public static final RegistryObject<BlockItem> OBSIDIAN_GLASS = BLOCK_ITEMS.register("obsidian_glass",
            () -> new BlockItemBase(ModBlocks.OBSIDIAN_GLASS.get()));
    public static final RegistryObject<BlockItem> ZINC_ORE = BLOCK_ITEMS.register("zinc_ore",
            () -> new BlockItemBase(ModBlocks.ZINC_ORE.get()));
    public static final RegistryObject<BlockItem> ANCIENT_FOSSIL = BLOCK_ITEMS.register("ancient_fossil",
            () -> new BlockItemBase(ModBlocks.ANCIENT_FOSSIL.get()));
    public static final RegistryObject<BlockItem> DIAMOND_DRILL_HEAD = BLOCK_ITEMS.register("diamond_drill_head",
            () -> new BlockItemBase(ModBlocks.DIAMOND_DRILL_HEAD.get()));
}
