package airbreather.mods.yarom;

import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import static com.google.common.base.Preconditions.checkNotNull;

public final class LottoBlockEventHandler
{
	private static final ImmutableList<Item> Ores = ImmutableList.of
	(
		Item.getItemFromBlock(Blocks.coal_ore),
		Item.getItemFromBlock(Blocks.iron_ore),
		Item.getItemFromBlock(Blocks.gold_ore),
		Item.getItemFromBlock(Blocks.lapis_ore),
		Item.getItemFromBlock(Blocks.redstone_ore),
		Item.getItemFromBlock(Blocks.diamond_ore),
		Item.getItemFromBlock(Blocks.emerald_ore)
	);

	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new LottoBlockEventHandler());
	}

	@SubscribeEvent
	public void onHarvestBlockDrops(HarvestDropsEvent event)
	{
		checkNotNull(event, "event");

		if (event.block != YaromBlocks.lottoBlockOre)
		{
			return;
		}

		if (!event.isSilkTouching)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(chooseItem(event)));
		}
	}

	// TODO: so much TODO, so little time.
	private static final Random MyRandom = new Random(12345);
	private static Item chooseItem(HarvestDropsEvent event)
	{
		return Ores.get(MyRandom.nextInt(Ores.size()));
	}
}
