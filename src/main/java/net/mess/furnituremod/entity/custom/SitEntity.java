package net.mess.furnituremod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;



public class SitEntity extends Entity {
    public SitEntity(EntityType<?> type, Level world) {
        super(type, world);
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {

    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        return false;
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {

    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if(!level().isClientSide()) {
            this.kill((ServerLevel) this.level());
        }
    }

}