package stackdoubleflow.usefuldns.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class CompressedCoal extends Block implements IHasModel {
	
	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
		world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
	}
	
	public CompressedCoal() {
		super(Material.ROCK);
		BlockInit.BLOCKS.add(this);
		setUnlocalizedName("compressed_coal");
		setRegistryName("compressed_coal");
	}
	
	
}
