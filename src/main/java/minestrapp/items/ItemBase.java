package minestrapp.items;

import minestrapp.Minestrappolation;
import net.minecraft.item.Item;

public class ItemBase extends Item
{	
	public ItemBase(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(Minestrappolation.MODID+":"+name);
		this.setCreativeTab(Minestrappolation.tab);
	}
}
