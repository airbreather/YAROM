package airbreather.mods.yarom;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

final class LottoWorldGenerator implements IWorldGenerator
{
	private final WorldGenMinable genny = new WorldGenMinable(YaromBlocks.lottoBlockOre, 8);

	public static void init()
	{
		// TODO: most people don't seem to do this for some reason, but
		// the mod gen really should be configurable.
		GameRegistry.registerWorldGenerator(new LottoWorldGenerator(), 0);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		int baseX = chunkX * 16;
		int baseZ = chunkZ * 16;

		for (int i = 0; i < 5; i++)
		{
			int x = baseX + random.nextInt(16);
			int y = 16 + random.nextInt(33);
			int z = baseZ + random.nextInt(16);
			this.genny.generate(world, random, x, y, z);
		}
	}
}
