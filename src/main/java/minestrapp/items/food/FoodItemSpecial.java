package minestrapp.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FoodItemSpecial extends FoodItemBase
{
	public String effectID;
	
	public FoodItemSpecial(String name, int amount, float saturation, boolean isWolfFood, String effectID)
	{
		super(name, amount, saturation, isWolfFood);
		this.effectID = effectID;
	}

	public void triggerSpecialEffects(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if (!worldIn.isRemote)
        {
			if(this.effectID == "jam")
			{
				player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 600, 1));
				player.heal(10);
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 1));
			}
			else if(this.effectID == "glowshroom")
			{
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 600, 2));
				player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 600, 2));
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 600, 0));
				player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 600, 1));
				player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 600, 0));
			}
        }
	}
}
