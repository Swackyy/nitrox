package com.swacky.nitrox.core.init;

import com.swacky.nitrox.core.Nitrox;
import com.swacky.nitrox.core.base.ItemBase;
import com.swacky.nitrox.items.FireExtinguisher;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nitrox.MODID);

    public static final RegistryObject<Item> FIRE_EXTINGUISHER = ITEMS.register("fire_extinguisher",
            () -> new FireExtinguisher(new Item.Properties().tab(Nitrox.TAB)));
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", ItemBase::new);
    public static final RegistryObject<Item> STEEL_BLEND = ITEMS.register("steel_blend", ItemBase::new);
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", ItemBase::new);
}
