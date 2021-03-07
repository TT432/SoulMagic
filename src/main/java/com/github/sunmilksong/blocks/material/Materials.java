package com.github.sunmilksong.blocks.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;


/**
 * @author SUNMILKSONG
 */
public class Materials extends Material {


    public static final Material SPIRIT = new Materials(MapColor.SNOW).setNoPushMobility().setReplaceable();

    public Materials(MapColor color) {
        super(color);
    }

    @Override
    public boolean isLiquid() {
        return true;
    }

    @Override
    public boolean blocksMovement() {
        return false;
    }


    @Override
    public boolean isSolid() {
        return false;
    }

}

