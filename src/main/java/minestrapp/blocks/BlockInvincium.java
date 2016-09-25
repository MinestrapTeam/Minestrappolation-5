package minestrapp.blocks;

import minestrapp.blocks.utility.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockInvincium extends BlockBase
{
	public static int type;
	
	public BlockInvincium(String name, MapColor mapcolor, int type)
	{
		super(name, Material.ROCK, mapcolor, SoundType.STONE, null, 0);
		this.setBlockUnbreakable();
		if(type == 1)
			this.slipperiness = 0.96F;
		this.type = type;
	}
	
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.func_189869_j((EntityLivingBase)entityIn) && type == 0)
        {
            entityIn.attackEntityFrom(DamageSource.field_190095_e, 1.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@SideOnly(Side.CLIENT)
    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return 15728880;
    }
}