package minestrapp.items.food;

import java.util.List;

import minestrapp.items.IItemVariants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class FoodItemCandy extends FoodItemBase implements IItemVariants
{
	public FoodItemCandy(String name)
	{
		super(name, 0, 0F, false);
		this.hasSubtypes = true;
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
	{
		for (int i = 0; i < 3; i++)
		{
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "_" + stack.getItemDamage();
	}
	
	@Override
	public int getMaxVariants()
	{
		return 3;
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if(stack.getMetadata() == 0)
        {
        	player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 400, 0));
        	player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 0));
        }
        if(stack.getMetadata() == 1)
        {
        	player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 400, 1));
        	player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 400, 1));
        }
        if(stack.getMetadata() == 2)
        {
        	player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 400, 0));
        	player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0));
        	player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 400, 0));
        }

        super.onFoodEaten(stack, worldIn, player);
    }
}
