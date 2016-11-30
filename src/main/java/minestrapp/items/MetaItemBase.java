package minestrapp.items;

import java.util.List;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class MetaItemBase extends ItemBase implements IItemVariants{
	private int numVariants;
	
	public MetaItemBase(String name, Boolean foiled, int metaAmount) {
		super(name, foiled);
		this.hasSubtypes = true;
		this.numVariants = metaAmount;
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
	{
		for (int i = 0; i < this.numVariants; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "_" + stack.getItemDamage();
	}

	@Override
	public int getMaxVariants() {
		return this.numVariants;
	}

}
