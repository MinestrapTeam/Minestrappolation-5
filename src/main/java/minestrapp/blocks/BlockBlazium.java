package minestrapp.blocks;

import java.util.Random;

import minestrapp.blocks.utility.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBlazium extends BlockBase
{
	public BlockBlazium(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
		this.setTickRandomly(true);
	}
	
	public boolean canCatchFire(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return world.getBlockState(pos).getBlock().isFlammable(world, pos, face);
    }

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getGameRules().getBoolean("doFireTick"))
        {
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));

            boolean flag1 = worldIn.isBlockinHighHumidity(pos);
            int j = 0;

            if (flag1)
            {
                j = -50;
            }

            this.tryCatchFire(worldIn, pos.east(), 300 + j, rand, 0, EnumFacing.WEST);
            this.tryCatchFire(worldIn, pos.west(), 300 + j, rand, 0, EnumFacing.EAST);
            this.tryCatchFire(worldIn, pos.down(), 250 + j, rand, 0, EnumFacing.UP);
            this.tryCatchFire(worldIn, pos.up(), 250 + j, rand, 0, EnumFacing.DOWN);
            this.tryCatchFire(worldIn, pos.north(), 300 + j, rand, 0, EnumFacing.SOUTH);
            this.tryCatchFire(worldIn, pos.south(), 300 + j, rand, 0, EnumFacing.NORTH);
        }
        
        BlockPos blockpos = pos.up();
        IBlockState iblockstate = worldIn.getBlockState(blockpos);

        if (iblockstate.getBlock() == Blocks.WATER || iblockstate.getBlock() == Blocks.FLOWING_WATER)
        {
            worldIn.setBlockToAir(blockpos);
            worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

            if (worldIn instanceof WorldServer)
            {
                ((WorldServer)worldIn).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D, new int[0]);
            }
        }
    }

	private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, EnumFacing face)
    {
        int i = worldIn.getBlockState(pos).getBlock().getFlammability(worldIn, pos, face);

        if (random.nextInt(chance) < i)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (random.nextInt(age + 10) < 5 && !worldIn.isRainingAt(pos))
            {
                int j = age + random.nextInt(5) / 4;

                if (j > 15)
                {
                    j = 15;
                }

                worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState().withProperty(BlockFire.AGE, Integer.valueOf(j)), 3);
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }

            if (iblockstate.getBlock() == Blocks.TNT)
            {
                Blocks.TNT.onBlockDestroyedByPlayer(worldIn, pos, iblockstate.withProperty(BlockTNT.EXPLODE, Boolean.valueOf(true)));
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        for(int i = rand.nextInt(3) + 1 ; i > 0 ; i--)
        {
        	EnumFacing enumfacing = EnumFacing.random(rand);

        	if (enumfacing != EnumFacing.DOWN && !worldIn.getBlockState(pos.offset(enumfacing)).isFullyOpaque())
        	{
            	double d0 = (double)pos.getX();
            	double d1 = (double)pos.getY();
            	double d2 = (double)pos.getZ();

            	if (enumfacing == EnumFacing.UP)
            	{
                	d1 = d1 + 1.05D;
                	d0 += rand.nextDouble();
                	d2 += rand.nextDouble();
            	}
            	else
            	{
                	d1 = d1 + rand.nextDouble() * 0.8D;

                	if (enumfacing.getAxis() == EnumFacing.Axis.X)
                	{
                		d2 += rand.nextDouble();

                    	if (enumfacing == EnumFacing.EAST)
                    	{
                        	++d0;
                    	}
                    	else
                    	{
                        	d0 += 0.05D;
                    	}
                	}
                	else
                	{
                    	d0 += rand.nextDouble();

                    	if (enumfacing == EnumFacing.SOUTH)
                    	{
                        	++d2;
                    	}
                    	else
                    	{
                        	d2 += 0.05D;
                    	}
                	}
            	}

            	worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        	}
        }
    }
	
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
