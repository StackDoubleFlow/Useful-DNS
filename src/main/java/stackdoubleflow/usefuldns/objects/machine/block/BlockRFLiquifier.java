package stackdoubleflow.usefuldns.objects.machine.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.MachineInit;
import stackdoubleflow.usefuldns.objects.machine.TileEntityRFLiquifier;
import stackdoubleflow.usefuldns.util.IHasModel;

public class BlockRFLiquifier extends Block implements ITileEntityProvider, IHasModel {

	public BlockRFLiquifier() {
		super(Material.IRON);
		MachineInit.MACHINES.add(this);
		setUnlocalizedName("blockrfliquifier");
		setRegistryName("blockrfliquifier");
		setHarvestLevel("pickaxe", 3);
	}
	
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRFLiquifier();
	}

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return false;
	}
	
	
}
