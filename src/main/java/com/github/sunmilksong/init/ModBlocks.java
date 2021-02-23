package com.github.sunmilksong.init;

import com.github.sunmilksong.blocks.BlockCrop;
import com.github.sunmilksong.blocks.BlockOre;
import com.github.sunmilksong.blocks.BlockTransparent;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNMILKSONG
 */
@Mod.EventBusSubscriber
public class ModBlocks {


    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final BlockTransparent SOLID_STATE_SOUL = new
            BlockTransparent("solid_state_soul", Material.IRON);
    /**
     *<p>挖掘等级
     *<p>level 0是木/金
     *<p>level 1是石
     *<p>level 2是铁
     *<p>level 3是钻石
     */

    public static final BlockOre SOLID_ORE =  new
            BlockOre("soul_ore", "pickaxe",2,0.5f);

    public static final BlockCrop SOUL_CROP = new
            BlockCrop("soul_crop");

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(SOLID_STATE_SOUL);
        registry.register(SOLID_ORE);
        registry.register(SOUL_CROP);
    }
}