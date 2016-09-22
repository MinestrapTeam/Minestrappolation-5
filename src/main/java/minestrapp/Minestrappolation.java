package minestrapp;

import minestrapp.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Minestrappolation.MODID, name = Minestrappolation.NAME, version = Minestrappolation.VERSION, useMetadata = true)
public class Minestrappolation
{
	public static final String NAME = "Minestrappolation";
    public static final String MODID = "minestrapp";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "minestrapp.proxy.ClientProxy", serverSide = "minestrapp.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @Instance("minestrapp")
    public static Minestrappolation instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(new EventManager());
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.postInit(event);
    }
}
