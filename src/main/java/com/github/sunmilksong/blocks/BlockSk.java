package com.github.sunmilksong.blocks;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * @author SUNMILKSONG
 */
public class BlockSk extends Block {

    public BlockSk(String name, Material material, SoundType soundType) {

        super(material);

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setSoundType(soundType);

        ModBlocks.BLOCKS.add(this);
    }
}


