package minestrapp.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockItemDrop extends BlockBase
{
	public ItemStack item;
	public int meta;
	public int basequant;
	public int basebonus;
	public boolean fortunebonus;
	public int minXP;
	public int maxXP;
	
	public BlockItemDrop(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel, ItemStack item, int basequant, int basebonus, boolean fortunebonus, int minXP, int maxXP)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
		this.item = item;
		this.basequant = basequant;
		this.basebonus = basebonus;
		this.fortunebonus = fortunebonus;
		this.minXP = minXP;
		this.maxXP = maxXP;
	}
	
	@Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return item.getItem();
    }
	
	public int quantityDropped(Random random)
    {
        return basequant + random.nextInt(basebonus + 1);
    }
	
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune) && fortunebonus == true)
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }
	
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = MathHelper.getRandomIntegerInRange(rand, minXP, maxXP);

            return i;
        }
        return 0;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this);
    }

    public int damageDropped(IBlockState state)
    {
        return item.getItemDamage();
    }
}
