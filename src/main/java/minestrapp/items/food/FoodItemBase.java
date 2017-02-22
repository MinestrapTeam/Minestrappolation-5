package minestrapp.items.food;

import javax.annotation.Nullable;

import minestrapp.Minestrappolation;
import minestrapp.Tabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class FoodItemBase extends ItemFood
{
	public int healQuant;
	public float healChance;
	public ItemStack remains;
	public int fireMode;
	public int fireTime;
	
	public FoodItemBase(String name, int amount, float saturation, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setRegistryName(Minestrappolation.MODID+":"+name);
		this.setCreativeTab(Tabs.foods);
		healQuant = 0;
		healChance = 0;
		remains = null;
		fireMode = 0;
		fireTime = 0;
	}

	@Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        stack.shrink(1);

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
            if(!worldIn.isRemote && this.healQuant != 0 && worldIn.rand.nextFloat() < this.healChance)
            {
            	if(healQuant > 0)
            		entityplayer.heal(healQuant);
            	else
            		entityplayer.attackEntityFrom(DamageSource.causePlayerDamage(entityplayer), Math.abs(healQuant));
            }
            if(!worldIn.isRemote && this.remains != null)
            {
            	EntityItem item = new EntityItem(worldIn, entityplayer.posX, entityplayer.posY, entityplayer.posZ, this.remains);
            	worldIn.spawnEntity(item);
            }
            if(!worldIn.isRemote && this.fireMode != 0)
            {
            	if(this.fireMode == 1)
            		entityplayer.setFire(this.fireTime);
            	else if(this.fireMode == 2 && entityplayer.isBurning() == true)
            		entityplayer.extinguish();
            }
            this.triggerSpecialEffects(stack, worldIn, entityplayer);
        }

        return stack;
    }
	
	public FoodItemBase setHealAmount(int amount, float chance)
    {
		this.healQuant = amount;
		this.healChance = chance;
		return this;
    }
	
	public FoodItemBase setLeftoverItem(ItemStack stack)
	{
		this.remains = stack;
		return this;
	}
	
	public FoodItemBase setFireMode(int mode, int time)
	{
		this.fireMode = mode;
		this.fireTime = time;
		return this;
	}
	
	public void triggerSpecialEffects(ItemStack stack, World worldIn, EntityPlayer player)
	{		
	}
}
