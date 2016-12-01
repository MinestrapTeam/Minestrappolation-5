package minestrapp;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import minestrapp.blocks.BlockBlazium;
import minestrapp.blocks.BlockColdSand;
import minestrapp.blocks.BlockDeadBranch;
import minestrapp.blocks.BlockGlaciericIce;
import minestrapp.blocks.BlockGodstone;
import minestrapp.blocks.BlockInvincium;
import minestrapp.blocks.BlockIrradiantSunstone;
import minestrapp.blocks.BlockIrradium;
import minestrapp.blocks.BlockRope;
import minestrapp.blocks.GlassBlockBase;
import minestrapp.blocks.utility.BlockBase;
import minestrapp.blocks.utility.BlockItemDrop;
import minestrapp.blocks.utility.GravityBlockBase;
import minestrapp.items.BlockItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksRegistry {
	public static List<Block> blockList = new ArrayList<Block>();
	
	//Soil
	public static Block cold_sand;
	public static Block rubble;
	
	//Plants
	public static Block dead_branch;
	
	//Stone
	public static Block invincium, invincium_glacial;
	
	//Resource Blocks
	public static Block block_copper, block_tin, block_bronze, block_steel, block_meurodite, block_torite, block_sunstone, block_irradiant_sunstone, block_irradium, block_titanium, block_glacierite, block_blazium, block_soul, block_dimensium;
	
	//Glass
	public static Block glow_glass;
	
	//Utility Blocks
	public static Block rope, glacieric_ice, godstone;
	
	//Machines
	public static Block melter;
	public static void init(){
		// REGISTER BLOCKS
		//Soil
		register(cold_sand = new BlockColdSand().setHardness(0.7F).setCreativeTab(Tabs.environment), new ItemBlock(cold_sand).setHasSubtypes(true));
		register(rubble =  new GravityBlockBase("rubble", Material.ROCK, MapColor.STONE, SoundType.STONE, "pickaxe", 0).setHardness(1.75F).setResistance(8.0F).setCreativeTab(Tabs.environment));
		
		//Plants
		register(dead_branch = new BlockDeadBranch("dead_branch", Material.VINE, MapColor.WOOD, SoundType.PLANT, null, 0).setHardness(0.3F).setCreativeTab(Tabs.plant));
		
		//Stone
		register(invincium = new BlockInvincium("invincium", MapColor.NETHERRACK).setEntityInvulnerability("all").setLightLevel(0.2F).setCreativeTab(Tabs.environment).setResistance(1000000F));
		register(invincium_glacial = new BlockBase("invincium_glacial", Material.ROCK, MapColor.CYAN, SoundType.STONE, null, 0).setEntityInvulnerability("all").setSlipperiness(0.97F).setBlockUnbreakable().setResistance(1000000F).setCreativeTab(Tabs.environment));
		
		//Resource Blocks
		register(block_copper = new BlockBase("block_copper", Material.IRON, MapColor.ADOBE, SoundType.METAL, "pickaxe", 0).setHardness(4.0F).setResistance(10.0F).setCreativeTab(Tabs.resource));
		register(block_tin = new BlockBase("block_tin", Material.IRON, MapColor.CLOTH, SoundType.METAL, "pickaxe", 1).setHardness(3.5F).setResistance(5.0F).setCreativeTab(Tabs.resource));
		register(block_bronze = new BlockBase("block_bronze", Material.IRON, MapColor.WOOD, SoundType.METAL, "pickaxe", 1).setHardness(5.0F).setResistance(20.0F).setCreativeTab(Tabs.resource));
		register(block_steel = new BlockBase("block_steel", Material.IRON, MapColor.ICE, SoundType.METAL, "pickaxe", 1).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tabs.resource));
		register(block_meurodite = new BlockBase("block_meurodite", Material.IRON, MapColor.BLUE, SoundType.METAL, "pickaxe", 2).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tabs.resource));
		register(block_torite = new BlockBase("block_torite", Material.IRON, MapColor.GREEN, SoundType.METAL, "pickaxe", 2).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tabs.resource));
		register(block_sunstone = new BlockItemDrop("block_sunstone", Material.GLASS, MapColor.SAND, SoundType.GLASS, null, 0, new ItemStack(ItemsRegistry.shards, 1, 2), 0, 2, false, 0, 0).setHardness(0.3F).setLightLevel(1.0F).setCreativeTab(Tabs.resource));
		register(block_irradiant_sunstone = new BlockIrradiantSunstone("block_irradiant_sunstone", Material.GLASS, MapColor.LIME, SoundType.GLASS, null, 0, 4).setHardness(0.3F).setLightLevel(1.0F).setCreativeTab(Tabs.utility));
		register(block_irradium = new BlockIrradium("block_irradium", Material.ROCK, MapColor.LIME, SoundType.STONE, "pickaxe", 1, 4).setHardness(3.5F).setResistance(5.0F).setCreativeTab(Tabs.resource));
		register(block_titanium = new BlockBase("block_titanium", Material.IRON, MapColor.GRAY, SoundType.METAL, "pickaxe", 3).setHardness(10.0F).setResistance(10000.0F).setCreativeTab(Tabs.resource));
		register(block_glacierite = new BlockBase("block_glacierite", Material.IRON, MapColor.CYAN, SoundType.METAL, "pickaxe", 2).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tabs.resource));
		register(block_blazium = new BlockBlazium("block_blazium", Material.IRON, MapColor.RED, SoundType.METAL, "pickaxe", 2).setHardness(5.0F).setResistance(10.0F).setLightLevel(0.5F).setCreativeTab(Tabs.resource));
		register(block_soul = new BlockBase("block_soul", Material.IRON, MapColor.CYAN, SoundType.METAL, "pickaxe", 1).setHardness(3.0F).setResistance(8.0F).setCreativeTab(Tabs.resource));
		register(block_dimensium = new BlockBase("block_dimensium", Material.IRON, MapColor.MAGENTA, SoundType.METAL, "pickaxe", 3).setEntityInvulnerability("dragon").setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tabs.resource));
		
		//Glass
		register(glow_glass = new GlassBlockBase("glow_glass", Material.GLASS, MapColor.GOLD, SoundType.GLASS, null, 0, 1, true, false).setLightLevel(0.85F).setCreativeTab(Tabs.building));
		
		//Utility Blocks
		register(rope = new BlockRope("rope", Material.CLOTH, MapColor.WOOD, SoundType.CLOTH, "shears", 0).setHardness(0.8F).setCreativeTab(Tabs.utility));
		register(glacieric_ice = new BlockGlaciericIce("glacieric_ice", Material.PACKED_ICE, MapColor.ICE, SoundType.GLASS, "pickaxe", 0).setHardness(0.5F).setCreativeTab(Tabs.utility));
		register(godstone = new BlockGodstone("godstone", Material.ROCK, MapColor.SAND, SoundType.STONE, "pickaxe", 1).setEntityInvulnerability("dragon").setHardness(3.0F).setResistance(15.0F).setLightLevel(1F).setCreativeTab(Tabs.utility));
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
	
	public static void register(Block block, Item itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		blockList.add(block);
	}
	
	private static void initModel(Block block){
		for(int i = 0 ; i < 16 ; i++)
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), i, new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}
}
