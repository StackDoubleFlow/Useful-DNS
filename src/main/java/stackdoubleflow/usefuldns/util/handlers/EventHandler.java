package stackdoubleflow.usefuldns.util.handlers;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.ItemInit;

public class EventHandler {
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(PlayerTickEvent event) {
		if(event.phase == TickEvent.Phase.START && !event.player.world.isRemote) {
			InventoryPlayer playerInventory = event.player.inventory;
			if(playerInventory.hasItemStack(new ItemStack(ItemInit.FLASHLIGHT))) {
				ItemStack stack;
				if(getSlotFor(new ItemStack(ItemInit.FLASHLIGHT), playerInventory) < 0) {
					stack = playerInventory.offHandInventory.get(0);
				} else {
					stack = playerInventory.getStackInSlot(getSlotFor(new ItemStack(ItemInit.FLASHLIGHT), playerInventory));
				}
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("lightState") && stack.getTagCompound().getBoolean("lightState")) {
					int blockX = MathHelper.floor(event.player.posX);
					int blockY = MathHelper.floor(event.player.posY - 0.2 - event.player.getYOffset());
					int blockZ = MathHelper.floor(event.player.posZ);
					
					BlockPos blockLocation = new BlockPos(blockX, blockY, blockZ).up();
					if(event.player.world.getBlockState(blockLocation).getBlock() == Blocks.AIR) {
						event.player.world.setBlockState(blockLocation, BlockInit.MOVING_LIGHT_SOURCE.getDefaultState());
					} else if(event.player.world.getBlockState(blockLocation.add(event.player.getLookVec().x, event.player.getLookVec().y, event.player.getLookVec().z)).getBlock() == Blocks.AIR) {
						event.player.world.setBlockState(blockLocation.add(event.player.getLookVec().x, event.player.getLookVec().y, event.player.getLookVec().z), BlockInit.MOVING_LIGHT_SOURCE.getDefaultState());
					}
				}
			}
		}
	}
	
    public static int getSlotFor(ItemStack stack, InventoryPlayer inventory) {
		NonNullList<ItemStack> mainInventory = inventory.mainInventory;
        for (int i = 0; i < mainInventory.size(); i++) {
            if (!((ItemStack)mainInventory.get(i)).isEmpty() && stackEqualExact(stack, mainInventory.get(i))) {
                return i;
            }
        }
        
        return -1;
    }
	
	private static boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
        return stack1.getItem() == stack2.getItem() && (!stack1.getHasSubtypes() || stack1.getMetadata() == stack2.getMetadata());
    }
	
}
