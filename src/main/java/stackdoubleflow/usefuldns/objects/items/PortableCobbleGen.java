package stackdoubleflow.usefuldns.objects.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class PortableCobbleGen extends ItemBase {

	public PortableCobbleGen() {
		super("portcobblegen");
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		ItemHandlerHelper.giveItemToPlayer((EntityPlayer)playerIn, new ItemStack(Blocks.COBBLESTONE, 64));
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	
}
