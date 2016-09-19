package minestrapp.guide;

import minestrapp.ItemsRegistry;
import minestrapp.Minestrappolation;
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
	
	public static GuideGroup basics = new GuideGroup("Starting Out");
	
	public static void preInit(){
		manager.imgGuide = new ResourceLocation(Minestrappolation.MODID+":textures/gui/guide.png");
		manager.imgGuideBG = new ResourceLocation(Minestrappolation.MODID+":textures/gui/guideBG.png");
		
		manager.registerEntryGroup(basics);
		basics.addEntry(new GuideEntry("minechiridion", "Minechiridion", new ItemStack(ItemsRegistry.minechiridion), 50, 50));
		manager.registerInfoPage("minechiridion", new GuideInfoPage("minechiridion", EnumPageType.INFO));
	}

}
