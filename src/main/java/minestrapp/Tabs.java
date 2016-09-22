package minestrapp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs {
	public static CreativeTabs resource = new CreativeTabs("ResourceBlocks")
    {
    	@Override
    	public String getTabLabel(){
    		return "ResourceBlocks";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(BlocksRegistry.block_copper);
		}
	};
	
	public static CreativeTabs utility = new CreativeTabs("UtilityBlocks")
    {
    	@Override
    	public String getTabLabel(){
    		return "UtilityBlocks";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(BlocksRegistry.block_irradiant_sunstone);
		}
	};
    
    public static CreativeTabs minerals = new CreativeTabs("Minerals")
    {
    	@Override
    	public String getTabLabel(){
    		return "Minerals";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return ItemsRegistry.ingot_copper;
		}
	};
	
	public static CreativeTabs special_tools = new CreativeTabs("SpecialtyTools")
    {
    	@Override
    	public String getTabLabel(){
    		return "SpecialtyTools";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return ItemsRegistry.minechiridion;
		}
	};
}
