package com.github.sunmilksong.fluids;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author SUNMILKSONG
 */

@ParametersAreNonnullByDefault
public class BlockFluid extends BlockFluidClassic {

    public BlockFluid(String name, Fluid fluid, Material material, MapColor mapColor) {
        super(fluid, material, mapColor);

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
}


