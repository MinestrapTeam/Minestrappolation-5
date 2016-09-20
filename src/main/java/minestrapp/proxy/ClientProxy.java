package minestrapp.proxy;

import minestrapp.BlocksRegistry;
import minestrapp.ItemsRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
		ItemsRegistry.registerRenders();
		BlocksRegistry.registerRenders();
	}

}
