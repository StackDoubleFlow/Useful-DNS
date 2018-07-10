package stackdoubleflow.usefuldns.world;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import stackdoubleflow.usefuldns.UsefulDNS;

public class ModDimensions {
	
	public static DimensionType madsDimensionType;
	public static final DimensionType MADS_DIMENSION = DimensionType.register("madsworld", "_madsworld", UsefulDNS.madsDimId, MadsWorldProvider.class, false);
	
	
	public static void init() {
		registerDimensions();
	}
	
	private static void registerDimensions() {
		DimensionManager.registerDimension(UsefulDNS.madsDimId, MADS_DIMENSION);
	}
	
}
