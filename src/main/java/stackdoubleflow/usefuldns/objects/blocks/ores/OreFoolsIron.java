package stackdoubleflow.usefuldns.objects.blocks.ores;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class OreFoolsIron extends BlockOre implements IHasModel {

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	public OreFoolsIron() {
		BlockInit.BLOCKS.add(this);
		setUnlocalizedName("ore_fools_iron");
		setRegistryName("ore_fools_iron");
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemInit.RAW_IRON;
    }
	
	public int quantityDropped(Random random) {
		return 3;
	}
	
	
	
}
