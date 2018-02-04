package stackdoubleflow.usefuldns.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import stackdoubleflow.usefuldns.objects.items.Flashlight;
import stackdoubleflow.usefuldns.objects.items.ItemBase;
import stackdoubleflow.usefuldns.objects.items.PortableCobbleGen;
import stackdoubleflow.usefuldns.objects.items.foods.Mudpie;
import stackdoubleflow.usefuldns.objects.items.tools.ToolMultiTool;

public class ItemInit {
	
	public static final CreativeTabs usefulDNSCreateTab = new CreativeTabs("usefulDNS") {
		
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemInit.MUDPIE);
		}
	};
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item RAW_STEEL = new ItemBase("raw_steel");
	public static final Item RAW_IRON = new ItemBase("raw_iron");
	public static final Item STEEL_ROD = new ItemBase("rod_steel");
	public static final Item MUDPIE = new Mudpie();
	public static final Item INGOT_STEEL = new ItemBase("ingot_steel");
	public static final Item TOOL_MULTITOOL = new ToolMultiTool();
	public static final Item FLASHLIGHT = new Flashlight();
	
	public static final Item DOLLAR1 = new ItemBase("dollar1");
	public static final Item DOLLAR10 = new ItemBase("dollar10");
	public static final Item DOLLAR100 = new ItemBase("dollar100");
	public static final Item DOLLAR500 = new ItemBase("dollar500");
	public static final Item DOLLAR5 = new ItemBase("dollar5");
	public static final Item DOLLAR5000 = new ItemBase("dollar5000");
	public static final Item DOLLAR20 = new ItemBase("dollar20");
	public static final Item DOLLAR1000 = new ItemBase("dollar1000");
	
	public static final Item MONEYBAG1 = new ItemBase("moneybag1");
	public static final Item MONEYBAG2 = new ItemBase("moneybag2");
	public static final Item MONEYBAG3 = new ItemBase("moneybag3");
	public static final Item MONEYBAG4 = new ItemBase("moneybag4");
	public static final Item MONEYBAG5 = new ItemBase("moneybag5");
	
	public static final Item PORTCOBBLEGEN = new PortableCobbleGen();
	
	public static final Item MOVINGLIGHTSOURCE = new ItemBlock(BlockInit.MOVING_LIGHT_SOURCE).setRegistryName(BlockInit.MOVING_LIGHT_SOURCE.getRegistryName());
	public static final Item ORE_FOOLS_GOLD = new ItemBlock(BlockInit.ORE_FOOLS_GOLD).setRegistryName("ore_fools_gold");
	public static final Item ORE_FOOLS_IRON = new ItemBlock(BlockInit.ORE_FOOLS_IRON).setRegistryName("ore_fools_iron");
	public static final Item LIQUID_RF = new ItemBlock(BlockInit.BLOCK_LIQUID_RF).setRegistryName("liquidrf");
}
