package com.github.sunmilksong.fluids;

import com.github.sunmilksong.init.ModFluids;
import com.github.sunmilksong.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.Nonnull;

/**
 * @author SUNMILKSONG
 */
public class FluidBase extends Fluid {


    @Nonnull
    public FluidBase(String fluidName, int density, int viscosity, int luminosity, int temperature, boolean gaseous, Material material, int color) {

        super(fluidName,
                new ResourceLocation(Reference.MOD_ID + ":fluids/" + fluidName + "_still"),
                new ResourceLocation(Reference.MOD_ID + ":fluids/" + fluidName + "_flow"),
                new ResourceLocation(Reference.MOD_ID + ":fluids/" + fluidName + "_overlay"),color);

        this.setUnlocalizedName(Reference.MOD_ID + "." + fluidName);
        this.setDensity(density);
        this.setViscosity(viscosity);
        this.setLuminosity(luminosity);
        this.setTemperature(temperature);
        this.setGaseous(gaseous);

        ModFluids.FLUIDS.add(this);
    }

}

