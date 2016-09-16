package minestrapp.guide;

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
		basics.addEntry(new GuideEntry("welcome", "Minestrappolation 5", new ItemStack(Items.BOOK), 50, 50));
		manager.registerInfoPage("welcome", new GuideInfoPage("welcome", EnumPageType.INFO));
	}

}
