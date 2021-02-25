package com.github.sunmilksong.blocks;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;


/**
 * @author SUNMILKSONG
 */
@ParametersAreNonnullByDefault
public class BlockCrop extends BlockCrops {

    public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, 7);


    public BlockCrop(String name) {
        super();


        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setSoundType(SoundType.PLANT);


        ModBlocks.BLOCKS.add(this);
    }

    /**
     * 创建种子
     */
    @Nonnull
    @Override
    protected Item getSeed() {
        return ModItems.SOUL_SEED;
    }

    /**
     * 创建作物掉落
     */
    @Nonnull
    @Override
    protected Item getCrop() {
        return ModItems.SOUL;
    }

    private boolean isPlantBlock(Block plantBock) {

        if (this == ModBlocks.SOUL_CROP) {
            return plantBock == ModBlocks.SOUL_SAND;
        } else {
            return false;
        }
    }

    /**
     * 支持种植的耕地
     */
    @Override
    protected boolean canSustainBush(IBlockState state) {

        if (isPlantBlock(state.getBlock())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 作物维持的耕地
     */
    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        IBlockState plantBlock = worldIn.getBlockState(pos.down());
        if (plantBlock.getBlock() == ModBlocks.SOUL_SAND) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置作物生长级别的属性
     */
    @Nonnull
    @Override
    protected PropertyInteger getAgeProperty() {

        return CROP_AGE;
    }

    /**
     * 设置作物最大生长级别的属性
     */
    @Override
    public int getMaxAge() {
        if (this == ModBlocks.SOUL_CROP) {
            return 7;
        } else {
            return 0;
        }
    }

    /**
     * 设置作物最大生长级别的属性
     */
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int i = 6;
        if (rand.nextInt(i) == 0) {
            this.checkAndDropBlock(worldIn, pos, state);
        } else {
            super.updateTick(worldIn, pos, state, rand);
        }
    }

    /**
     * 设置骨粉的最大和最小效果
     */
    @Override
    protected int getBonemealAgeIncrease(World worldIn) {

        return MathHelper.getInt(worldIn.rand, 1, 1);
    }

    /**
     * 设置作物区块状态
     */
    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CROP_AGE);
    }
}

