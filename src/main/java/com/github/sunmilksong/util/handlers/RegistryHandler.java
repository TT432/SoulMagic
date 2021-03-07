package com.github.sunmilksong.util.handlers;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;

import static com.github.sunmilksong.init.ModFluids.registerFluids;
import static com.github.sunmilksong.init.ModFluids.registerModelFluid;
import static com.github.sunmilksong.tools.ToolCom.setRegisterNames;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        registerFluids();
        for (Block block : ModBlocks.BLOCKS) {
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> register = event.getRegistry();

        //普通物品
        register.register(ModItems.SOUL);
        register.register(ModItems.SOUL_SEED);
        //方块物品
        register.register(setRegisterNames(ModItems.SOLID_STATE_SOUL));
        register.register(setRegisterNames(ModItems.SOLID_ORE));
        register.register(setRegisterNames(ModItems.SOUL_SAND));
    }

    @SideOnly(Side.CLIENT)
    private static void modelRegistery(Item item) {

        ModelResourceLocation modelResourceLocation =
                new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistery(ModelRegistryEvent event) {
        registerModelFluid();

        //普通物品材质
        modelRegistery(ModItems.SOUL);
        modelRegistery(ModItems.SOUL_SEED);
        //方块物品材质
        modelRegistery(ModItems.SOLID_STATE_SOUL);
        modelRegistery(ModItems.SOLID_ORE);
        modelRegistery(ModItems.SOUL_SAND);

    }
}
