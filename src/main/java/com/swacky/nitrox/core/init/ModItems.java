package com.swacky.nitrox.core.init;

import com.swacky.nitrox.core.Nitrox;
import com.swacky.nitrox.items.FireExtinguisher;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nitrox.MODID);

    public static final RegistryObject<Item> FIRE_EXTINGUISHER = ITEMS.register("fire_extinguisher", () -> new FireExtinguisher(new Item.Properties().tab(Nitrox.TAB)));
}
