package minestrapp.blocks.utility;

import minestrapp.Minestrappolation;
import minestrapp.Tabs;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class GravityBlockBase extends BlockFalling
{
	public MapColor mapcolor;
	
	public GravityBlockBase(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel)
	{
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(Minestrappolation.MODID+":"+name);
		this.setCreativeTab(Tabs.resource);
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
