package stackdoubleflow.usefuldns.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class MadsFire extends BlockFire implements IHasModel {
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP) && !BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.down(), EnumFacing.UP))
        {
            return state.withProperty(NORTH, this.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH))
                        .withProperty(EAST,  this.canCatchFire(worldIn, pos.east(), EnumFacing.WEST))
                        .withProperty(SOUTH, this.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH))
                        .withProperty(WEST,  this.canCatchFire(worldIn, pos.west(), EnumFacing.EAST))
                        .withProperty(UPPER, this.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN));
        }
        return this.getDefaultState();
    }

    public MadsFire()
    {
        super();
		BlockInit.BLOCKS.add(this);
        setUnlocalizedName("mads_fire");
        setRegistryName("mads_fire");
    }

    public static void init()
    {
        BlockInit.MADS_FIRE.setFireInfo(Blocks.PLANKS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.DOUBLE_WOODEN_SLAB, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.WOODEN_SLAB, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.OAK_FENCE_GATE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.SPRUCE_FENCE_GATE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.BIRCH_FENCE_GATE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.JUNGLE_FENCE_GATE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.ACACIA_FENCE_GATE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.OAK_FENCE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.SPRUCE_FENCE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.BIRCH_FENCE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.JUNGLE_FENCE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.DARK_OAK_FENCE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.ACACIA_FENCE, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.OAK_STAIRS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.BIRCH_STAIRS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.SPRUCE_STAIRS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.JUNGLE_STAIRS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.ACACIA_STAIRS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.DARK_OAK_STAIRS, 5, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.LOG, 5, 5);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.LOG2, 5, 5);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.LEAVES, 30, 60);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.LEAVES2, 30, 60);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.BOOKSHELF, 30, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.TNT, 15, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.TALLGRASS, 60, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.DOUBLE_PLANT, 60, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.YELLOW_FLOWER, 60, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.RED_FLOWER, 60, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.DEADBUSH, 60, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.WOOL, 30, 60);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.VINE, 15, 100);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.COAL_BLOCK, 5, 5);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.HAY_BLOCK, 60, 20);
        BlockInit.MADS_FIRE.setFireInfo(Blocks.CARPET, 60, 20);
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (rand.nextInt(24) == 0)
        {
            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
        }

        if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP) && !BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.down(), EnumFacing.UP))
        {
            if (BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.west(), EnumFacing.EAST))
            {
                for (int j = 0; j < 2; ++j)
                {
                    double d3 = (double)pos.getX() + rand.nextDouble() * 0.10000000149011612D;
                    double d8 = (double)pos.getY() + rand.nextDouble();
                    double d13 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
                }
            }

            if (BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.east(), EnumFacing.WEST))
            {
                for (int k = 0; k < 2; ++k)
                {
                    double d4 = (double)(pos.getX() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    double d9 = (double)pos.getY() + rand.nextDouble();
                    double d14 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
                }
            }

            if (BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH))
            {
                for (int l = 0; l < 2; ++l)
                {
                    double d5 = (double)pos.getX() + rand.nextDouble();
                    double d10 = (double)pos.getY() + rand.nextDouble();
                    double d15 = (double)pos.getZ() + rand.nextDouble() * 0.10000000149011612D;
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d5, d10, d15, 0.0D, 0.0D, 0.0D);
                }
            }

            if (BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH))
            {
                for (int i1 = 0; i1 < 2; ++i1)
                {
                    double d6 = (double)pos.getX() + rand.nextDouble();
                    double d11 = (double)pos.getY() + rand.nextDouble();
                    double d16 = (double)(pos.getZ() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
                }
            }

            if (BlockInit.MADS_FIRE.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN))
            {
                for (int j1 = 0; j1 < 2; ++j1)
                {
                    double d7 = (double)pos.getX() + rand.nextDouble();
                    double d12 = (double)(pos.getY() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    double d17 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d7, d12, d17, 0.0D, 0.0D, 0.0D);
                }
            }
        }
        else
        {
            for (int i = 0; i < 3; ++i)
            {
                double d0 = (double)pos.getX() + rand.nextDouble();
                double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
                double d2 = (double)pos.getZ() + rand.nextDouble();
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (worldIn.provider.getDimensionType().getId() > 0 || !BlockInit.MADS_PORTAL.trySpawnPortal(worldIn, pos))
        {
            if (!worldIn.getBlockState(pos.down()).isTopSolid() && !this.canNeighborCatchFire(worldIn, pos))
            {
                worldIn.setBlockToAir(pos);
            }
            else
            {
                worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
            }
        }
    }
    
    private boolean canNeighborCatchFire(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : EnumFacing.values())
        {
            if (this.canCatchFire(worldIn, pos.offset(enumfacing), enumfacing.getOpposite()))
            {
                return true;
            }
        }

        return false;
    }

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
