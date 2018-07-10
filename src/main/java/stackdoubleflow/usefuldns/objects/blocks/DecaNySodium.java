package stackdoubleflow.usefuldns.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class DecaNySodium extends Block implements IHasModel {
	
	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	public DecaNySodium() {
		super(Material.ROCK);
		BlockInit.BLOCKS.add(this);
		setUnlocalizedName("decanysodium");
		setRegistryName("decanysodium");
	}
	
}
