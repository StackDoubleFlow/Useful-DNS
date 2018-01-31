package stackdoubleflow.usefuldns.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stackdoubleflow.usefuldns.UsefulDNS;

public class Flashlight extends ItemBase {

	public Flashlight() {
		super("flashlight");
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		NBTTagCompound nbt;
		if(stack.hasTagCompound()) {
			nbt = stack.getTagCompound();
		} else {
			nbt = new NBTTagCompound();
			UsefulDNS.logger.info("Flashlight has no NBT data");
		}
		if(nbt.hasKey("lightState")) {
			nbt.setBoolean("lightState", !nbt.getBoolean("lightState"));
		} else {
			nbt.setBoolean("lightState", true);
			UsefulDNS.logger.info("Flashlight set to default NBT");
		}
		stack.setTagCompound(nbt);
        return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Right click to toggle.");
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("lightState")) {
	        tooltip.add("Light state: " + Boolean.toString(stack.getTagCompound().getBoolean("lightState")));
	    } else {
	    	tooltip.add("Light state: false");
	    }
	}
	
}
