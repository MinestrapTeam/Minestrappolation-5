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
			else if(this.effectID == "lucky")
			{
				player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 600, 1));
				
				int id = worldIn.rand.nextInt(15);
				if(id == 0)
					player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 600, 1));
				else if(id == 1)
					player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 600, 0));
				else if(id == 2)
					player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 600, 1));
				else if(id == 3)
					player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 600, 1));
				else if(id == 4)
					player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 600, 1));
				else if(id == 5)
					player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1));
				else if(id == 6)
					player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 600, 0));
				else if(id == 7)
					player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 600, 1));
				else if(id == 8)
					player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 1));
				else if(id == 9)
					player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 1));
				else if(id == 10)
					player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 600, 1));
				else if(id == 11)
					player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 600, 1));
				else if(id == 12)
					player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 1));
				else if(id == 13)
					player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 600, 0));
				else if(id == 14)
					player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 600, 1));
			}
        }
	}
}
