package stackdoubleflow.usefuldns.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.init.MachineInit;
import stackdoubleflow.usefuldns.model.MeshDefinitionFix;
import stackdoubleflow.usefuldns.objects.machine.TileEntityRFLiquifier;
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
		event.getRegistry().register(ItemInit.LIQUID_RF);
		event.getRegistry().register(ItemInit.BLOCKRFLIQUIFIER);
		event.getRegistry().register(ItemInit.COMPRESSED_COAL);
		event.getRegistry().register(ItemInit.DECANYSODIUM);
		event.getRegistry().register(ItemInit.MADS_PORTAL);
		OreDictionary.registerOre("ingotSteel", ItemInit.INGOT_STEEL);
		OreDictionary.registerOre("rodSteel", ItemInit.STEEL_ROD);
		OreDictionary.registerOre("dustSteel", ItemInit.RAW_STEEL);
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		event.getRegistry().registerAll(MachineInit.MACHINES.toArray(new Block[0]));
		GameRegistry.registerTileEntity(TileEntityMovingLightSource.class, "tileEntityMovingLightSource");
		GameRegistry.registerTileEntity(TileEntityRFLiquifier.class, "tileEntityRFLiquifier");
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
			} else if(block instanceof IFluidBlock) {
				registerFluidModel((IFluidBlock) block);
			}
		}
		((IHasModel)MachineInit.RFLIQUIFIER).registerModels();
		
	}
	
	@SideOnly(Side.CLIENT)
	private static void registerFluidModel(IFluidBlock fluidBlock) {
		final Item item = Item.getItemFromBlock((Block) fluidBlock);
		assert item != null;
		UsefulDNS.logger.info("Registering fluid: " + fluidBlock.getFluid().getName());
		
		ModelBakery.registerItemVariants(item);
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("usefuldns:liquidrf");
		ModelLoader.setCustomMeshDefinition(item, MeshDefinitionFix.create(stack -> modelResourceLocation));
		ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {

			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return modelResourceLocation;
			}
			
		});
	}
}
