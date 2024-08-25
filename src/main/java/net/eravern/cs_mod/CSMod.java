package net.eravern.cs_mod;

import net.eravern.cs_mod.block.ModBlocks;
import net.eravern.cs_mod.item.ModItemGroup;
import net.eravern.cs_mod.item.ModItems;
import net.eravern.cs_mod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSMod implements ModInitializer {
    public static final String MOD_ID = "cs_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("cs_mod");

    @Override
    public void onInitialize() {


        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModWorldGeneration.generateModWorldGen();



        FuelRegistry.INSTANCE.add(ModItems.SMOLDERING_COAL, 1200);
        FuelRegistry.INSTANCE.add(ModItems.SULFUR, 1600);
        FuelRegistry.INSTANCE.add(ModBlocks.SMOLDERING_COAL_BLOCK, 10800);
        FuelRegistry.INSTANCE.add(ModBlocks.SULFUR_BLOCK, 14400);





    }

}