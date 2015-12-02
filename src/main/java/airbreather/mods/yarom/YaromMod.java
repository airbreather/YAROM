package airbreather.mods.yarom;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = YaromConstants.modID, name = YaromConstants.modName)
public final class YaromMod
{
    @Mod.EventHandler
    private void preInit(FMLPreInitializationEvent event)
    {
		YaromBlocks.init();
		LottoWorldGenerator.init();
		LottoBlockEventHandler.init();
    }
}

