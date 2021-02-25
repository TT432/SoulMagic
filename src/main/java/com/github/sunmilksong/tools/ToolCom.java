package com.github.sunmilksong.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

/**
 * @author SUNMILKSONG
 */
public class ToolCom {

    /**
     * 设置注册名
     */
    protected static Item setRegisterNames(ItemBlock item) {
        item.setRegistryName(Objects.requireNonNull(item.getBlock().getRegistryName()));
        return item;
    }

}