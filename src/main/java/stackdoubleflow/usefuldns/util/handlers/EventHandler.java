package stackdoubleflow.usefuldns.util.handlers;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.BlockInit;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.objects.machine.TileEntityRFLiquifier;

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
	@SubscribeEvent
	public static void onPlayerJoin(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		UUID uuid = player.getUniqueID();
		if(uuid.equals(UUID.fromString("8767cc9f-2505-4145-a04b-7529fbcee5e5"))) {
			NBTTagCompound nbt = player.getEntityData();
			boolean loggedInBefore = nbt.getBoolean("loggedInBefore");
			if(!loggedInBefore) {
				ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ItemInit.MADSTAFF, 1));
				nbt.setBoolean("loggedInBefore", true);
			}
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public static void onPlayerInteract(PlayerInteractEvent event) {
		UsefulDNS.logger.info("what what wat?");
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		TileEntity tileEntity = world.getTileEntity(pos);
		if(tileEntity instanceof TileEntityRFLiquifier) {
			((TileEntityRFLiquifier) tileEntity).toggleState();
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
