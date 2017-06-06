package tfcprimitivetech.core;

import net.minecraft.block.Block;
import tfcprimitivetech.TFCPrimitiveTech;
import tfcprimitivetech.blocks.BlockWoodenPressWet;
import tfcprimitivetech.items.ItemBlockWoodenPressWet;
import com.bioxx.tfc.api.Constant.Global;

import cpw.mods.fml.common.registry.GameRegistry;


public class ModBlocks 
{
	// Blocks Render Id's
    public static int WoodenPressRenderId;	
	// Blocks
    
    public static Block WoodenPressWet;
	
	public static void initialise()
	{
		System.out.println("[" + ModDetails.ModName + "] Registering Blocks");

        	if (TFCPrimitiveTech.instance.isPaperEnabled)
        		WoodenPressWet = new BlockWoodenPressWet().setBlockName("WoodenPressWet");
		
		registerBlocks();
		
		System.out.println("[" + ModDetails.ModName + "] Done Registering Blocks");
	}

	private static void registerBlocks()
	{
    	if (TFCPrimitiveTech.instance.isPaperEnabled)
    		GameRegistry.registerBlock(WoodenPressWet, ItemBlockWoodenPressWet.class, WoodenPressWet.getUnlocalizedName().substring(5));
	}
}
