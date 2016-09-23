package minestrapp.items.food;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FoodItemBowl extends FoodItemSpecial
{
	public ItemStack container;
	
	public FoodItemBowl(String name, int amount, float saturation, boolean isWolfFood, String effectID, ItemStack container)
	{
		super(name, amount, saturation, isWolfFood, effectID);
		this.setMaxStackSize(1);
		this.container = container;
	}

	@Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return container;
    }
}
