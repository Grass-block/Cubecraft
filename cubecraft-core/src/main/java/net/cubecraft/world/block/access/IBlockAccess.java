package net.cubecraft.world.block.access;

import ink.flybird.fcommon.container.Vector3;
import ink.flybird.fcommon.math.AABB;
import ink.flybird.fcommon.math.hitting.HitBox;
import ink.flybird.fcommon.math.hitting.Hittable;
import net.cubecraft.ContentRegistries;
import net.cubecraft.world.IWorld;
import net.cubecraft.world.block.Block;
import net.cubecraft.world.block.EnumFacing;
import net.cubecraft.world.block.blocks.BlockRegistry;
import net.cubecraft.world.block.property.BlockPropertyDispatcher;
import net.cubecraft.world.dimension.Dimension;

import java.util.Collection;

public abstract class IBlockAccess implements Hittable {
    protected final IWorld world;
    protected final long x;
    protected final long y;
    protected final long z;
    protected final Dimension dimension;
    protected Block block;

    public IBlockAccess(IWorld world, long x, long y, long z) {
        Block block1;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.dimension = this.world.getDimension();
    }


    public abstract String getBlockID();

    public abstract EnumFacing getBlockFacing();

    public abstract byte getBlockMeta();

    public abstract byte getBlockLight();

    public abstract String getBiome();


    public void setBlockID(String id, boolean sendUpdateEvent) {
    }

    public void setBlockFacing(EnumFacing facing, boolean sendUpdateEvent) {
    }

    public void setBlockMeta(byte meta, boolean sendUpdateEvent) {
    }

    public void setBlockLight(byte light, boolean sendUpdateEvent) {
    }

    public void setBiome(String biome, boolean sendUpdateEvent) {
    }


    public Block getBlock() {
        return this.block;
    }

    public void scheduleTick(int time) {
        this.world.setTickSchedule(this.x, this.y, this.z, time);
    }

    public Collection<AABB> getCollisionBox() {
        return BlockPropertyDispatcher.getCollisionBox(this);
    }

    @Override
    public Collection<HitBox> getHitBox() {
        return BlockPropertyDispatcher.getHitBox(this);
    }

    public long getX() {
        return this.x;
    }

    public long getY() {
        return this.y;
    }

    public long getZ() {
        return this.z;
    }


    public IBlockAccess getNear(EnumFacing facing) {
        Vector3<Long> pos = facing.findNear(this.x, this.y, this.z, 1);
        return this.world.getBlockAccess(pos.x(), pos.y(), pos.z());
    }
}
