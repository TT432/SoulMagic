package com.github.sunmilksong.items;

import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author SUNMILKSONG
 */
public class ItemBase extends Item {

    public ItemBase(String name) {
        super();

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }
}