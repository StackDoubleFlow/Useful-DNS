package stackdoubleflow.usefuldns.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import stackdoubleflow.usefuldns.objects.blocks.BlockLiquidRF;
import stackdoubleflow.usefuldns.objects.blocks.BlockMovingLightSource;
import stackdoubleflow.usefuldns.objects.blocks.CompressedCoal;
import stackdoubleflow.usefuldns.objects.blocks.DecaNySodium;
import stackdoubleflow.usefuldns.objects.blocks.MadsPortal;
import stackdoubleflow.usefuldns.objects.blocks.ores.OreFoolsGold;
import stackdoubleflow.usefuldns.objects.blocks.ores.OreFoolsIron;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block MOVING_LIGHT_SOURCE = new BlockMovingLightSource();
	public static final Block ORE_FOOLS_GOLD = new OreFoolsGold();
	public static final Block ORE_FOOLS_IRON = new OreFoolsIron();
	public static final Block BLOCK_LIQUID_RF = new BlockLiquidRF();
	public static final Block COMPRESSED_COAL = new CompressedCoal();
	public static final Block DECANYSODIUM = new DecaNySodium();
	public static final Block MADS_PORTAL = new MadsPortal();
	
}
