package stackdoubleflow.usefuldns.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.FluidInit;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class BlockLiquidRF extends BlockFluidClassic {
	
	

	public BlockLiquidRF() {
		super(FluidInit.LIQUID_RF, Material.WATER);
		setRegistryName("liquidrf");
		setUnlocalizedName(getRegistryName().toString());
		BlockInit.BLOCKS.add(this);
	}
	
}
