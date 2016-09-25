package minestrapp.items.misc;

import minestrapp.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGuano extends ItemBase
{

	public ItemGuano(String name)
	{
		super(name, false);
	}

	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
        	if (applyBonemeal(stack, worldIn, pos, playerIn))
            {
                if (!worldIn.isRemote)
                {
                    worldIn.playEvent(2005, pos, 0);
                }
                return EnumActionResult.SUCCESS;
            }
            return EnumActionResult.PASS;
        }
    }
	
	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target)
    {
        if (worldIn instanceof net.minecraft.world.WorldServer)
            return applyBonemeal(stack, worldIn, target, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.world.WorldServer)worldIn));
        return false;
    }
	
	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player)
    {
        IBlockState iblockstate = worldIn.getBlockState(target);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack);
        if (hook != 0) return hook > 0;

        if (iblockstate.getBlock() instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)iblockstate.getBlock();
            if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote))
            {
                if (!worldIn.isRemote)
                {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate))
                    {
                    	if(iblockstate.getBlock() instanceof BlockCrops)
                    	{
                    		if(iblockstate.getBlock() instanceof BlockBeetroot)
                    			worldIn.setBlockState(target, iblockstate.withProperty(BlockBeetroot.BEETROOT_AGE, 3));
                    		else
                    			worldIn.setBlockState(target, iblockstate.withProperty(BlockCrops.AGE, 7));
                    	}
                    	else if(iblockstate.getBlock() instanceof BlockSapling)
                    	{
                    		worldIn.setBlockState(target, iblockstate.withProperty(BlockSapling.STAGE, 1));
                    		igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
                    	}
                    	else if(iblockstate.getBlock() instanceof BlockStem)
                    	{
                    		worldIn.setBlockState(target, iblockstate.withProperty(BlockStem.AGE, 7));
                    	}
                    	else if(iblockstate.getBlock() instanceof BlockCocoa)
                    	{
                    		worldIn.setBlockState(target, iblockstate.withProperty(BlockCocoa.AGE, 2));
                    	}
                    	else 
                    	{
                    		igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
                    	}
                    }

                    --stack.stackSize;
                }

                return true;
            }
        }

        return false;
    }
}
