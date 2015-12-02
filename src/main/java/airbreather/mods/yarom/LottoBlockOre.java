package airbreather.mods.yarom;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockOre;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

final class LottoBlockOre extends BlockOre
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

	public LottoBlockOre()
	{
		this.setBlockName(YaromConstants.oreLottoBlockItemId);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
	}

	// TODO: this is still pretty bad.  we shouldn't be creating new Random objects like this.
	// ideal: consider concat(x, y, z) as binary and hash that.
	// TODO: 1.8 adds blockstates which would let us defend against certain kinds of abuse without
	// the overhead of tile entities.
	// TODO: obviously, the drops and chances should be configurable.
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		int seed = 17;
		seed = seed * 31 + x;
		seed = seed * 31 + y;
		seed = seed * 31 + z;

		Random rand = new Random(seed);
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>(1);
		drops.add(new ItemStack(Ores.get(rand.nextInt(Ores.size()))));
		return drops;
	}
}
