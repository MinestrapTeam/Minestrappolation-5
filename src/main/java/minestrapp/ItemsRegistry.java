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
	public static Item shard_sunstone;
	
	//Utility Items
	public static Item minechiridion;
	
	public static void init(){
		
		//Minerals
		register(shard_sunstone = new ItemBase("shard_sunstone").setCreativeTab(Minestrappolation.tab));
		
		//Utility Items
		register(minechiridion = new ItemGuide(GuideHandler.manager).setCreativeTab(Minestrappolation.tab).setUnlocalizedName("mineguide").setRegistryName("mineguide"));
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
