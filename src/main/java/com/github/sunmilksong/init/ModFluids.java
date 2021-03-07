package com.github.sunmilksong.init;

import com.github.sunmilksong.blocks.material.Materials;
import com.github.sunmilksong.fluids.BlockFluid;
import com.github.sunmilksong.fluids.FluidBase;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNMILKSONG
 */
public class ModFluids {

    public static final List<Fluid> FLUIDS = new ArrayList<>();


    public static final FluidBase SPIRIT = new
            FluidBase("spirit_fluid", 1000, 1000, 0, 300, false, Materials.SPIRIT, 255255255 | 0xFF000000);

    public static void registerFluids() {
        registerFluid(SPIRIT);
    }

    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }


    public static void registerModelFluid(){
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SPIRIT), stack -> new ModelResourceLocation("soulmagic:spirit_fluid", "fluid"));
        ModelLoader.setCustomStateMapper(ModBlocks.SPIRIT, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation("soulmagic:spirit_fluid", "fluid");
            }
        });
    }

}

