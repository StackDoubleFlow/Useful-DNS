package stackdoubleflow.usefuldns.objects.items.tools;

import com.google.common.collect.Multimap;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.objects.items.ItemBase;
import stackdoubleflow.usefuldns.util.IHasModel;

public class Madstaff extends ItemSword implements IHasModel {

	public Madstaff() {
		super(ToolMultiTool.madMat);
		setUnlocalizedName("madstaff");
		setRegistryName("madstaff");
		setCreativeTab(ItemInit.usefulDNSCreateTab);
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(this, 0, "inventory");
	}
	

	public float getDamageVsEntity() {
        return 1234567890;
    }
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        return true;
    }
	
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 1234567890D, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", 0D, 0));
        }

        return multimap;
    }
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return false;
	}

}
