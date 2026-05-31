package net.mess.furnituremod.block.custom;

import net.mess.furnituremod.block.properties.SofaShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class SofaBlock extends SitBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty CONNECTED = BooleanProperty.create("connected");
    public static final EnumProperty<SofaShape> TYPE = EnumProperty.create("type", SofaShape.class);


    public static final VoxelShape SINGLE_SHAPE = Stream.of(
            Block.box(0, 0, 14, 2, 12, 16),
            Block.box(14, 0, 14, 16, 12, 16),
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(0.5, 2, 2, 2, 12, 14),
            Block.box(14, 2, 2, 15.5, 12, 14),
            Block.box(2, 2, 0.5, 14, 15, 2),
            Block.box(2, 2, 2, 14, 16, 8),
            Block.box(2, 2, 8, 14, 9, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape LEFT_SHAPE = Stream.of(
            Block.box(0, 0, 14, 2, 12, 16),
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(2, 2, 0.5, 16, 15, 2),
            Block.box(0.5, 2, 2, 2, 12, 14),
            Block.box(2, 2, 2, 16, 16, 8),
            Block.box(2, 2, 8, 16, 9, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape RIGHT_SHAPE = Stream.of(
            Block.box(0, 2, 0.5, 14, 15, 2),
            Block.box(14, 0, 14, 16, 12, 16),
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(14, 2, 2, 15.5, 12, 14),
            Block.box(0, 2, 2, 14, 16, 8),
            Block.box(0, 2, 8, 14, 9, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape MIDDLE_SHAPE = Stream.of(
            Block.box(0, 2, 0.5, 16, 15, 2),
            Block.box(0, 2, 2, 16, 16, 8),
            Block.box(0, 2, 8, 16, 9, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape CORNER_LEFT_SHAPE = Stream.of(
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(2, 2, 0.5, 16, 15, 2),
            Block.box(0.5, 2, 2, 2, 15, 16),
            Block.box(2, 2, 2, 8, 16, 16),
            Block.box(8, 2, 2, 16, 9, 16),
            Block.box(8, 9, 2, 16, 16, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape CORNER_RIGHT_SHAPE = Stream.of(
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(14, 2, 2, 15.5, 15, 16),
            Block.box(0, 2, 0.5, 14, 15, 2),
            Block.box(0, 2, 2, 14, 16, 8),
            Block.box(0, 2, 8, 14, 9, 16),
            Block.box(8, 9, 8, 14, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public SofaBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CONNECTED, false)
                .setValue(TYPE, SofaShape.SINGLE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Direction facing = context.getHorizontalDirection();
        return updateState(defaultBlockState().setValue(FACING, facing), level, pos);
    }

    @Override
    protected BlockState updateShape(BlockState state,
                                     LevelReader level,
                                     ScheduledTickAccess ticks,
                                     BlockPos pos,
                                     Direction direction,
                                     BlockPos neighborPos,
                                     BlockState neighborState,
                                     RandomSource random) {

        return updateState(state, (Level) level, pos);
    }


    private BlockState updateState(BlockState state, Level level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        SofaShape type = SofaShape.SINGLE;

        BlockState left = level.getBlockState(pos.relative(facing.getCounterClockWise()));
        BlockState right = level.getBlockState(pos.relative(facing.getClockWise()));

        boolean leftConnected = left.getBlock() instanceof SofaBlock;
        boolean rightConnected = right.getBlock() instanceof SofaBlock;

        if (leftConnected && rightConnected) {
            type = SofaShape.MIDDLE;
        } else if (leftConnected) {
            type = SofaShape.RIGHT;
        } else if (rightConnected) {
            type = SofaShape.LEFT;
        }

        BlockState front = level.getBlockState(pos.relative(facing));
        BlockState back = level.getBlockState(pos.relative(facing.getOpposite()));

        if (front.getBlock() instanceof SofaBlock && front.getValue(FACING).getAxis() != facing.getAxis()) {
            type = (front.getValue(FACING) == facing.getClockWise()) ?
                    SofaShape.CORNERRIGHT : SofaShape.CORNERLEFT;
        } else if (back.getBlock() instanceof SofaBlock && back.getValue(FACING).getAxis() != facing.getAxis()) {
            type = (back.getValue(FACING) == facing.getCounterClockWise()) ?
                    SofaShape.CORNERLEFT : SofaShape.CORNERRIGHT;
        }

        return state.setValue(CONNECTED, leftConnected || rightConnected).setValue(TYPE, type);
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
        builder.add(FACING, CONNECTED, TYPE);
    }


    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0) {
            double d0 = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * 0.66F * d0, vec3.z);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        SofaShape type = state.getValue(TYPE);
        Direction facing = state.getValue(FACING);

        VoxelShape shape = switch (type) {
            case LEFT -> LEFT_SHAPE;
            case RIGHT -> RIGHT_SHAPE;
            case MIDDLE -> MIDDLE_SHAPE;
            case CORNERLEFT -> CORNER_LEFT_SHAPE;
            case CORNERRIGHT -> CORNER_RIGHT_SHAPE;
            default -> SINGLE_SHAPE;
        };

        return rotateShape(Direction.NORTH, facing, shape);
    }

    private static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, Shapes.empty()};
        int rotations = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;

        for (int i = 0; i < rotations; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) ->
                    buffer[1] = Shapes.or(buffer[1],
                            Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)
                    )
            );
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }
        return buffer[0];
    }


}