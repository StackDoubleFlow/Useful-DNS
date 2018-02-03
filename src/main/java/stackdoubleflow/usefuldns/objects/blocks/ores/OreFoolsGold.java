package stackdoubleflow.usefuldns.objects.blocks.ores;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class OreFoolsGold extends BlockOre implements IHasModel {

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	public OreFoolsGold() {
		BlockInit.BLOCKS.add(this);
		setUnlocalizedName("ore_fools_gold");
		setRegistryName("ore_fools_gold");
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.GOLD_NUGGET;
    }
	
	
	
}
