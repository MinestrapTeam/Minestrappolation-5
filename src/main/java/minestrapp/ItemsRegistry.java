package minestrapp;

import java.util.ArrayList;
import java.util.List;

import minestrapp.guide.GuideHandler;
import minestrapp.items.IItemVariants;
import minestrapp.items.ItemBase;
import minestrapp.items.MetaItemBase;
import minestrapp.items.food.FoodItemBase;
import minestrapp.items.food.FoodItemBowl;
import minestrapp.items.food.FoodItemCandy;
import minestrapp.items.food.FoodItemSalad;
import minestrapp.items.food.FoodItemSpecial;
import minestrapp.items.misc.ItemGuano;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import werty.guidance.ItemGuide;

public class ItemsRegistry {
	static List<Item> itemList = new ArrayList<Item>();
	
	//Foods
	public static Item blueberry;
	public static Item raspberry;
	public static Item blackberry;
	public static Item strawberry;
	public static Item farberry;
	
	public static Item pepper;
	public static Item celery;
	public static Item tomato;
	public static Item corn_stick;
	public static Item corn_grilled;
		
	public static Item corn_meal;
	public static Item corn_bread;
	public static Item dough;
	public static Item cookie_sugar;
	public static Item bun;
	public static Item sandwich_pbj;
	public static Item sandwich_salmon;
	public static Item sandwich_hamburger;
	public static Item dry_spaghetti;
	public static Item pie_crust;
	public static Item pie_apple;
		
	public static Item bread_bowl;
	public static Item bread_mushroom_stew;
	public static Item bread_beetroot_soup;
	public static Item bread_rabbit_stew;
	public static Item bowl_fried_egg;
	public static Item bread_fried_egg;
	public static Item bowl_rice;
	public static Item bread_rice;
	public static Item bowl_stir_fry;
	public static Item bread_stir_fry;
	public static Item bowl_tomato_sauce;
	public static Item bread_tomato_sauce;
	public static Item bowl_tomato_soup;
	public static Item bread_tomato_soup;
	public static Item bowl_spaghetti;
	public static Item bread_spaghetti;
	public static Item bowl_salads;
	public static Item bread_salads;
	public static Item bowl_popcorn;
	public static Item bread_popcorn;
	public static Item bowl_ice_cream;
	public static Item bread_ice_cream;
	public static Item bowl_glowshroom_stew;
	public static Item bread_glowshroom_stew;
		
	public static Item bottle_jam;
	public static Item bottle_peanut_butter;
	public static Item bottle_hot_sauce;
		
	public static Item fat;
	public static Item squid_tentacle;
	public static Item calamari;
	public static Item sushi;
	public static Item lucky_sushi;
	public static Item onigiri;
	public static Item flesh;
		
	public static Item fries;
	public static Item fried_fish;
	public static Item fried_salmon;
	public static Item fish_and_chips;
		
	public static Item candies;
	
	//Plant Products
	public static Item mana_leaf;
		
	//Minerals
	public static Item dusts;
	
	public static Item chunks;
	
	public static Item ingots;
	
	public static Item shards;
	public static Item shard_radiant_quartz;
	
	public static Item gem_meurodite;
	
	//Crafting Ingredients
	public static Item crushed_ice;
	public static Item grease;
	public static Item guano;
	public static Item deathmeal;
	public static Item mob_loot;
	public static Item animal_feet;
	public static Item gene_samples;
	
	public static Item crafting_ingredients;
	public static Item platings;
	public static Item tech_component;
	public static Item enderporter_chips;
	public static Item heart_piece;
	public static Item crystal_heart;
	
	//Utility Items
	public static Item minechiridion;
	
	public static void init(){
		
		//Foods
		register(blueberry = new FoodItemBase("blueberry", 1, 2.0F, false).setPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 200, 0), 0.2F));
		register(raspberry = new FoodItemBase("raspberry", 1, 0.0F, false).setHealAmount(4, 0.45F));
		register(blackberry = new FoodItemBase("blackberry", 2, 0.4F, false).setPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 0), 0.3F));
		register(strawberry = new FoodItemBase("strawberry", 2, 0.5F, false).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0), 0.35F));
		register(farberry = new FoodItemBase("farberry", 0, 1.0F, false).setPotionEffect(new PotionEffect(MobEffects.LEVITATION, 200, 0), 0.35F).setAlwaysEdible());
				
		register(pepper = new FoodItemBase("pepper", 4, 0.4F, false).setPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 0), 0.5F));
		register(celery = new FoodItemBase("celery", 2, 0.4F, false));
		register(tomato = new FoodItemBase("tomato", 3, 0.4F, false));
		register(corn_stick = new FoodItemBase("corn_stick", 3, 0.5F, false).setLeftoverItem(new ItemStack(Items.STICK, 1)));
		register(corn_grilled = new FoodItemBase("corn_grilled", 6, 3, false).setLeftoverItem(new ItemStack(Items.STICK, 1)));
				
		register(corn_meal = new FoodItemBase("corn_meal", 1, 0.5F, false));
		register(corn_bread = new FoodItemBase("corn_bread", 4, 1F, false));
		register(dough = new FoodItemBase("dough", 1, 0.2F, false));
		register(cookie_sugar = new FoodItemBase("cookie_sugar", 1, 0.4F, false).setPotionEffect(new PotionEffect(MobEffects.HASTE, 300, 0), 0.6F));
		register(bun = new FoodItemBase("bun", 2, 0.3F, false));
		register(sandwich_pbj = new FoodItemSpecial("sandwich_pbj", 14, 2.5F, false, "jam"));
		register(sandwich_salmon = new FoodItemBase("sandwich_salmon", 20, 2.2F, false));
		register(sandwich_hamburger = new FoodItemBase("sandwich_hamburger", 18, 2F, false));
		register(dry_spaghetti = new FoodItemBase("dry_spaghetti", 1, 0, false).setHealAmount(-1, 0.9F));
		register(pie_crust = new FoodItemBase("pie_crust", 2, 0.2F, false));
		register(pie_apple = new FoodItemBase("pie_apple", 6, 0.7F, false));
				
		register(bread_bowl = new FoodItemBase("bread_bowl", 2, 0.3F, false));
		register(bread_mushroom_stew =  new FoodItemBase("bread_mushroom_stew", 8, 0.6F, false));
		register(bread_beetroot_soup =  new FoodItemBase("bread_beetroot_soup", 6, 0.6F, false));
		register(bread_rabbit_stew =  new FoodItemBase("bread_rabbit_stew", 12, 0.6F, false));
		register(bowl_fried_egg = new FoodItemBowl("bowl_fried_egg", 6, 0.4F, false, null, new ItemStack(Items.BOWL)));
		register(bread_fried_egg =  new FoodItemBase("bread_fried_egg", 8, 0.4F, false));
		register(bowl_rice = new FoodItemBowl("bowl_rice", 5, 0.8F, false, null, new ItemStack(Items.BOWL)).setLeftoverItem(new ItemStack(Items.STICK, 1)));
		register(bread_rice =  new FoodItemBase("bread_rice", 7, 0.8F, false).setLeftoverItem(new ItemStack(Items.STICK, 1)));
		register(bowl_stir_fry = new FoodItemBowl("bowl_stir_fry", 8, 1F, false, null, new ItemStack(Items.BOWL)).setFireMode(1, 12).setLeftoverItem(new ItemStack(Items.STICK, 1)).setPotionEffect(new PotionEffect(MobEffects.SPEED, 240, 2), 1F));
		register(bread_stir_fry =  new FoodItemBase("bread_stir_fry", 10, 1F, false).setFireMode(1, 12).setLeftoverItem(new ItemStack(Items.STICK, 1)).setPotionEffect(new PotionEffect(MobEffects.SPEED, 240, 2), 1F));
		register(bowl_tomato_sauce = new FoodItemBowl("bowl_tomato_sauce", 6, 0.4F, false, null, new ItemStack(Items.BOWL)));
		register(bread_tomato_sauce =  new FoodItemBase("bread_tomato_sauce", 8, 0.4F, false));
		register(bowl_tomato_soup = new FoodItemBowl("bowl_tomato_soup", 8, 3.4F, false, null, new ItemStack(Items.BOWL)));
		register(bread_tomato_soup =  new FoodItemBase("bread_tomato_soup", 10, 3.4F, false));
		register(bowl_spaghetti = new FoodItemBowl("bowl_spaghetti", 12, 1.5F, false, null, new ItemStack(Items.BOWL)));
		register(bread_spaghetti =  new FoodItemBase("bread_spaghetti", 14, 1.5F, false));
		register(bowl_salads = new FoodItemSalad("bowl_salads", false).setMaxStackSize(1));
		register(bread_salads = new FoodItemSalad("bread_salads", true));
		register(bowl_popcorn = new FoodItemBowl("bowl_popcorn", 5, 0.2F, false, null, new ItemStack(Items.BOWL)));
		register(bread_popcorn =  new FoodItemBase("bread_popcorn", 7, 0.2F, false));
		register(bowl_ice_cream = new FoodItemBowl("bowl_ice_cream", 6, 0.6F, false, null, new ItemStack(Items.BOWL)).setFireMode(2, 0).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0), 1F));
		register(bread_ice_cream =  new FoodItemBase("bread_ice_cream", 8, 0.6F, false).setFireMode(2, 0).setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0), 1F));
		register(bowl_glowshroom_stew = new FoodItemBowl("bowl_glowshroom_stew", 6, 0.4F, false, "glowshroom", new ItemStack(Items.BOWL)));
		register(bread_glowshroom_stew =  new FoodItemSpecial("bread_glowshroom_stew", 8, 0.4F, false, "glowshroom"));
			
		register(bottle_jam = new FoodItemBowl("bottle_jam", 6, 2.9F, false, "jam", new ItemStack(Items.GLASS_BOTTLE)));
		register(bottle_peanut_butter = new FoodItemBowl("bottle_peanut_butter", 7, 1.2F, false, null, new ItemStack(Items.GLASS_BOTTLE)));
		register(bottle_hot_sauce = new FoodItemBowl("bottle_hot_sauce", 0, 0.2F, false, null, new ItemStack(Items.GLASS_BOTTLE)).setFireMode(1, 20).setPotionEffect(new PotionEffect(MobEffects.SPEED, 400, 2), 1F));
		
		register(fat = new FoodItemBase("fat", 2, 3.0F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 200, 0), 0.7F));
		register(squid_tentacle = new FoodItemBase("squid_tentacle", 2, 0.3F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 1), 0.7F));
		register(calamari =  new FoodItemBase("calamari", 5, 0.6F, false));
		register(sushi = new FoodItemBase("sushi", 14, 1.8F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 1), 0.35F));
		register(lucky_sushi = new FoodItemSpecial("lucky_sushi", 12, 1F, false, "lucky"));
		register(onigiri = new FoodItemBase("onigiri", 7, 1F, false));
		register(flesh = new FoodItemBase("flesh", 4, 0.4F, true));
		
		register(fries = new FoodItemBase("fries", 7, 0.4F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 0), 0.1F));
		register(fried_fish = new FoodItemBase("fried_fish", 7, 0.5F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 0), 0.6F));
		register(fried_salmon = new FoodItemBase("fried_salmon", 9, 0.7F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 0), 0.6F));
		register(fish_and_chips = new FoodItemBase("fish_and_chips", 14, 0.8F, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 0), 0.6F));
		
		register(candies = new FoodItemCandy("candy").setHealAmount(6, 1F).setAlwaysEdible());
		
		//Plant Products
		register(mana_leaf = new ItemBase("mana_leaf", false).setCreativeTab(Tabs.materials));
		
		//Minerals
		register(dusts = new MetaItemBase("minestrapp_dust", false, 4).setCreativeTab(Tabs.minerals));
		
		register(chunks = new MetaItemBase("minestrapp_chunk", false, 14).setCreativeTab(Tabs.minerals));
		
		register(ingots = new MetaItemBase("minestrapp_ingot", false, 9).setCreativeTab(Tabs.minerals));
		
		register(shards = new MetaItemBase("minestrapp_shard", false, 5).setCreativeTab(Tabs.minerals));
		register(shard_radiant_quartz = new ItemBase("shard_radiant_quartz", true).setCreativeTab(Tabs.minerals));
		
		register(gem_meurodite = new ItemBase("gem_meurodite", false).setCreativeTab(Tabs.minerals));
		
		//Crafting Ingredients
		register(crushed_ice = new FoodItemBase("crushed_ice", 0, 0, false).setFireMode(2, 0).setAlwaysEdible().setCreativeTab(Tabs.materials));
		register(grease = new ItemBase("grease", false).setCreativeTab(Tabs.materials));
		register(guano = new ItemGuano("guano").setCreativeTab(Tabs.materials));
		register(deathmeal = new ItemBase("deathmeal", false).setCreativeTab(Tabs.materials));
		register(mob_loot = new MetaItemBase("minestrapp_mob_loot", false, 8).setCreativeTab(Tabs.materials));
		register(animal_feet = new MetaItemBase("animal_feet", false, 5).setCreativeTab(Tabs.materials));
		register(gene_samples = new MetaItemBase("gene_samples", false, 11).setCreativeTab(Tabs.materials));
		
		register(crafting_ingredients = new MetaItemBase("minestrapp_crafting_ingredients", false, 2).setCreativeTab(Tabs.materials));
		register(platings = new MetaItemBase("minestrapp_plating", false, 4).setCreativeTab(Tabs.materials));
		register(tech_component = new MetaItemBase("minestrapp_tech_component", false, 3).setCreativeTab(Tabs.materials));
		register(enderporter_chips = new MetaItemBase("enderporter_chip", false, 6).setCreativeTab(Tabs.materials));
		
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
