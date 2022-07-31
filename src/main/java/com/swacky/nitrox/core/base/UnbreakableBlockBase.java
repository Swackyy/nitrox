package com.swacky.nitrox.core.base;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class UnbreakableBlockBase extends Block {
    public UnbreakableBlockBase() {
        super(Properties.of(Material.STONE).strength(-1, 360000).noDrops());
    }
}
