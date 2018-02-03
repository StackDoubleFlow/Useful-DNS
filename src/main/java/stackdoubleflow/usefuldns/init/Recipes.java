package stackdoubleflow.usefuldns.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(ItemInit.RAW_STEEL, 1), new ItemStack(ItemInit.INGOT_STEEL, 1), 0.1f);
		
	}
	
}
