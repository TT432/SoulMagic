package com.github.sunmilksong.items;


import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.Reference;

import net.minecraft.advancements.CriteriaTriggers;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;

import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;


/**
 * @author SUNMILKSONG
 */


public class ItemSd extends ItemSeeds {

    private final Block plants;

    private final Block plantBlock;

    public ItemSd(String name, Block plants, Block plantBlock) {
        super(plants, plantBlock);

        this.plants = plants;
        this.plantBlock = plantBlock;

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        //主手放置,副手无效
        ItemStack itemstack = player.getHeldItem(hand);

        //获取当前块位置
        IBlockState state = worldIn.getBlockState(pos);

        //获取耕地方块
        if (state.getBlock() == this.plantBlock

                //EnumFacing.UP表示种植时站立的方位，up表示站在方块顶部种植，如果是其他值则需要站在对应面种植
                //但最后作物始终朝上
                && facing == EnumFacing.UP

                //传入pos pos参数由EnumFacing.UP通过offset转换成pos,传入EnumFacing.UP,传入物品堆
                && player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {

            //在世界中放置作物,获取默认状态
            worldIn.setBlockState(pos.up(), this.plants.getDefaultState());

            if (player instanceof EntityPlayerMP) {

                //标准事件触发器
                //事件类型放置方块(通过物品放置)
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos.up(), itemstack);
            }

            itemstack.shrink(1);

            return EnumActionResult.SUCCESS;
        } else {

            return EnumActionResult.FAIL;
        }
    }
}