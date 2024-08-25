package net.eravern.cs_mod.world;

import net.eravern.cs_mod.CSMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> PRISMARINE_ORE_PLACED_KEY = registerKey("prismarine_ore_placed");
    public static final RegistryKey<PlacedFeature> BONES_ORE_PLACED_KEY = registerKey("bones_ore_placed");
    public static final RegistryKey<PlacedFeature> SMOLDERING_ORE_PLACED_KEY = registerKey("smoldering_ore_placed");
    public static final RegistryKey<PlacedFeature> ENDER_CALCIUM_ORE_PLACED_KEY = registerKey("ender_calcium_ore_placed");
    public static final RegistryKey<PlacedFeature> SULFUR_ORES_PLACED_KEY = registerKey("sulfur_ores_placed");




    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(context, PRISMARINE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PRISMARINE_ORE_KEY),
            ModOrePlacement.modifiersWithCount(7, HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(40))));

        register(context, BONES_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BONES_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))));

        register(context, SMOLDERING_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMOLDERING_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(90))));

        register(context, ENDER_CALCIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_CALCIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));

        register(context, SULFUR_ORES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SULFUR_ORES_KEY),
                ModOrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(54))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CSMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
