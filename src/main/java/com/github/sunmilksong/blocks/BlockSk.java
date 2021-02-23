package com.github.sunmilksong.blocks;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraft.creativetab.CreativeTabs;

/**
 * @author SUNMILKSONG
 */
public class BlockSk extends Block {

    public BlockSk(String name, Material material) {

        super(material);

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
    }
}


