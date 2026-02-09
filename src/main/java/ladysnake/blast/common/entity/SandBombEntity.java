package ladysnake.blast.common.entity;

import ladysnake.blast.common.init.BlastItems;
import ladysnake.blast.common.world.explosion.CustomExplosionBehavior;
import ladysnake.blast.common.world.explosion.FillingExplosionBehavior;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SandBombEntity extends BombEntity {
    public static final CustomExplosionBehavior BEHAVIOR = new FillingExplosionBehavior(Blocks.SAND.getDefaultState(), true);

    public SandBombEntity(EntityType<? extends BombEntity> entityType, World world) {
        super(entityType, world);
        setExplosionPower(2);
    }

    @Override
    protected Item getDefaultItem() {
        return BlastItems.SAND_BOMB;
    }

    @Override
    protected CustomExplosionBehavior getExplosionBehavior() {
        return BEHAVIOR;
    }
}
