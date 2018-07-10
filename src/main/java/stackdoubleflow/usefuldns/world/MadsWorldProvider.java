package stackdoubleflow.usefuldns.world;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import scala.tools.nsc.MainClass;
import stackdoubleflow.usefuldns.UsefulDNS;

public class MadsWorldProvider extends WorldProvider {
	public void registerWorldChunkManager() {
		this.biomeProvider = new BiomeProviderSingle(Biomes.VOID);
		this.setDimension(UsefulDNS.madsDimId);
		this.setAllowedSpawnTypes(false, false);
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new MadsChunkGenerator(this.world);
	}
	
	public Biome getBiomeGenForCoords(BlockPos pos){
		return Biomes.SKY;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		return 0;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ModDimensions.MADS_DIMENSION;
	}
}
