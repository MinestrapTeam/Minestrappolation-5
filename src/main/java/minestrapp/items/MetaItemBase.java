package minestrapp.items;

import java.util.List;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MetaItemBase extends ItemBase implements IItemVariants{
	private int numVariants;
	
	public MetaItemBase(String name, Boolean foiled, int metaAmount) {
		super(name, foiled);
		this.hasSubtypes = true;
		this.numVariants = metaAmount;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List<ItemStack> itemList) {
		for (int i = 0; i < this.numVariants; i++) {
			itemList.add(new ItemStack(this, 1, i));
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
