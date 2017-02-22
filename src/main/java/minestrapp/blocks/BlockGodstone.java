package minestrapp.blocks;

import java.util.List;
import java.util.Random;

import minestrapp.blocks.utility.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGodstone extends BlockBase
{
	public BlockGodstone(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		this.updateTick(world, pos, state, world.rand);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand){
		if (!world.isRemote){
			world.scheduleUpdate(pos, this, 20);
			int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1))).expandXyz(5);
			List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase living : list)
			{
				if(living.isEntityUndead())
				{
					int k = rand.nextInt(8) + 1;
					living.attackEntityFrom(DamageSource.MAGIC, k);
                    ((WorldServer)world).spawnParticle(EnumParticleTypes.CRIT_MAGIC, living.posX, living.posY + (double)(living.height * 0.5F), living.posZ, k, 0.1D, 0.0D, 0.1D, 0.2D, new int[0]);
				}
				else
				{
					if(living.getActivePotionEffect(MobEffects.BLINDNESS) != null)
						living.removePotionEffect(MobEffects.BLINDNESS);
					if(living.getActivePotionEffect(MobEffects.HUNGER) != null)
						living.removePotionEffect(MobEffects.HUNGER);
					if(living.getActivePotionEffect(MobEffects.MINING_FATIGUE) != null)
						living.removePotionEffect(MobEffects.MINING_FATIGUE);
					if(living.getActivePotionEffect(MobEffects.NAUSEA) != null)
						living.removePotionEffect(MobEffects.NAUSEA);
					if(living.getActivePotionEffect(MobEffects.POISON) != null)
						living.removePotionEffect(MobEffects.POISON);
					if(living.getActivePotionEffect(MobEffects.SLOWNESS) != null)
						living.removePotionEffect(MobEffects.SLOWNESS);
					if(living.getActivePotionEffect(MobEffects.UNLUCK) != null)
						living.removePotionEffect(MobEffects.UNLUCK);
					if(living.getActivePotionEffect(MobEffects.WEAKNESS) != null)
						living.removePotionEffect(MobEffects.WEAKNESS);
					if(living.getActivePotionEffect(MobEffects.WITHER) != null)
						living.removePotionEffect(MobEffects.WITHER);
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
