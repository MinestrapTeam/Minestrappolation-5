package minestrapp;

import java.util.ArrayList;
import java.util.List;

import minestrapp.guide.GuideHandler;
import minestrapp.items.IItemVariants;
import minestrapp.items.ItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import werty.guidance.ItemGuide;

public class ItemsRegistry {
	static List<Item> itemList = new ArrayList<Item>();
	
	//Minerals
	public static Item dust_irradium;
	public static Item dust_dimensium;
	
	public static Item ingot_copper;
	public static Item ingot_tin;
	public static Item ingot_bronze;
	public static Item ingot_steel;
	public static Item ingot_torite;
	public static Item ingot_titanium;
	public static Item ingot_glacierite;
	public static Item ingot_blazium;
	public static Item ingot_dimensium;
	
	public static Item shard_desert_quartz;
	public static Item shard_radiant_quartz;
	public static Item shard_sunstone;
	public static Item shard_glacieric_ice;
	public static Item shard_blazium;
	public static Item shard_jadachite;
	
	public static Item gem_meurodite;
	
	//Utility Items
	public static Item minechiridion;
	
	public static void init(){
		
		//Minerals
		register(dust_irradium = new ItemBase("dust_irradium", false).setCreativeTab(Minestrappolation.minerals));
		register(dust_dimensium = new ItemBase("dust_dimensium", false).setCreativeTab(Minestrappolation.minerals));
		
		register(ingot_copper = new ItemBase("ingot_copper", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_tin = new ItemBase("ingot_tin", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_bronze = new ItemBase("ingot_bronze", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_steel = new ItemBase("ingot_steel", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_torite = new ItemBase("ingot_torite", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_titanium = new ItemBase("ingot_titanium", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_glacierite = new ItemBase("ingot_glacierite", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_blazium = new ItemBase("ingot_blazium", false).setCreativeTab(Minestrappolation.minerals));
		register(ingot_dimensium = new ItemBase("ingot_dimensium", false).setCreativeTab(Minestrappolation.minerals));
		
		register(shard_desert_quartz = new ItemBase("shard_desert_quartz", false).setCreativeTab(Minestrappolation.minerals));
		register(shard_radiant_quartz = new ItemBase("shard_radiant_quartz", true).setCreativeTab(Minestrappolation.minerals));
		register(shard_sunstone = new ItemBase("shard_sunstone", false).setCreativeTab(Minestrappolation.minerals));
		register(shard_glacieric_ice = new ItemBase("shard_glacieric_ice", false).setCreativeTab(Minestrappolation.minerals));
		register(shard_blazium = new ItemBase("shard_blazium", false).setCreativeTab(Minestrappolation.minerals));
		register(shard_jadachite = new ItemBase("shard_jadachite", false).setCreativeTab(Minestrappolation.minerals));
		
		register(gem_meurodite = new ItemBase("gem_meurodite", false).setCreativeTab(Minestrappolation.minerals));
		
		//Utility Items
		register(minechiridion = new ItemGuide(GuideHandler.manager).setCreativeTab(Minestrappolation.special_tools).setUnlocalizedName("mineguide").setRegistryName("mineguide"));
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
			ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(),"inventory"));
		}
	}
}
