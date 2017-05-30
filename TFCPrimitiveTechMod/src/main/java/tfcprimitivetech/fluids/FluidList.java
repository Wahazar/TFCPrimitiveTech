package tfcprimitivetech.fluids;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import tfcprimitivetech.core.ModItems;
import tfcprimitivetech.fluids.TFCPTFluid;
import com.bioxx.tfc.Core.FluidBaseTFC;
import com.bioxx.tfc.api.TFCItems;

public class FluidList
{
    
    public static FluidBaseTFC BasePotashLiquor = new FluidBaseTFC("basePotashLiquor").setBaseColor(0xB6B9C0);
    public static TFCPTFluid Waste = (TFCPTFluid) new TFCPTFluid("waste").setBaseColor(0xB7C4C0);
   
   
    public static void register()
    {
        
        FluidRegistry.registerFluid(BasePotashLiquor);
        FluidRegistry.registerFluid(Waste);
        
    }
    
    public static void registerFluidContainers()
    {
                 
        FluidContainerRegistry.registerFluidContainer(new FluidStack(BasePotashLiquor, 1000), new ItemStack(ModItems.woodenBucket_BasePotashLiquor), new ItemStack(TFCItems.WoodenBucketEmpty));

    }
}
