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
}
