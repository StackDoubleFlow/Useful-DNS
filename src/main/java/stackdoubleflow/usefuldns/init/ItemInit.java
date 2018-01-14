package stackdoubleflow.usefuldns.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stackdoubleflow.usefuldns.objects.items.ItemBase;
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
	public static final Item STEEL_ROD = new ItemBase("rod_steel");
	public static final Item MUDPIE = new ItemBase("mudpie");
	public static final Item INGOT_STEEL = new ItemBase("ingot_steel");
	public static final Item TOOL_MULTITOOL = new ToolMultiTool();
	
	public static final Item DOLLAR1 = new ItemBase("dollar1");
	public static final Item DOLLAR10 = new ItemBase("dollar10");
	public static final Item DOLLAR100 = new ItemBase("dollar100");
	public static final Item DOLLAR500 = new ItemBase("dollar500");
	public static final Item DOLLAR5 = new ItemBase("dollar5");
	public static final Item DOLLAR5000 = new ItemBase("dollar5000");
	public static final Item DOLLAR20 = new ItemBase("dollar20");
	public static final Item DOLLAR1000 = new ItemBase("dollar1000");
}