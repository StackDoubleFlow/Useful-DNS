package stackdoubleflow.usefuldns.objects.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.util.handlers.EventHandler;

public class TileEntityMovingLightSource extends TileEntity implements ITickable {
	
	public EntityPlayer thePlayer;
	
	public void setPlayer(EntityPlayer parPlayer) {
		thePlayer = parPlayer;
	}


	@Override
	public void update() {
		EntityPlayer thePlayer = world.getClosestPlayer(getPos().getX() + 0.5, getPos().getY() + 0.5, getPos().getZ() + 0.5, 2.0, false);
		if(thePlayer == null) {
			if(world.getBlockState(getPos()).getBlock() == BlockInit.MOVING_LIGHT_SOURCE) {
				world.setBlockToAir(getPos());
			}
		} else if(!thePlayer.inventory.hasItemStack(new ItemStack(ItemInit.FLASHLIGHT))) {
			if(world.getBlockState(getPos()).getBlock() == BlockInit.MOVING_LIGHT_SOURCE) {
				world.setBlockToAir(getPos());
			}
		} else {
			ItemStack stack;
			if(EventHandler.getSlotFor(new ItemStack(ItemInit.FLASHLIGHT), thePlayer.inventory) < 0) {
				stack = thePlayer.inventory.offHandInventory.get(0);
			} else {
				stack = thePlayer.inventory.getStackInSlot(EventHandler.getSlotFor(new ItemStack(ItemInit.FLASHLIGHT), thePlayer.inventory));
			}
			if(!stack.getTagCompound().getBoolean("lightState")) {
				if(world.getBlockState(getPos()).getBlock() == BlockInit.MOVING_LIGHT_SOURCE) {
					world.setBlockToAir(getPos());
				}
			}
		}
	}
	
	
}
