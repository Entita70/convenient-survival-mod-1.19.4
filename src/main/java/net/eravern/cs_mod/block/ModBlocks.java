package net.eravern.cs_mod.block;

import net.eravern.cs_mod.CSMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block SMOLDERING_NETHERRACK = registerBlock("smoldering_netherrack",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).sounds(BlockSoundGroup.NETHER_ORE).strength(2.5f).requiresTool(),
                    UniformIntProvider.create(4, 8)));

    public static final Block PRISMARINE_ORE = registerBlock("prismarine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).sounds(BlockSoundGroup.STONE).strength(3.5f).requiresTool(),
                    UniformIntProvider.create(2, 6)));

    public static final Block BONES_ORE = registerBlock("bones_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE).sounds(BlockSoundGroup.STONE).strength(2.5f).requiresTool(),
                    UniformIntProvider.create(1, 3)));

    public static final Block ENDER_CALCIUM_ORE = registerBlock("ender_calcium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(5, 8)));

    public static final Block SMOLDERING_COAL_BLOCK = registerBlock("smoldering_coal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sounds(BlockSoundGroup.STONE).strength(4.0f).requiresTool()));

    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).sounds(BlockSoundGroup.STONE).strength(3.0f).requiresTool(),
                    UniformIntProvider.create(2, 5)));

    public static final Block DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).sounds(BlockSoundGroup.STONE).strength(4.5f).requiresTool(),
                    UniformIntProvider.create(2, 5)));

    public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sounds(BlockSoundGroup.STONE).strength(4.0f).requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CSMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CSMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        CSMod.LOGGER.info("Registering ModBlocks for " + CSMod.MOD_ID);
    }

}
