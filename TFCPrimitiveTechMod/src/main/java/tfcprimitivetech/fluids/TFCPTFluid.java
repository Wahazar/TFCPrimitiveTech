package tfcprimitivetech.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tfcprimitivetech.core.ModDetails;
import tfcprimitivetech.core.ModItems;
import com.bioxx.tfc.Core.FluidBaseTFC;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TFCPTFluid extends FluidBaseTFC { 
 
    @SideOnly(Side.CLIENT) 
    protected IIcon stillIcon; 
    @SideOnly(Side.CLIENT) 
    protected IIcon flowingIcon; 
 
    public TFCPTFluid(String fluidName) { 
        super(fluidName); 
    } 
 
//    @Override 
//    public IIcon getIcon(int side, int meta) 
//    { 
//        return (side == 0 || side == 1) ? stillIcon : flowingIcon; 
//    } 
 
//    @Override 
    @SideOnly(Side.CLIENT) 
    public void registerBlockIcons(IIconRegister iconRegister, String fluidName) 
    { 
        this.stillIcon = iconRegister.registerIcon(ModDetails.ModID+":"+fluidName+"_still"); 
        this.flowingIcon = iconRegister.registerIcon(ModDetails.ModID+":"+fluidName+"_flow"); 
    } 
 
//    @Override 
//    public boolean canDisplace(IBlockAccess world, int x, int y, int z) { 
//        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false; 
//        return super.canDisplace(world, x, y, z); 
//    } 
 
//    @Override 
//    public boolean displaceIfPossible(World world, int x, int y, int z) { 
//        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false; 
//        return super.displaceIfPossible(world, x, y, z); 
 //   } 
}
