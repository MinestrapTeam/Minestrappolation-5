package minestrapp.blocks;

import java.util.List;

import minestrapp.blocks.utility.BlockBase;
import minestrapp.blocks.utility.GravityBlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockColdSand extends GravityBlockBase
{
	public static final PropertyEnum<BlockColdSand.EnumType> VARIANT = PropertyEnum.<BlockColdSand.EnumType>create("variant", BlockColdSand.EnumType.class);
	
	public BlockColdSand()
	{
		super("cold_sand", Material.SAND, MapColor.SAND, SoundType.SAND, "shovel", 0);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockColdSand.EnumType.SAND));
	}

	public int damageDropped(IBlockState state)
    {
        return ((BlockColdSand.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockColdSand.EnumType blocksand$enumtype : BlockColdSand.EnumType.values())
        {
            list.add(new ItemStack(itemIn, 1, blocksand$enumtype.getMetadata()));
        }
    }

    public MapColor getMapColor(IBlockState state)
    {
        return ((BlockColdSand.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockColdSand.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((BlockColdSand.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @SideOnly(Side.CLIENT)
    public int func_189876_x(IBlockState p_189876_1_)
    {
        BlockColdSand.EnumType blocksand$enumtype = (BlockColdSand.EnumType)p_189876_1_.getValue(VARIANT);
        return blocksand$enumtype.func_189865_a();
    }

    public static enum EnumType implements IStringSerializable
    {
        SAND(0, "cold_sand", "default", MapColor.CLAY, -2370656),
        RED_SAND(1, "cold_red_sand", "red", MapColor.RED, -5679071);

        private static final BlockColdSand.EnumType[] META_LOOKUP = new BlockColdSand.EnumType[values().length];
        private final int meta;
        private final String name;
        private final MapColor mapColor;
        private final String unlocalizedName;
        private final int field_189866_h;

        private EnumType(int p_i47157_3_, String p_i47157_4_, String p_i47157_5_, MapColor p_i47157_6_, int p_i47157_7_)
        {
            this.meta = p_i47157_3_;
            this.name = p_i47157_4_;
            this.mapColor = p_i47157_6_;
            this.unlocalizedName = p_i47157_5_;
            this.field_189866_h = p_i47157_7_;
        }

        @SideOnly(Side.CLIENT)
        public int func_189865_a()
        {
            return this.field_189866_h;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public MapColor getMapColor()
        {
            return this.mapColor;
        }

        public static BlockColdSand.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (BlockColdSand.EnumType blocksand$enumtype : values())
            {
                META_LOOKUP[blocksand$enumtype.getMetadata()] = blocksand$enumtype;
            }
        }
    }
}
