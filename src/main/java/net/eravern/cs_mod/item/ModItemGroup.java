package net.eravern.cs_mod.item;

import net.eravern.cs_mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroup {

    public static void registerItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.SMOLDERING_COAL);
            entries.add(ModItems.ENDER_CALCIUM);
            entries.add(ModItems.SULFUR);



        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.SMOLDERING_NETHERRACK);
            entries.add(ModBlocks.PRISMARINE_ORE);
            entries.add(ModBlocks.ENDER_CALCIUM_ORE);
            entries.add(ModBlocks.BONES_ORE);
            entries.add(ModBlocks.SULFUR_ORE);
            entries.add(ModBlocks.DEEPSLATE_SULFUR_ORE);



        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SMOLDERING_COAL_BLOCK);
            entries.add(ModBlocks.SULFUR_BLOCK);







        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

        });
    }
}
