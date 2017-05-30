package tfcprimitivetech.core;

import net.minecraft.block.Block;

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

        	WoodenPressWet = new BlockWoodenPressWet().setBlockName("WoodenPressWet");
		
		registerBlocks();
		
		System.out.println("[" + ModDetails.ModName + "] Done Registering Blocks");
	}

	private static void registerBlocks()
	{
	        GameRegistry.registerBlock(WoodenPressWet, ItemBlockWoodenPressWet.class, WoodenPressWet.getUnlocalizedName().substring(5));
	}
}
