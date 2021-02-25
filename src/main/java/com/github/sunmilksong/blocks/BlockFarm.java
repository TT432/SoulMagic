package com.github.sunmilksong.blocks;

import com.github.sunmilksong.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

/**
 * @author SUNMILKSONG
 */

@ParametersAreNonnullByDefault
public class BlockFarm extends BlockSk {

    public BlockFarm(String name, Material material, SoundType sound) {
        super(name, material, sound);
        this.setDefaultState(this.blockState.getBaseState());
        this.setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
    }

    protected static void turnToSand(World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, Blocks.SAND.getDefaultState());
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!this.hasLiquidOrBlock(worldIn, pos)) {
            turnToSand(worldIn, pos);
        }
    }


    private boolean hasLiquidOrBlock(World worldIn, BlockPos pos) {

        boolean hasWater = false;
        boolean hasLava = false;

        for (BlockPos.MutableBlockPos bM : BlockPos.getAllInBoxMutable
                (pos.add(-1, 0, -1), pos.add(1, -1, 1))) {

            if (worldIn.getBlockState(bM).getMaterial() == Material.WATER) {
                hasWater = true;
            }

            if (worldIn.getBlockState(bM).getMaterial() == Material.LAVA) {
                hasLava = true;
            }
        }
        return hasWater && hasLava;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);

        if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
            turnToSand(worldIn, pos);
        }
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);

        if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
            turnToSand(worldIn, pos);
        }
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Blocks.SAND.getItemDropped(Blocks.SAND.getDefaultState(), rand, fortune);
    }
}
