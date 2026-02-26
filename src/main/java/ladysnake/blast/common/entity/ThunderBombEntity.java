package ladysnake.blast.common.entity;

import ladysnake.blast.common.init.BlastItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ThunderBombEntity extends BombEntity {
    public ThunderBombEntity(EntityType<? extends BombEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected Item getDefaultItem() {
        return BlastItems.THUNDER_BOMB;
    }

    @Override
    protected void explode() {
        if(getEntityWorld().isClient()) return;
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(getEntityWorld(), SpawnReason.TRIGGERED);
        if (lightningEntity != null) {
            lightningEntity.setCosmetic(false);
            lightningEntity.refreshPositionAfterTeleport(getX(), getY(), getZ());
            getEntityWorld().spawnEntity(lightningEntity);
        }
        remove(RemovalReason.DISCARDED);
    }
}
