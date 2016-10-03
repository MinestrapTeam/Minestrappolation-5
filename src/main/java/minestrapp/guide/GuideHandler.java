package minestrapp.guide;

import minestrapp.ItemsRegistry;
import minestrapp.Minestrappolation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import werty.guidance.gui.EnumPageType;
import werty.guidance.gui.GuideEntry;
import werty.guidance.gui.GuideGroup;
import werty.guidance.gui.GuideInfoPage;
import werty.guidance.gui.GuideManager;

public class GuideHandler {
	public static GuideManager manager = new GuideManager();
	
	public static GuideGroup basics = new GuideGroup("Game Mechanics");
	public static GuideGroup plant = new GuideGroup("Organic Blocks");
	public static GuideGroup soil = new GuideGroup("Soil Blocks");
	public static GuideGroup frost = new GuideGroup("Frozen Blocks");
	public static GuideGroup stone = new GuideGroup("Stone Blocks");
	public static GuideGroup ore = new GuideGroup("Ores");
	public static GuideGroup resource = new GuideGroup("Resource Storage Blocks");
	public static GuideGroup glass = new GuideGroup("Glass Blocks");
	public static GuideGroup misc_building = new GuideGroup("Misc. Building Blocks");
	public static GuideGroup wood_building = new GuideGroup("Wood Building Blocks");
	public static GuideGroup stone_building = new GuideGroup("Stone Building Blocks");
	public static GuideGroup decor = new GuideGroup("Decorative Blocks");
	public static GuideGroup utility = new GuideGroup("Utility Blocks");
	public static GuideGroup redstone = new GuideGroup("Redstone Mechanisms");
	public static GuideGroup machine = new GuideGroup("Tool/Machine Blocks");
	public static GuideGroup crops = new GuideGroup("Seeds & Crops");
	public static GuideGroup materials = new GuideGroup("Raw Materials");
	public static GuideGroup mob_loot = new GuideGroup("Mob Loot");
	public static GuideGroup ingredients = new GuideGroup("Crafting Ingredients");
	public static GuideGroup food = new GuideGroup("Foodstuffs");
	public static GuideGroup potions = new GuideGroup("Potions");
	public static GuideGroup enchant = new GuideGroup("Enchantments");
	public static GuideGroup transport = new GuideGroup("Transportation Items");
	public static GuideGroup tool = new GuideGroup("Tools");
	public static GuideGroup special_tool = new GuideGroup("Specialty Tools");
	public static GuideGroup weapon = new GuideGroup("Weapons");
	public static GuideGroup special_weapon = new GuideGroup("Specialty Weapons");
	public static GuideGroup armor = new GuideGroup("Armor");
	
	public static void preInit(){
		manager.textColor = 0;
		
		manager.imgGuide = new ResourceLocation(Minestrappolation.MODID+":textures/gui/guide.png");
		manager.imgGuideBG = new ResourceLocation(Minestrappolation.MODID+":textures/gui/guideBG.png");
		
		manager.registerEntryGroup(basics);
		manager.registerEntryGroup(plant);
		manager.registerEntryGroup(soil);
		manager.registerEntryGroup(frost);
		manager.registerEntryGroup(stone);
		manager.registerEntryGroup(ore);
		manager.registerEntryGroup(resource);
		manager.registerEntryGroup(glass);
		manager.registerEntryGroup(misc_building);
		manager.registerEntryGroup(wood_building);
		manager.registerEntryGroup(stone_building);
		manager.registerEntryGroup(decor);
		manager.registerEntryGroup(utility);
		manager.registerEntryGroup(redstone);
		manager.registerEntryGroup(machine);
		manager.registerEntryGroup(crops);
		manager.registerEntryGroup(materials);
		manager.registerEntryGroup(mob_loot);
		manager.registerEntryGroup(ingredients);
		manager.registerEntryGroup(food);
		manager.registerEntryGroup(potions);
		manager.registerEntryGroup(enchant);
		manager.registerEntryGroup(transport);
		manager.registerEntryGroup(tool);
		manager.registerEntryGroup(special_tool);
		manager.registerEntryGroup(weapon);
		manager.registerEntryGroup(special_weapon);
		manager.registerEntryGroup(armor);
		
		basics.addEntry(new GuideEntry("minechiridion", "Minechiridion", new ItemStack(ItemsRegistry.minechiridion), 32, 32));
		manager.registerInfoPage("minechiridion", new GuideInfoPage("minechiridion", EnumPageType.INFO));
		
		plant.addEntry(new GuideEntry("oak_sapling", "Oak Sapling", new ItemStack(Blocks.SAPLING, 0, 0), 32, 32));
		manager.registerInfoPage("oak_sapling", new GuideInfoPage("oak_sapling", EnumPageType.INFO));
		plant.addEntry(new GuideEntry("spruce_sapling", "Spruce Sapling", new ItemStack(Blocks.SAPLING, 0, 1), 48, 32));
		manager.registerInfoPage("spruce_sapling", new GuideInfoPage("spruce_sapling", EnumPageType.INFO));
		plant.addEntry(new GuideEntry("birch_sapling", "Birch Sapling", new ItemStack(Blocks.SAPLING, 0, 2), 64, 32));
		manager.registerInfoPage("birch_sapling", new GuideInfoPage("birch_sapling", EnumPageType.INFO));
		plant.addEntry(new GuideEntry("jungle_sapling", "Jungle Sapling", new ItemStack(Blocks.SAPLING, 0, 3), 80, 32));
		manager.registerInfoPage("jungle_sapling", new GuideInfoPage("jungle_sapling", EnumPageType.INFO));
		plant.addEntry(new GuideEntry("acacia_sapling", "Acacia Sapling", new ItemStack(Blocks.SAPLING, 0, 4), 96, 32));
		manager.registerInfoPage("acacia_sapling", new GuideInfoPage("acacia_sapling", EnumPageType.INFO));
		plant.addEntry(new GuideEntry("dark_oak_sapling", "Dark Oak Sapling", new ItemStack(Blocks.SAPLING, 0, 5), 112, 32));
		manager.registerInfoPage("dark_oak_sapling", new GuideInfoPage("dark_oak_sapling", EnumPageType.INFO));
		
		soil.addEntry(new GuideEntry("dirt", "Dirt", new ItemStack(Blocks.DIRT, 0, 0), 32, 32));
		manager.registerInfoPage("dirt", new GuideInfoPage("dirt", EnumPageType.INFO));
		soil.addEntry(new GuideEntry("coarse_dirt", "Coarse Dirt", new ItemStack(Blocks.DIRT, 0, 1), 48, 32));
		manager.registerInfoPage("coarse_dirt", new GuideInfoPage("coarse_dirt", EnumPageType.INFO));
		soil.addEntry(new GuideEntry("grass", "Grass", new ItemStack(Blocks.GRASS), 64, 32));
		manager.registerInfoPage("grass", new GuideInfoPage("grass", EnumPageType.INFO));
		soil.addEntry(new GuideEntry("podzol", "Podzol", new ItemStack(Blocks.DIRT, 0, 2), 80, 32));
		manager.registerInfoPage("podzol", new GuideInfoPage("podzol", EnumPageType.INFO));
		soil.addEntry(new GuideEntry("sand", "Sand", new ItemStack(Blocks.SAND, 0, 0), 96, 32));
		manager.registerInfoPage("sand", new GuideInfoPage("sand", EnumPageType.INFO));
		soil.addEntry(new GuideEntry("red_sand", "Red Sand", new ItemStack(Blocks.SAND, 0, 1), 112, 32));
		manager.registerInfoPage("red_sand", new GuideInfoPage("red_sand", EnumPageType.INFO));
		soil.addEntry(new GuideEntry("gravel", "Gravel", new ItemStack(Blocks.GRAVEL), 128, 32));
		manager.registerInfoPage("gravel", new GuideInfoPage("gravel", EnumPageType.INFO));
		
		stone.addEntry(new GuideEntry("stone", "Stone", new ItemStack(Blocks.STONE, 1, 0), 32, 32));
		manager.registerInfoPage("stone", new GuideInfoPage("stone", EnumPageType.INFO));
		stone.addEntry(new GuideEntry("granite", "Granite", new ItemStack(Blocks.STONE, 1, 1), 48, 32));
		manager.registerInfoPage("granite", new GuideInfoPage("granite", EnumPageType.INFO));
		stone.addEntry(new GuideEntry("diorite", "Diorite", new ItemStack(Blocks.STONE, 1, 3), 64, 32));
		manager.registerInfoPage("diorite", new GuideInfoPage("diorite", EnumPageType.INFO));
		stone.addEntry(new GuideEntry("andesite", "Andesite", new ItemStack(Blocks.STONE, 1, 5), 80, 32));
		manager.registerInfoPage("andesite", new GuideInfoPage("andesite", EnumPageType.INFO));
		stone.addEntry(new GuideEntry("bedrock", "Bedrock", new ItemStack(Blocks.BEDROCK), 96, 32));
		manager.registerInfoPage("bedrock", new GuideInfoPage("bedrock", EnumPageType.INFO));
		
		ore.addEntry(new GuideEntry("coal_ore", "Coal Ore", new ItemStack(Blocks.COAL_ORE), 32, 32));
		manager.registerInfoPage("coal_ore", new GuideInfoPage("coal_ore", EnumPageType.INFO));
		ore.addEntry(new GuideEntry("iron_ore", "Iron Ore", new ItemStack(Blocks.IRON_ORE), 32, 32));
		manager.registerInfoPage("iron_ore", new GuideInfoPage("iron_ore", EnumPageType.INFO));
		ore.addEntry(new GuideEntry("gold_ore", "Gold Ore", new ItemStack(Blocks.GOLD_ORE), 32, 32));
		manager.registerInfoPage("gold_ore", new GuideInfoPage("gold_ore", EnumPageType.INFO));
		
		wood_building.addEntry(new GuideEntry("oak_planks", "Oak Wood Planks", new ItemStack(Blocks.PLANKS, 1, 0), 32, 32));
		manager.registerInfoPage("oak_planks", new GuideInfoPage("oak_planks", EnumPageType.INFO));
		wood_building.addEntry(new GuideEntry("spruce_planks", "Spruce Wood Planks", new ItemStack(Blocks.PLANKS, 1, 1), 48, 32));
		manager.registerInfoPage("spruce_planks", new GuideInfoPage("spruce_planks", EnumPageType.INFO));
		wood_building.addEntry(new GuideEntry("birch_planks", "Birch Wood Planks", new ItemStack(Blocks.PLANKS, 1, 2), 64, 32));
		manager.registerInfoPage("birch_planks", new GuideInfoPage("birch_planks", EnumPageType.INFO));
		wood_building.addEntry(new GuideEntry("jungle_planks", "Jungle Wood Planks", new ItemStack(Blocks.PLANKS, 1, 3), 80, 32));
		manager.registerInfoPage("jungle_planks", new GuideInfoPage("jungle_planks", EnumPageType.INFO));
		wood_building.addEntry(new GuideEntry("acacia_planks", "Acacia Wood Planks", new ItemStack(Blocks.PLANKS, 1, 4), 96, 32));
		manager.registerInfoPage("acacia_planks", new GuideInfoPage("acacia_planks", EnumPageType.INFO));
		wood_building.addEntry(new GuideEntry("dark_oak_planks", "Dark Oak Wood Planks", new ItemStack(Blocks.PLANKS, 1, 5), 112, 32));
		manager.registerInfoPage("dark_oak_planks", new GuideInfoPage("dark_oak_planks", EnumPageType.INFO));
		
		stone_building.addEntry(new GuideEntry("cobblestone", "Cobblestone", new ItemStack(Blocks.COBBLESTONE), 32, 32));
		manager.registerInfoPage("cobblestone", new GuideInfoPage("cobblestone", EnumPageType.INFO));
		stone_building.addEntry(new GuideEntry("polished_granite", "Polished Granite", new ItemStack(Blocks.STONE, 1, 2), 48, 32));
		manager.registerInfoPage("polished_granite", new GuideInfoPage("polished_granite", EnumPageType.INFO));
		stone_building.addEntry(new GuideEntry("polished_diorite", "Polished Diorite", new ItemStack(Blocks.STONE, 1, 4), 64, 32));
		manager.registerInfoPage("polished_diorite", new GuideInfoPage("polished_diorite", EnumPageType.INFO));		
		stone_building.addEntry(new GuideEntry("polished_andesite", "Polished Andesite", new ItemStack(Blocks.STONE, 1, 6), 80, 32));
		manager.registerInfoPage("polished_andesite", new GuideInfoPage("polished_andesite", EnumPageType.INFO));
	}

}
