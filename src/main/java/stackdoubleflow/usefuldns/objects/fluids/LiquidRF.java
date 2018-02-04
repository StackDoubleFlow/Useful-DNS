package stackdoubleflow.usefuldns.objects.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class LiquidRF extends Fluid {

	public LiquidRF() {
		super("liquidrf", new ResourceLocation("usefuldns", "blocks/liquidrf_still"), new ResourceLocation("usefuldns", "blocks/liquidrf_flow"));
		
		setDensity(3);
		setViscosity(600);
		setLuminosity(5);
	}
	
	
	
}
