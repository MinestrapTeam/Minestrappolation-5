package minestrapp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs {
	public static CreativeTabs environment = new CreativeTabs("EnvironmentalBlocks")
    {
    	@Override
    	public String getTabLabel(){
    		return "EnvironmentalBlocks";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(BlocksRegistry.rubble);
		}
	};
	
	public static CreativeTabs plant = new CreativeTabs("PlantBlocks")
    {
    	@Override
    	public String getTabLabel(){
    		return "PlantBlocks";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(BlocksRegistry.dead_branch);
		}
	};
	
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
			return ItemsRegistry.ingots;
		}
	};
	
	public static CreativeTabs materials = new CreativeTabs("Materials")
    {
    	@Override
    	public String getTabLabel(){
    		return "Materials";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return ItemsRegistry.tech_component;
		}
	};
	
	public static CreativeTabs foods = new CreativeTabs("Foods")
    {
    	@Override
    	public String getTabLabel(){
    		return "Foods";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return ItemsRegistry.raspberry;
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
