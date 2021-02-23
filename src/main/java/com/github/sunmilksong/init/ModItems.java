package com.github.sunmilksong.init;

import com.github.sunmilksong.items.ItemSd;
import com.github.sunmilksong.items.ItemSk;

import com.github.sunmilksong.tools.ToolCom;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;

import net.minecraft.item.Item;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;


/**
 * @author SUNMILKSONG
 */
@Mod.EventBusSubscriber
public class ModItems extends ToolCom {

    public static final List<Item> ITEMS = new ArrayList<>();
    //普通物品
    public static final ItemSk SOUL = new ItemSk("soul");
    public static final ItemSd SOUL_SEED = new ItemSd("soul_seed", ModBlocks.SOUL_CROP, Blocks.DIAMOND_BLOCK);
    //物品方块
    public static final ItemBlock SOLID_STATE_SOUL = new ItemBlock(ModBlocks.SOLID_STATE_SOUL);
    public static final ItemBlock SOLID_ORE = new ItemBlock(ModBlocks.SOLID_ORE);

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> register = event.getRegistry();
        //普通物品
        register.register(SOUL);
        register.register(SOUL_SEED);
        //方块物品
        register.register(setRegisterNames(SOLID_STATE_SOUL));
        register.register(setRegisterNames(SOLID_ORE));
    }

    @SideOnly(Side.CLIENT)
    private static void ModelRegistery(Item item) {

        ModelResourceLocation modelResourceLocation =
                new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistery(ModelRegistryEvent event) {
        //普通物品材质
        ModelRegistery(SOUL);
        ModelRegistery(SOUL_SEED);
        //方块物品材质
        ModelRegistery(SOLID_STATE_SOUL);
        ModelRegistery(SOLID_ORE);

    }
}

