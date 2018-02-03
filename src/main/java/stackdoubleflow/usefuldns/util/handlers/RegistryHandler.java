package stackdoubleflow.usefuldns.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.objects.tileentities.TileEntityMovingLightSource;
import stackdoubleflow.usefuldns.util.IHasModel;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
		event.getRegistry().register(ItemInit.MOVINGLIGHTSOURCE);
		event.getRegistry().register(ItemInit.ORE_FOOLS_GOLD);
		event.getRegistry().register(ItemInit.ORE_FOOLS_IRON);
		OreDictionary.registerOre("ingotSteel", ItemInit.INGOT_STEEL);
		OreDictionary.registerOre("rodSteel", ItemInit.STEEL_ROD);
		OreDictionary.registerOre("dustSteel", ItemInit.RAW_STEEL);
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		GameRegistry.registerTileEntity(TileEntityMovingLightSource.class, "tileEntityMovingLightSource");
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for(Block block : BlockInit.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
}
