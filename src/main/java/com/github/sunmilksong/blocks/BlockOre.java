package com.github.sunmilksong.blocks;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

import net.minecraft.world.World;

import javax.annotation.Nonnull;

import java.util.Random;

/**
 * @author SUNMILKSONG
 */
public class BlockOre extends BlockSk {

    public BlockOre(String name, String toolClass, int level, float hardness) {
        super(name, Material.ROCK);

        this.setHarvestLevel(toolClass, level);
        this.setSoundType(SoundType.STONE);
        this.setHardness(hardness);

        ModBlocks.BLOCKS.add(this);
    }


    /**
     * 设定掉落的物品
     *
     * @param state   方块状态
     * @param rand
     * @param fortune
     * @return item
     */

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        //if (this == ModBlocks.SOLID_ORE)
        return ModItems.SOUL;
    }

    /**
     * 设定矿石挖掘后物品的掉落数量
     * @param random
     * @return int
     */
    @Override
    public int quantityDropped(Random random) {
        return 3;
    }

    /**
     *设定鼠标中键选取
     * @param state
     * @param target
     * @param world
     * @param pos
     * @param player
     * @return ItemStack
     */

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this);
    }
}
