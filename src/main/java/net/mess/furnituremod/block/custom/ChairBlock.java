package net.mess.furnituremod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class ChairBlock extends SitBlock implements SimpleWaterloggedBlock {

    public ChairBlock(Properties properties) {
        super(properties);
    }

    public static final VoxelShape CHAIR_SHAPE = Stream.of(
            Block.box(12, 8, 12, 14, 16, 14),
            Block.box(2, 8, 12, 4, 16, 14),
            Block.box(4, 13, 12, 12, 15, 14),
            Block.box(2, 0, 2, 14, 8, 14)
    ).reduce(Shapes::or).orElse(Shapes.empty());

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return rotateAndFlipShape(Direction.NORTH, state.getValue(FACING), CHAIR_SHAPE);
    }

    private static VoxelShape rotateAndFlipShape(Direction from, Direction to, VoxelShape shape) {
        int rotations = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;

        VoxelShape flippedShape = Shapes.empty();
        for (AABB box : shape.toAabbs()) {
            flippedShape = Shapes.or(flippedShape, Shapes.create(
                    1 - box.maxX, box.minY, 1 - box.maxZ,
                    1 - box.minX, box.maxY, 1 - box.minZ
            ));
        }

        VoxelShape rotatedShape = flippedShape;
        for (int i = 0; i < rotations; i++) {
            VoxelShape tempShape = Shapes.empty();
            for (AABB box : rotatedShape.toAabbs()) {
                tempShape = Shapes.or(tempShape, Shapes.create(
                        1 - box.maxZ, box.minY, box.minX,
                        1 - box.minZ, box.maxY, box.maxX
                ));
            }
            rotatedShape = tempShape;
        }

        return rotatedShape;
    }


}
