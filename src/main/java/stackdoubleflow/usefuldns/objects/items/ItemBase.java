package stackdoubleflow.usefuldns.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class ItemBase extends Item implements IHasModel {

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ItemInit.usefulDNSCreateTab);
		
		ItemInit.ITEMS.add(this);
		
	}
	
	public ItemBase(ToolMaterial material, String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ItemInit.usefulDNSCreateTab);
		
		ItemInit.ITEMS.add(this);
	}
	
}
