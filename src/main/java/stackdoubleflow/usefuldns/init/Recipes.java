package stackdoubleflow.usefuldns.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(ItemInit.RAW_STEEL, 1), new ItemStack(ItemInit.INGOT_STEEL, 1), 0.1f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.RAW_IRON, 1), new ItemStack(Items.IRON_INGOT, 1), 0.1f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.GROUND_FLESH, 1), new ItemStack(ItemInit.PEOPLEBURG, 1), 0.1f);
	}
	
}
