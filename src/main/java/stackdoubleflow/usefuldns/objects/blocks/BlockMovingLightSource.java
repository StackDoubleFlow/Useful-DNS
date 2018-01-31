package stackdoubleflow.usefuldns.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.objects.tileentities.TileEntityMovingLightSource;
import stackdoubleflow.usefuldns.util.IHasModel;

public class BlockMovingLightSource extends Block implements ITileEntityProvider, IHasModel {

	public BlockMovingLightSource() {
		super(Material.AIR);
		setUnlocalizedName("movinglightsource");
		setRegistryName("movinglightsource");
		setLightLevel(1.0F);
		setTickRandomly(false);
		translucent = true;
		BlockInit.BLOCKS.add(this);
		
	}
	
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMovingLightSource();
	}
	
	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
        return false;
    }
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return null;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	@Deprecated
    public boolean isOpaqueCube(IBlockState state)
    {
        return true;
    }
	
	@Override
	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public boolean isCollidable() {
		return false;
	}
	
	@Override
	@Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}
