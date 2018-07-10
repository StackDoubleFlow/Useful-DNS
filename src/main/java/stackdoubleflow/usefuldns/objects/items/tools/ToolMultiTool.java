package stackdoubleflow.usefuldns.objects.items.tools;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.EnumHelper;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.ItemInit;
import stackdoubleflow.usefuldns.objects.items.ItemBase;
import stackdoubleflow.usefuldns.util.IHasModel;
import stackdoubleflow.usefuldns.util.Reference;

public class ToolMultiTool extends ItemTool implements IHasModel {
	
	public static final ToolMaterial dnsMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":dns", 100, 5000, 5000, 5.0f, 12);
	public static final ToolMaterial madMat = EnumHelper.addToolMaterial(Reference.MODID + ":mad", 100, 5000, 5000, 100.0f, 12);
	
	
	public ToolMultiTool() {
		super(dnsMaterial, Sets.newHashSet(Blocks.DIRT));
		setMaxStackSize(1);
		setUnlocalizedName("tool_multitool");
		setRegistryName("tool_multitool");
		setCreativeTab(ItemInit.usefulDNSCreateTab);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		UsefulDNS.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		return 50f;
	}
	
	
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "shovel", "axe");
	}
	
	public boolean canHarvestBlock(IBlockState blockIn) {
		return true;
	}
	
	@Override
	public int getMaxDamage() {
		return 5000;
	}
	
	

}
