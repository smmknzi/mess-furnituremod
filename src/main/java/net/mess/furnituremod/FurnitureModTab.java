package net.mess.furnituremod;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.mess.furnituremod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FurnitureModTab {
    public static final CreativeModeTab FURNITURE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, "furniture"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WHITE_WOOL_SOFA))
                    .title(Component.translatable("creativemodetab.furnituremod.furniture_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.OAK_STOOL);
                        output.accept(ModBlocks.OAK_CHAIR);
                        output.accept(ModBlocks.OAK_TABLE);
                        output.accept(ModBlocks.SPRUCE_STOOL);
                        output.accept(ModBlocks.SPRUCE_CHAIR);
                        output.accept(ModBlocks.SPRUCE_TABLE);
                        output.accept(ModBlocks.BIRCH_STOOL);
                        output.accept(ModBlocks.BIRCH_CHAIR);
                        output.accept(ModBlocks.BIRCH_TABLE);
                        output.accept(ModBlocks.JUNGLE_STOOL);
                        output.accept(ModBlocks.JUNGLE_CHAIR);
                        output.accept(ModBlocks.JUNGLE_TABLE);
                        output.accept(ModBlocks.ACACIA_STOOL);
                        output.accept(ModBlocks.ACACIA_CHAIR);
                        output.accept(ModBlocks.ACACIA_TABLE);
                        output.accept(ModBlocks.DARK_OAK_STOOL);
                        output.accept(ModBlocks.DARK_OAK_CHAIR);
                        output.accept(ModBlocks.DARK_OAK_TABLE);
                        output.accept(ModBlocks.MANGROVE_STOOL);
                        output.accept(ModBlocks.MANGROVE_CHAIR);
                        output.accept(ModBlocks.MANGROVE_TABLE);
                        output.accept(ModBlocks.CHERRY_STOOL);
                        output.accept(ModBlocks.CHERRY_CHAIR);
                        output.accept(ModBlocks.CHERRY_TABLE);
                        output.accept(ModBlocks.PALE_OAK_STOOL);
                        output.accept(ModBlocks.PALE_OAK_CHAIR);
                        output.accept(ModBlocks.PALE_OAK_TABLE);
                        output.accept(ModBlocks.POPLAR_STOOL);
                        output.accept(ModBlocks.POPLAR_CHAIR);
                        output.accept(ModBlocks.POPLAR_TABLE);
                        output.accept(ModBlocks.BAMBOO_STOOL);
                        output.accept(ModBlocks.BAMBOO_CHAIR);
                        output.accept(ModBlocks.BAMBOO_TABLE);
                        output.accept(ModBlocks.CRIMSON_STOOL);
                        output.accept(ModBlocks.CRIMSON_CHAIR);
                        output.accept(ModBlocks.CRIMSON_TABLE);
                        output.accept(ModBlocks.WARPED_STOOL);
                        output.accept(ModBlocks.WARPED_CHAIR);
                        output.accept(ModBlocks.WARPED_TABLE);

                        output.accept(ModBlocks.WHITE_WOOL_SOFA);
                        output.accept(ModBlocks.LIGHT_GRAY_WOOL_SOFA);
                        output.accept(ModBlocks.GRAY_WOOL_SOFA);
                        output.accept(ModBlocks.BLACK_WOOL_SOFA);
                        output.accept(ModBlocks.BROWN_WOOL_SOFA);
                        output.accept(ModBlocks.RED_WOOL_SOFA);
                        output.accept(ModBlocks.ORANGE_WOOL_SOFA);
                        output.accept(ModBlocks.YELLOW_WOOL_SOFA);
                        output.accept(ModBlocks.LIME_WOOL_SOFA);
                        output.accept(ModBlocks.GREEN_WOOL_SOFA);
                        output.accept(ModBlocks.CYAN_WOOL_SOFA);
                        output.accept(ModBlocks.LIGHT_BLUE_WOOL_SOFA);
                        output.accept(ModBlocks.BLUE_WOOL_SOFA);
                        output.accept(ModBlocks.PURPLE_WOOL_SOFA);
                        output.accept(ModBlocks.MAGENTA_WOOL_SOFA);
                        output.accept(ModBlocks.PINK_WOOL_SOFA);


                    }).build());


    public static void registerModCreativeModeTabs() {
        FurnitureMod.LOGGER.info("Registering Creative Mode Tabs for " + FurnitureMod.MOD_ID);
    }
}

