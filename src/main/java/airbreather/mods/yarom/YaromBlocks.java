package airbreather.mods.yarom;

import cpw.mods.fml.common.registry.GameRegistry;

final class YaromBlocks
{
	public static final LottoBlockOre lottoBlockOre = new LottoBlockOre();

	public static void init()
	{
		GameRegistry.registerBlock(lottoBlockOre, YaromConstants.oreLottoBlockItemId);
	}
}
