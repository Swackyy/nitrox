package com.swacky.nitrox.core.base;

import com.swacky.nitrox.core.Nitrox;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(Nitrox.TAB));
    }
}