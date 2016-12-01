package minestrapp.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlockItemBase extends ItemBlock
{
	public int states;
	
	public BlockItemBase(Block block, int states)
	{
		super(block);
		this.setRegistryName(block.getRegistryName());
		this.states = states;
		if(states > 0)
			this.setHasSubtypes(true);
	}
}
