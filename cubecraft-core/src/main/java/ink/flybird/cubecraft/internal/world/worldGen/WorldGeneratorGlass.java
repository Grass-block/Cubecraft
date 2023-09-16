package ink.flybird.cubecraft.internal.world.worldGen;

import ink.flybird.cubecraft.internal.block.BlockType;
import ink.flybird.cubecraft.internal.world.WorldType;
import ink.flybird.cubecraft.world.chunk.WorldChunk;
import ink.flybird.cubecraft.world.worldGen.GenerateStage;
import ink.flybird.cubecraft.world.worldGen.IChunkGenerator;
import ink.flybird.cubecraft.world.worldGen.WorldGenListener;
import ink.flybird.cubecraft.world.worldGen.WorldGeneratorSetting;

public class WorldGeneratorGlass implements IChunkGenerator {
    @WorldGenListener(stage = GenerateStage.TERRAIN, world = WorldType.OVERWORLD)
    public void generateChunkTerrain(WorldChunk chunk, WorldGeneratorSetting setting) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                double h=120;
                for (int y = 0; y < h; y++) {
                    if (y <= h&&y%8==0) {
                        chunk.setBlockID(x,y,z, BlockType.BLUE_STAINED_GLASS);
                    }
                }
            }
        }
    }
}