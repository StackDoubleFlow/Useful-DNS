package stackdoubleflow.usefuldns.objects.machine;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import stackdoubleflow.usefuldns.UsefulDNS;
import stackdoubleflow.usefuldns.init.FluidInit;
import stackdoubleflow.usefuldns.objects.fluids.LiquidRF;

public class TileEntityRFLiquifier extends TileEntity implements IEnergyStorage, ITickable, IFluidHandler {
	
	private int energyStored;
	private int fluidStored;
	
	//true = rf to liquid
	//false = liquid to rf
	private boolean state;
	
	private static final int MAX_ENERGY = 15000000;
	private static final int MAX_FLUID = 1000;
	private static final int RF_TO_LIQUID = 15000;
	
	public void toggleState() {
		UsefulDNS.logger.info("State toggled");
		state = !state;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) {
			return true;
		}
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		compound = super.writeToNBT(compound);
		compound.setInteger("energyStored", energyStored);
		compound.setInteger("fluidStored", fluidStored);
		compound.setBoolean("theState", state);
		return compound;
	}
	
	@Override
    @Nullable
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.EnumFacing facing) {
        if(capability.equals(CapabilityEnergy.ENERGY)) {
        	return (T) this;
        }
        if(capability.equals(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)) {
        	return (T) this;
        }
        return super.getCapability(capability, facing);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if(compound.hasKey("energyStored")) {
            energyStored = compound.getInteger("energyStored");
            fluidStored = compound.getInteger("fluidStored");
            state = compound.getBoolean("theState");
        } else {
        	energyStored = 0;
        	fluidStored = 0;
        	state = false;
        }
	}
	
	@Override
	public int receiveEnergy(int maxReceive, boolean simulate) {
		int added = 0;
		if(energyStored + maxReceive > MAX_ENERGY) {
			added = MAX_ENERGY - maxReceive;
		} else {
			added = maxReceive;
		}
		if(!simulate) {
			energyStored += added;
		}
		
		return added;
	}

	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		int extracted = 0;
		if(energyStored >= maxExtract) {
			extracted = maxExtract;
		} else {
			extracted = energyStored;
		}
		
		if(!simulate) {
			energyStored -= extracted;
		}
		return extracted;
	}

	@Override
	public int getEnergyStored() {
		return energyStored;
	}

	@Override
	public int getMaxEnergyStored() {
		return 15000000;
	}

	@Override
	public boolean canExtract() {
		return !state;
	}

	@Override
	public boolean canReceive() {
		return state;
	}

	@Override
	public IFluidTankProperties[] getTankProperties() {
		return new IFluidTankProperties[]{new FluidTankProperties(new FluidStack(FluidInit.LIQUID_RF, fluidStored), MAX_FLUID)};
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		int added = 0;
		int maxReceive = resource.amount;
		if(fluidStored + maxReceive > MAX_ENERGY) {
			added = MAX_ENERGY - maxReceive;
		} else {
			added = maxReceive;
		}
		if(doFill) {
			fluidStored += added;
		}
		if(state) return 0; else return added;
	}

	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		int maxDrain = resource.amount;
		int extracted = 0;
		if(!(resource.getFluid() instanceof LiquidRF)) {
			return new FluidStack(FluidInit.LIQUID_RF, 0);
		}
		if(fluidStored >= maxDrain) {
			extracted = maxDrain;
		} else {
			extracted = fluidStored;
		}
		
		if(doDrain) {
			fluidStored -= extracted;
		}
		if(state) return new FluidStack(FluidInit.LIQUID_RF, extracted); else return new FluidStack(FluidInit.LIQUID_RF, 0);
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		int extracted = 0;
		if(fluidStored >= maxDrain) {
			extracted = maxDrain;
		} else {
			extracted = fluidStored;
		}
		
		if(doDrain) {
			fluidStored -= extracted;
		}
		if(state) return new FluidStack(FluidInit.LIQUID_RF, extracted); else return new FluidStack(FluidInit.LIQUID_RF, 0);
	}

	@Override
	public void update() {
		if(state) {
			if(energyStored < RF_TO_LIQUID || fluidStored >= MAX_FLUID) return;
			UsefulDNS.logger.info(energyStored + ":" + fluidStored);
			energyStored -= RF_TO_LIQUID;
			fluidStored++;
			if(!getWorld().isRemote) {
				for(EnumFacing side : EnumFacing.values()) {
					TileEntity fluidTo = world.getTileEntity(pos.offset(side));
					if(fluidTo != null && fluidTo.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side.getOpposite())) {
						int amountDrain = fluidTo.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side.getOpposite()).fill(new FluidStack(FluidInit.LIQUID_RF, fluidStored), true);
						fluidStored -= amountDrain;
					}
				}
			}
		} else {
			if(fluidStored < 1 || (energyStored + RF_TO_LIQUID) > MAX_ENERGY) return;
			energyStored += RF_TO_LIQUID;
			fluidStored--;
			if(!getWorld().isRemote) {
				for(EnumFacing side : EnumFacing.VALUES) {
					TileEntity energyTo = world.getTileEntity(pos.offset(side));
					if(energyTo != null && energyTo.hasCapability(CapabilityEnergy.ENERGY, side.getOpposite())) {
						int amountDrain = energyTo.getCapability(CapabilityEnergy.ENERGY, side.getOpposite()).receiveEnergy(energyStored, false);
						energyStored -= amountDrain;
					}
				}
			}
		}
		
		
	}

}
