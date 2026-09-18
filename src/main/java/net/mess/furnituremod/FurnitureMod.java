package net.mess.furnituremod;

import net.fabricmc.api.ModInitializer;

import net.mess.furnituremod.block.ModBlocks;
import net.mess.furnituremod.entity.ModEntities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FurnitureMod implements ModInitializer {
	public static final String MOD_ID = "furnituremod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        //ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerModEntities();
        FurnitureModTab.registerModCreativeModeTabs();

    }



}