package minestrapp.blocks;

import minestrapp.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;

public class BlockBase extends Block{
	
	public MapColor mapcolor;
	
	public BlockBase(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(Minestrappolation.MODID+":"+name);
		this.setCreativeTab(Minestrappolation.resource);
		this.mapcolor = mapcolor;
		this.blockSoundType = soundtype;
		if(tool != null)
		{
			this.setHarvestLevel(tool, harvestlevel);
		}
	}

	public MapColor getMapColor(IBlockState state)
    {
        return mapcolor;
    }
}
