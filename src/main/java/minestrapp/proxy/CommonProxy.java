package minestrapp.proxy;

import minestrapp.BlocksRegistry;
import minestrapp.GuiHandler;
import minestrapp.ItemsRegistry;
import minestrapp.Minestrappolation;
import minestrapp.guide.GuideHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event){
		ItemsRegistry.init();
		GuideHandler.preInit();
		BlocksRegistry.init();
	}
	
	public void init(FMLInitializationEvent event){
		//RecipesManager.init();
		//GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
	}

	public void postInit(FMLPostInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(Minestrappolation.instance, new GuiHandler());
	}
}