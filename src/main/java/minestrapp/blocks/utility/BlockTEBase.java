package minestrapp.blocks.utility;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTEBase extends BlockBase implements ITileEntityProvider{

	public BlockTEBase(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel) {
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
