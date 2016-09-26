package minestrapp.blocks.utility;

import minestrapp.Minestrappolation;
import minestrapp.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBase extends Block{
	
	public MapColor mapcolor;
	public static boolean canDragonDestroy = true;
	public static boolean canWitherDestroy = true;
	
	public BlockBase(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel) {
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

	public BlockBase setSlipperiness(float level)
	{
		this.slipperiness = level;
		return this;
	}
	
	public BlockBase setEntityInvulnerability(String entity)
	{
		if(entity == "dragon")
			this.canDragonDestroy = false;
		if(entity == "wither")
			this.canWitherDestroy = false;
		if(entity == "all")
		{
			this.canDragonDestroy = false;
			this.canWitherDestroy = false;
		}
		return this;
	}
	
	public MapColor getMapColor(IBlockState state)
    {
        return mapcolor;
    }
	
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
    {
        if (entity instanceof net.minecraft.entity.boss.EntityDragon)
        {
            return this.canDragonDestroy;
        }
        else if (entity instanceof net.minecraft.entity.boss.EntityWither)
        {
            return this.canWitherDestroy;
        }
        return true;
    }
}
