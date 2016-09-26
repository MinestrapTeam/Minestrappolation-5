package minestrapp.blocks;

import java.util.Random;

import minestrapp.blocks.utility.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GlassBlockBase extends BlockBase
{
	public static int renderType;
	public static boolean ignoreSimilarity;
	public static boolean canHarvest;
	
	public GlassBlockBase(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel, int renderType, boolean ignoreSimilarity, boolean canHarvest)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
		this.renderType = renderType;
		this.ignoreSimilarity = ignoreSimilarity;
		this.canHarvest = canHarvest;
	}

	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        return !this.ignoreSimilarity && block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
    
    public int quantityDropped(Random random)
    {
        if(this.canHarvest == true)
        	return 1;
    	return 0;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        if(this.renderType == 1)
        	return BlockRenderLayer.TRANSLUCENT;
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
}
