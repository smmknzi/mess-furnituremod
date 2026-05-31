package net.mess.furnituremod.block.custom;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TableBlock extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty LEG1 = BooleanProperty.create("leg1");
    public static final BooleanProperty LEG2 = BooleanProperty.create("leg2");
    public static final BooleanProperty LEG3 = BooleanProperty.create("leg3");
    public static final BooleanProperty LEG4 = BooleanProperty.create("leg4");

    protected static final VoxelShape TOP = net.minecraft.world.level.block.Block.box(0, 14, 0, 16, 16, 16);
    protected static final VoxelShape LEG_1 = net.minecraft.world.level.block.Block.box(13, 0, 13, 15, 14, 15);
    protected static final VoxelShape LEG_2 = net.minecraft.world.level.block.Block.box(1, 0, 13, 3, 14, 15);
    protected static final VoxelShape LEG_3 = net.minecraft.world.level.block.Block.box(13, 0, 1, 15, 14, 3);
    protected static final VoxelShape LEG_4 = net.minecraft.world.level.block.Block.box(1, 0, 1, 3, 14, 3);

    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            TOP,
            Shapes.or(TOP, LEG_1),
            Shapes.or(TOP, LEG_2),
            Shapes.or(TOP, LEG_3),
            Shapes.or(TOP, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_2),
            Shapes.or(TOP, LEG_1, LEG_3),
            Shapes.or(TOP, LEG_1, LEG_4),
            Shapes.or(TOP, LEG_2, LEG_3),
            Shapes.or(TOP, LEG_2, LEG_4),
            Shapes.or(TOP, LEG_3, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_2, LEG_3),
            Shapes.or(TOP, LEG_1, LEG_2, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_3, LEG_4),
            Shapes.or(TOP, LEG_2, LEG_3, LEG_4),
            Shapes.or(TOP, LEG_1, LEG_2, LEG_3, LEG_4)
    };

    public TableBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(LEG1, true)
                .setValue(LEG2, true)
                .setValue(LEG3, true)
                .setValue(LEG4, true));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int shape = 0;

        boolean leg1 = state.getValue(LEG1);
        boolean leg2 = state.getValue(LEG2);
        boolean leg3 = state.getValue(LEG3);
        boolean leg4 = state.getValue(LEG4);

        if (leg2) shape = 1;
        if (leg3) shape = 2;
        if (leg1) shape = 3;
        if (leg4) shape = 4;

        if (leg2 && leg3) shape = 5;
        if (leg2 && leg1) shape = 6;
        if (leg2 && leg4) shape = 7;
        if (leg3 && leg1) shape = 8;
        if (leg3 && leg4) shape = 9;
        if (leg1 && leg4) shape = 10;

        if (leg2 && leg3 && leg1) shape = 11;
        if (leg2 && leg3 && leg4) shape = 12;
        if (leg2 && leg1 && leg4) shape = 13;
        if (leg3 && leg1 && leg4) shape = 14;

        if (leg1 && leg2 && leg3 && leg4) shape = 15;

        return SHAPES[shape];
    }

    public BlockState getConnections(BlockState state, LevelAccessor level, BlockPos pos) {
        boolean north = canConnect(level.getBlockState(pos.north()));
        boolean south = canConnect(level.getBlockState(pos.south()));
        boolean east = canConnect(level.getBlockState(pos.east()));
        boolean west = canConnect(level.getBlockState(pos.west()));

        return state
                .setValue(LEG1, !(north || east))
                .setValue(LEG2, !(east || south))
                .setValue(LEG3, !(west || south))
                .setValue(LEG4, !(west || north));
    }

    public boolean canConnect(BlockState state) {
        return state.is(this);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return getConnections(this.defaultBlockState(),
                context.getLevel(), context.getClickedPos());
    }
    @Override
    protected BlockState updateShape(final BlockState state, final LevelReader level, final ScheduledTickAccess ticks, final BlockPos pos, final Direction directionToNeighbour, final BlockPos neighbourPos, final BlockState neighbourState, final RandomSource random) {
        return getConnections(state, (LevelAccessor) level, pos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Fluids.EMPTY.defaultFluidState();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(LEG1, LEG2, LEG3, LEG4);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}