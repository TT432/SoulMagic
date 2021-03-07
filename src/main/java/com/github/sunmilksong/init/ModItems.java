package com.github.sunmilksong.init;

import com.github.sunmilksong.items.ItemSeed;
import com.github.sunmilksong.items.ItemBase;
import com.github.sunmilksong.tools.ToolCom;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
import java.util.Objects;

import static com.github.sunmilksong.init.ModFluids.registerFluids;
import static com.github.sunmilksong.init.ModFluids.registerModelFluid;


/**
 * @author SUNMILKSONG
 */
@Mod.EventBusSubscriber
public class ModItems extends ToolCom {

    public static final List<Item> ITEMS = new ArrayList<>();
    //普通物品

    public static final ItemBase SOUL = new ItemBase("soul");

    public static final ItemSeed SOUL_SEED = new ItemSeed("soul_seed", ModBlocks.SOUL_CROP, ModBlocks.SOUL_SAND);

    //物品方块

    public static final ItemBlock SOLID_STATE_SOUL = new ItemBlock(ModBlocks.SOLID_STATE_SOUL);

    public static final ItemBlock SOLID_ORE = new ItemBlock(ModBlocks.SOLID_ORE);

    public static final ItemBlock SOUL_SAND = new ItemBlock(ModBlocks.SOUL_SAND);


}

