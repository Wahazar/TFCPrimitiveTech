package tfcprimitivetech.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tfcprimitivetech.items.ItemWoodenTwig;
import tfcprimitivetech.items.PowderAsh;
import tfcprimitivetech.items.WoodenBucket_BasePotashLiquor;
import tfcprimitivetech.items.ItemCelluloseFibers;
import tfcprimitivetech.items.ItemWoodenPress;

public class ModItems 
{
	// Items
	public static Item itemWoodenTwig;
	public static Item powderAsh;
	public static Item woodenBucket_BasePotashLiquor;
	public static Item itemCelluloseFibers;
	public static Item itemWoodenPress;
	
	public static void initialise()
	{
		System.out.println("[" + ModDetails.ModName + "] Registering Items");
		
		itemWoodenTwig = new ItemWoodenTwig();
		powderAsh = new PowderAsh();
		woodenBucket_BasePotashLiquor = new WoodenBucket_BasePotashLiquor();
		itemCelluloseFibers = new ItemCelluloseFibers();
		itemWoodenPress = new ItemWoodenPress();
		
		registerItems();
		        
		System.out.println("[" + ModDetails.ModName + "] Done Registering Items");
	}
	
	private static void registerItems()
	{
	  GameRegistry.registerItem(itemWoodenTwig, "itemWoodenTwig");
	  GameRegistry.registerItem(powderAsh, "powderAsh");
	  GameRegistry.registerItem(woodenBucket_BasePotashLiquor, "woodenBucket_BasePotashLiquor");
	  GameRegistry.registerItem(itemCelluloseFibers, "itemCelluloseFibers");
	  GameRegistry.registerItem(itemWoodenPress, "itemWoodenPress");
	}
}
