package stackdoubleflow.usefuldns.objects.items.foods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.util.IHasModel;

public class Mudpie extends ItemFood implements IHasModel {

	public Mudpie() {
		super(20, 20, false);
		setUnlocalizedName("mudpie");
		setRegistryName("mudpie");
		setCreativeTab(ItemInit.usefulDNSCreateTab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		ItemHandlerHelper.giveItemToPlayer((EntityPlayer)entityLiving, new ItemStack(Items.BOWL));
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	
}
