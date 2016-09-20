package minestrapp.blocks;

import minestrapp.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block{
	
	public BlockBase(String name, Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(Minestrappolation.MODID+":"+name);
		this.setCreativeTab(Minestrappolation.tab);
	}

}
