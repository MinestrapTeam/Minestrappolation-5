package minestrapp.items.food;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import minestrapp.items.IItemVariants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodItemSalad extends FoodItemBase implements IItemVariants
{
	public boolean breadbowl;
	
	public FoodItemSalad(String name, boolean breadbowl)
	{
		super(name, 0, 0F, false);
		this.breadbowl = breadbowl;
		if(this.breadbowl == false){
			this.maxStackSize = 1;
		}
	}

	public int getHealAmount(ItemStack stack)
    {
        FoodItemSalad.SaladType saladType = FoodItemSalad.SaladType.byItemStack(stack);
        return this.breadbowl ? saladType.getBaseHealAmount() + 2 : saladType.getBaseHealAmount();
    }

    public float getSaturationModifier(ItemStack stack)
    {
        FoodItemSalad.SaladType saladType = FoodItemSalad.SaladType.byItemStack(stack);
        return saladType.getBaseSaturationModifier();
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        FoodItemSalad.SaladType saladType = FoodItemSalad.SaladType.byItemStack(stack);

        if (saladType.getPotionEffect() != null)
        {
            player.addPotionEffect(saladType.getPotionEffect());
        }
        else if (saladType == SaladType.HEALTHY)
        {
        	player.heal(10);
        }

        super.onFoodEaten(stack, worldIn, player);
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (FoodItemSalad.SaladType saladType : FoodItemSalad.SaladType.values())
        {
            subItems.add(new ItemStack(this, 1, saladType.getMetadata()));
        }
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        FoodItemSalad.SaladType saladType = FoodItemSalad.SaladType.byItemStack(stack);
        return this.getUnlocalizedName() + "_" + saladType.getUnlocalizedName();
    }

    public static enum SaladType
    {
        GREEN(0, "green", 8, 0.2F, null, 0, 0),
        HEARTY(1, "hearty", 4, 2F, MobEffects.HEALTH_BOOST, 400, 1),
        HEALTHY(2, "healthy", 5, 0.1F, null, 0, 0),
        NOURISHING(3, "nourishing", 6, 0.5F, MobEffects.RESISTANCE, 400, 1),
    	REFRESHING(4, "refreshing", 7, 0.1F, MobEffects.STRENGTH, 400, 1),
    	LIGHT(5, "light", 4, 0.2F, MobEffects.LEVITATION, 400, 1);

        private static final Map<Integer, FoodItemSalad.SaladType> META_LOOKUP = Maps.<Integer,FoodItemSalad.SaladType>newHashMap();
        
        private final int meta;
        private final String unlocalizedName;
        private final int baseHealAmount;
        private final float baseSaturationModifier;
        private final Potion effect;
        private final int duration;
        private final int modifier;

        private SaladType(int meta, String unlocalizedName, int baseHeal, float baseSaturation, Potion effect, int duration, int modifier)
        {
            this.meta = meta;
            this.unlocalizedName = unlocalizedName;
            this.baseHealAmount = baseHeal;
            this.baseSaturationModifier = baseSaturation;
            this.effect = effect;
            this.duration = duration;
            this.modifier = modifier;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        public int getBaseHealAmount()
        {
            return this.baseHealAmount;
        }

        public float getBaseSaturationModifier()
        {
            return this.baseSaturationModifier;
        }

        public PotionEffect getPotionEffect()
        {
        	if(this.effect != null)
        		return new PotionEffect(this.effect, this.duration, this.modifier);
        	else
        		return null;
        }
        
        public static FoodItemSalad.SaladType byMetadata(int meta)
        {
            FoodItemSalad.SaladType saladType = (FoodItemSalad.SaladType)META_LOOKUP.get(Integer.valueOf(meta));
            return saladType == null ? GREEN : saladType;
        }

        public static FoodItemSalad.SaladType byItemStack(ItemStack stack)
        {
            return stack.getItem() instanceof FoodItemSalad ? byMetadata(stack.getMetadata()) : GREEN;
        }

        static
        {
            for (FoodItemSalad.SaladType saladType : values())
            {
                META_LOOKUP.put(Integer.valueOf(saladType.getMetadata()), saladType);
            }
        }
    }
    
    @Override
	public int getMaxVariants()
    {
		return FoodItemSalad.SaladType.values().length;
	}
}
