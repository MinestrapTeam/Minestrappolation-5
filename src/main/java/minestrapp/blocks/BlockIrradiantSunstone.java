package minestrapp.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockIrradiantSunstone extends BlockRadiation
{
	int range;
		
	public BlockIrradiantSunstone(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel, int range)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel, range);
	}

	public void addPotionEffect(EntityLivingBase living, World world, BlockPos pos)
	{
		living.addPotionEffect(new PotionEffect(Potion.getPotionById(Potion.getIdFromPotion(MobEffects.GLOWING)), 20 * 2, 0, true, false));
	}
}
