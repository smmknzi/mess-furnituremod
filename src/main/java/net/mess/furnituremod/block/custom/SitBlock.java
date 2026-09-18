package net.mess.furnituremod.block.custom;

import net.mess.furnituremod.entity.ModEntities;
import net.mess.furnituremod.entity.custom.SitEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SitBlock extends HorizontalDirectionalBlock {


    public SitBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<SitEntity> sitEntities = level.getEntities(ModEntities.SIT, new AABB(pos), sit -> true);
            if(sitEntities.isEmpty()) {
                entity = ModEntities.SIT.spawn(((ServerLevel) level), pos, EntitySpawnReason.TRIGGERED);
            } else {
                entity = sitEntities.getFirst();
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }


    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}