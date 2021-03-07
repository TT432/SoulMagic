package com.github.sunmilksong.init;

import com.github.sunmilksong.blocks.BlockCrop;
import com.github.sunmilksong.blocks.BlockFarm;
import com.github.sunmilksong.blocks.BlockOre;
import com.github.sunmilksong.blocks.BlockTransparent;
import com.github.sunmilksong.blocks.material.Materials;
import com.github.sunmilksong.fluids.BlockFluid;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNMILKSONG
 */
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber
public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final BlockTransparent SOLID_STATE_SOUL = new
            BlockTransparent("solid_state_soul", Materials.IRON, SoundType.GLASS);

    public static final BlockFarm SOUL_SAND = new
            BlockFarm("soul_sand", Materials.SAND, SoundType.SAND);
    /**
     * <p>挖掘等级
     * <p>level 0是木/金
     * <p>level 1是石
     * <p>level 2是铁
     * <p>level 3是钻石
     */

    public static final BlockOre SOLID_ORE = new
            BlockOre("soul_ore", "pickaxe", 2, 0.5f, Materials.ROCK, SoundType.STONE);
    /**
     * 作物
     */
    public static final BlockCrop SOUL_CROP = new
            BlockCrop("soul_crop");

    /**
     * 流体块
     */
    public static final BlockFluid SPIRIT = new
            BlockFluid("spirit_block", ModFluids.SPIRIT, Materials.SPIRIT, MapColor.SNOW);

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
            for (Block block : ModBlocks.BLOCKS) {
                event.getRegistry().register(block);
            }
        }
    }

