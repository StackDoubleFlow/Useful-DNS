package stackdoubleflow.usefuldns.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.FluidInit;

public class BlockLiquidRF extends BlockFluidClassic {
	
	

	public BlockLiquidRF() {
		super(FluidInit.LIQUID_RF, Material.WATER);
		setRegistryName("liquidrf");
		setUnlocalizedName(getRegistryName().toString());
		BlockInit.BLOCKS.add(this);
	}
	
}
