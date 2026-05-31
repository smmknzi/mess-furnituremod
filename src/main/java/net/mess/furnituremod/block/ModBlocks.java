package net.mess.furnituremod.block;

import net.mess.furnituremod.FurnitureMod;
import net.mess.furnituremod.block.custom.ChairBlock;
import net.mess.furnituremod.block.custom.SofaBlock;
import net.mess.furnituremod.block.custom.StoolBlock;
import net.mess.furnituremod.block.custom.TableBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;


public class ModBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    /*
    BLOCK REGISTRATION TEMPLATE
    public static final Block BLOCK_NAME = register("block_name",
            CustomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.EXISTING).sound(SoundType.EXISTING), true);
     */

    //Stool Registry
    public static final Block OAK_STOOL = register("oak_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block SPRUCE_STOOL = register("spruce_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BIRCH_STOOL = register("birch_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block JUNGLE_STOOL = register("jungle_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block ACACIA_STOOL = register("acacia_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block DARK_OAK_STOOL = register("dark_oak_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block MANGROVE_STOOL = register("mangrove_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block CHERRY_STOOL = register("cherry_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block PALE_OAK_STOOL = register("pale_oak_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BAMBOO_STOOL = register("bamboo_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).sound(SoundType.BAMBOO_WOOD), true);
    public static final Block CRIMSON_STOOL = register("crimson_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block WARPED_STOOL = register("warped_stool",
            StoolBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);

    //Chair Registry
    public static final Block OAK_CHAIR = register("oak_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block SPRUCE_CHAIR = register("spruce_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BIRCH_CHAIR = register("birch_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block JUNGLE_CHAIR = register("jungle_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block ACACIA_CHAIR = register("acacia_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block DARK_OAK_CHAIR = register("dark_oak_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block MANGROVE_CHAIR = register("mangrove_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block CHERRY_CHAIR = register("cherry_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block PALE_OAK_CHAIR = register("pale_oak_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BAMBOO_CHAIR = register("bamboo_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).sound(SoundType.BAMBOO_WOOD), true);
    public static final Block CRIMSON_CHAIR = register("crimson_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block WARPED_CHAIR = register("warped_chair",
            ChairBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);

    //Table Registry
    public static final Block OAK_TABLE = register("oak_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block SPRUCE_TABLE = register("spruce_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BIRCH_TABLE = register("birch_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block JUNGLE_TABLE = register("jungle_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block ACACIA_TABLE = register("acacia_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block DARK_OAK_TABLE = register("dark_oak_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block MANGROVE_TABLE = register("mangrove_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block CHERRY_TABLE = register("cherry_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block PALE_OAK_TABLE = register("pale_oak_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BAMBOO_TABLE = register("bamboo_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).sound(SoundType.BAMBOO_WOOD), true);
    public static final Block CRIMSON_TABLE = register("crimson_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block WARPED_TABLE = register("warped_table",
            TableBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);

    //Sofa Registry
    public static final Block WHITE_WOOL_SOFA = register("white_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block LIGHT_GRAY_WOOL_SOFA = register("light_gray_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block GRAY_WOOL_SOFA = register("gray_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BLACK_WOOL_SOFA = register("black_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BROWN_WOOL_SOFA = register("brown_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block RED_WOOL_SOFA = register("red_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block ORANGE_WOOL_SOFA = register("orange_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block YELLOW_WOOL_SOFA = register("yellow_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block LIME_WOOL_SOFA = register("lime_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block GREEN_WOOL_SOFA = register("green_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block CYAN_WOOL_SOFA = register("cyan_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD),  true);
    public static final Block LIGHT_BLUE_WOOL_SOFA = register("light_blue_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block BLUE_WOOL_SOFA = register("blue_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block PURPLE_WOOL_SOFA = register("purple_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block MAGENTA_WOOL_SOFA = register("magenta_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);
    public static final Block PINK_WOOL_SOFA = register("pink_wool_sofa",
            SofaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD), true);


    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, name));
    }

    public static void registerModBlocks() {
        FurnitureMod.LOGGER.info("Registering Mod Blocks for " + FurnitureMod.MOD_ID);
    }
}
