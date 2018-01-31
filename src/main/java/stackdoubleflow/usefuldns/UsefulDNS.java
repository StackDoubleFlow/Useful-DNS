package stackdoubleflow.usefuldns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import stackdoubleflow.usefuldns.init.Recipes;
import stackdoubleflow.usefuldns.proxy.CommonProxy;
import stackdoubleflow.usefuldns.util.Reference;

@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
public class UsefulDNS {
	@Instance
	public static UsefulDNS instance;
	
	public static Logger logger;
	
	@SidedProxy(clientSide=Reference.CLIENT, serverSide=Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("UsefulDNS");
		logger.info("UsefulDNS logger initialized");
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		Recipes.init();
		MinecraftForge.EVENT_BUS.register(new stackdoubleflow.usefuldns.util.handlers.EventHandler());
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}
