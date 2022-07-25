package com.swacky.nitrox.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static void init() {
        Blocks.init();
    }

    public static class Blocks {
        public static void init(){}

        public static final TagKey<Block> FIRE_BURNABLE = tag("fire_burnable");
        public static final TagKey<Block> INFERNAL_FIRE_BURNABLE = tag("infernal_fire_burnable");
    }

    public static TagKey<Block> tag(String name)
    {
        return BlockTags.create(new ResourceLocation("nitrox", name));
    }
}
