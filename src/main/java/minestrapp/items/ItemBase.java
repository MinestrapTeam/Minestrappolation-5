package minestrapp.items;

import minestrapp.Minestrappolation;
import minestrapp.Tabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item
{	
	public boolean foiled;
	
	public ItemBase(String name, Boolean foiled)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(Minestrappolation.MODID+":"+name);
		this.setCreativeTab(Tabs.minerals);
		this.foiled = foiled;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return this.foiled;
    }
}
