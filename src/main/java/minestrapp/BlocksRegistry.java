package minestrapp;

import java.util.ArrayList;
import java.util.List;

import minestrapp.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksRegistry {
	public static List<Block> blockList = new ArrayList<Block>();
	
	public static Block block_copper;
	
	public static void init(){
		register(block_copper = new BlockBase("block_copper", Material.IRON, MapColor.ADOBE, SoundType.METAL, "pickaxe", 0).setHardness(4.0F).setResistance(10.0F).setCreativeTab(Minestrappolation.tab));
	}
	
	public static void registerRenders(){
		for(Block block: blockList){
			initModel(block);
		}
	}
	
	public static void register(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		blockList.add(block);
	}
	
	public static void register(Block block, ItemBlock itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		blockList.add(block);
	}
	
	private static void initModel(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}
}
