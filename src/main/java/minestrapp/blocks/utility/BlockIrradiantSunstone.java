package minestrapp.blocks.utility;

import java.util.List;
import java.util.Random;

import minestrapp.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockIrradiantSunstone extends BlockBase
{
		int effectRate;
		int range;
		
		public BlockIrradiantSunstone(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel, int rate, int range)
		{
			super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
			this.effectRate = rate;
			this.range = range;
		}
		
		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state)
		{
			this.updateTick(world, pos, state, world.rand);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			if (!world.isRemote)
			{
				world.scheduleUpdate(pos, this, this.effectRate);
				int x = pos.getX();
	            int y = pos.getY();
				int z = pos.getZ();
	            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1))).expandXyz(range);
				List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

				for (EntityLivingBase living : list)
				{
					this.addPotionEffect(living, world, pos);
				}
			}
		}

		public void addPotionEffect(EntityLivingBase living, World world, BlockPos pos)
		{
			living.addPotionEffect(new PotionEffect(Potion.getPotionById(Potion.getIdFromPotion(MobEffects.GLOWING)), 20 * 2, 0, true, false));
		}
}
