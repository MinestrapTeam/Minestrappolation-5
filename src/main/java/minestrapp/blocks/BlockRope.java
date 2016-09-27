package minestrapp.blocks;

import javax.annotation.Nullable;

import minestrapp.BlocksRegistry;
import minestrapp.blocks.utility.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRope extends BlockBase
{

	public BlockRope(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		return new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    public EnumPushReaction getMobilityFlag(IBlockState state)
    {
        return EnumPushReaction.DESTROY;
    }
    
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return this.canBlockStay(worldIn, pos, EnumFacing.UP);
    }
    
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
    	return worldIn.isSideSolid(pos.offset(facing), facing.getOpposite()) || worldIn.getBlockState(pos.offset(facing)) == this.getDefaultState();
    }
    
    @Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
	{
		if (!this.canBlockStay(worldIn, pos, EnumFacing.UP))
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}

		super.neighborChanged(state, worldIn, pos, blockIn);
	}
    
    @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
    	if (playerIn.getHeldItemMainhand() != null || playerIn.getHeldItemOffhand() != null)
		{
			Item main = null;
			Item off = null;
			if(playerIn.getHeldItemMainhand() != null)
				main = playerIn.getHeldItemMainhand().getItem();
			if(playerIn.getHeldItemOffhand() != null)
				off = playerIn.getHeldItemOffhand().getItem();

			if (main == Item.getItemFromBlock(this.getDefaultState().getBlock()) || off == Item.getItemFromBlock(this.getDefaultState().getBlock()))
			{
				int yCheck = pos.getY();
				BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
				boolean isChecking = true;
				for (boolean checking = true; checking == true; checking = isChecking)
				{
					if (worldIn.getBlockState(pos1) == this.getDefaultState())
					{
						yCheck--;
						pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
						isChecking = true;
					}
					else if (worldIn.isAirBlock(pos1) == true)
					{
						worldIn.setBlockState(pos1, this.getDefaultState());
						if (!playerIn.capabilities.isCreativeMode)
						{
							if(main == Item.getItemFromBlock(this.getDefaultState().getBlock()))
								--playerIn.getHeldItemMainhand().stackSize;
							else if(off == Item.getItemFromBlock(this.getDefaultState().getBlock()))
							{
								--playerIn.getHeldItemOffhand().stackSize;
							}
						}
						isChecking = false;
					}
					else
					{
						isChecking = false;
					}
				}
				return true;
			}
		}
    	else
    	{
    		int yCheck = pos.getY();
			BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
			boolean isChecking = true;
			for (boolean checking = true; checking == true; checking = isChecking)
			{
				if (worldIn.getBlockState(pos1) == this.getDefaultState())
				{
					yCheck--;
					pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
					isChecking = true;
				}
				else
				{
					worldIn.setBlockState(pos1.offset(EnumFacing.UP), Blocks.AIR.getDefaultState());
					if(!worldIn.isRemote)
						worldIn.spawnEntityInWorld(new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(BlocksRegistry.rope, 1)));
					isChecking = false;
				}
			}
			return true;
    	}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}
    
    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return true; }

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 300;
	}
}
