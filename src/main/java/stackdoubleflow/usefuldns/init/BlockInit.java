package stackdoubleflow.usefuldns.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import stackdoubleflow.usefuldns.objects.blocks.BlockMovingLightSource;
import stackdoubleflow.usefuldns.objects.blocks.ores.OreFoolsGold;
import stackdoubleflow.usefuldns.objects.blocks.ores.OreFoolsIron;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block MOVING_LIGHT_SOURCE = new BlockMovingLightSource();
	public static final Block ORE_FOOLS_GOLD = new OreFoolsGold();
	public static final Block ORE_FOOLS_IRON = new OreFoolsIron();
	
}
