package net.eravern.cs_mod.world;

import net.eravern.cs_mod.CSMod;
import net.eravern.cs_mod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRISMARINE_ORE_KEY = registerKey("prismarine_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BONES_ORE_KEY = registerKey("bones_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMOLDERING_ORE_KEY = registerKey("smoldering_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_CALCIUM_ORE_KEY = registerKey("ender_calcium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORES_KEY = registerKey("sulfur_ores");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherstoneReplaceables = new BlockMatchRuleTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);


        List<OreFeatureConfig.Target> overworldPrismarineOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PRISMARINE_ORE.getDefaultState()));

        register(context, PRISMARINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPrismarineOres, 5));

        List<OreFeatureConfig.Target> overworldBonesOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.BONES_ORE.getDefaultState()));

        register(context, BONES_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBonesOres, 6));

        List<OreFeatureConfig.Target> netherSmolderingOres =
                List.of(OreFeatureConfig.createTarget(netherstoneReplaceables, ModBlocks.SMOLDERING_NETHERRACK.getDefaultState()));

        register(context, SMOLDERING_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSmolderingOres, 7));

        List<OreFeatureConfig.Target> endCalciumOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.ENDER_CALCIUM_ORE.getDefaultState()));

        register(context, ENDER_CALCIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCalciumOres, 5));

        List<OreFeatureConfig.Target> overworldSulfurOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SULFUR_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SULFUR_ORE.getDefaultState()));


            register(context, SULFUR_ORES_KEY, Feature.ORE, new OreFeatureConfig(overworldSulfurOres, 6));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CSMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}