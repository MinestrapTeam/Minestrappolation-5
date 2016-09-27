package minestrapp.blocks;

import java.util.Random;

import minestrapp.ItemsRegistry;
import minestrapp.blocks.utility.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlaciericIce extends BlockBase
{

	public BlockGlaciericIce(String name, Material materialIn, MapColor mapcolor, SoundType soundtype, String tool, int harvestlevel)
	{
		super(name, materialIn, mapcolor, soundtype, tool, harvestlevel);
		this.slipperiness = 1.1F;
		this.setLightLevel(0.3F);
	}

	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 5);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(4);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ItemsRegistry.shards;
	}
	
	public int damageDropped(IBlockState state)
    {
        return 2;
    }
}
