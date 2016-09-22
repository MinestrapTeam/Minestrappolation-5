package minestrapp;

import java.util.ArrayList;
import java.util.List;

import minestrapp.guide.GuideHandler;
import minestrapp.items.IItemVariants;
import minestrapp.items.ItemBase;
import minestrapp.items.MetaItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import werty.guidance.ItemGuide;

public class ItemsRegistry {
	static List<Item> itemList = new ArrayList<Item>();
	
	//Minerals
	public static Item dusts;
	public static Item ingot_copper, ingot_tin, ingot_bronze, ingot_steel, ingot_torite, ingot_titanium, ingot_glacierite, ingot_blazium, ingot_dimensium;
	public static Item shards;
	
	public static Item gem_meurodite;
	
	//Utility Items
	public static Item minechiridion;
	
	public static void init(){
		
		//Minerals
		register(dusts = new MetaItemBase("minestrapp_dust", false, 2));
		
		register(ingot_copper = new ItemBase("ingot_copper", false).setCreativeTab(Tabs.minerals));
		register(ingot_tin = new ItemBase("ingot_tin", false).setCreativeTab(Tabs.minerals));
		register(ingot_bronze = new ItemBase("ingot_bronze", false).setCreativeTab(Tabs.minerals));
		register(ingot_steel = new ItemBase("ingot_steel", false).setCreativeTab(Tabs.minerals));
		register(ingot_torite = new ItemBase("ingot_torite", false).setCreativeTab(Tabs.minerals));
		register(ingot_titanium = new ItemBase("ingot_titanium", false).setCreativeTab(Tabs.minerals));
		register(ingot_glacierite = new ItemBase("ingot_glacierite", false).setCreativeTab(Tabs.minerals));
		register(ingot_blazium = new ItemBase("ingot_blazium", false).setCreativeTab(Tabs.minerals));
		register(ingot_dimensium = new ItemBase("ingot_dimensium", false).setCreativeTab(Tabs.minerals));
		
		register(shards = new MetaItemBase("minestrapp_shard", false, 6));
		
		register(gem_meurodite = new ItemBase("gem_meurodite", false).setCreativeTab(Tabs.minerals));
		
		//Utility Items
		register(minechiridion = new ItemGuide(GuideHandler.manager).setCreativeTab(Tabs.special_tools).setUnlocalizedName("mineguide").setRegistryName("mineguide"));
	}
	
	public static void registerRenders(){
		for(Item item: itemList){
			if(item instanceof IItemVariants){
				initModelWithVariants(item);
			} else {
				initModel(item);
			}
		}
	}
	
	public static void register(Item item){
		GameRegistry.register(item);
		itemList.add(item);
	}

	private static void initModel(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
	
	private static void initModelWithVariants(Item item){
		for(int i = 0; i < ((IItemVariants)item).getMaxVariants(); i++){
			ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName()+"_"+i,"inventory"));
		}
	}
}
