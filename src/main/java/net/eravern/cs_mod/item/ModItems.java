package net.eravern.cs_mod.item;

import net.eravern.cs_mod.CSMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item SMOLDERING_COAL = registerItem("smoldering_coal",
            new Item(new FabricItemSettings()));
    public static final Item ENDER_CALCIUM = registerItem("ender_calcium",
            new Item(new FabricItemSettings()));
    public static final Item SULFUR = registerItem("sulfur",
            new Item(new FabricItemSettings()));



 private static Item registerItem(String name, Item item) {
     return Registry.register(Registries.ITEM, new Identifier(CSMod.MOD_ID, name), item);
 }


 public static void addItemsToItemGroup() {
    addToItemGroup(SMOLDERING_COAL);
    addToItemGroup(ENDER_CALCIUM);
     addToItemGroup(SULFUR);



 }


 private static void addToItemGroup( Item item) {

 }


 public static void registerModItems() {
     CSMod.LOGGER.debug("Registering Mod Items for" + CSMod.MOD_ID);

     addItemsToItemGroup();
 }

}
