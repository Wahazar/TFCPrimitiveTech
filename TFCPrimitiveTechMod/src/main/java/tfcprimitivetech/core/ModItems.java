package tfcprimitivetech.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tfcprimitivetech.items.ItemWoodenTwig;
import tfcprimitivetech.items.PowderAsh;
import tfcprimitivetech.items.WoodenBucket_BasePotashLiquor;
import tfcprimitivetech.TFCPrimitiveTech;
import tfcprimitivetech.items.ItemCelluloseFibers;
import tfcprimitivetech.items.ItemWoodenPress;
import tfcprimitivetech.items.ItemLeatherBelt;
import tfcprimitivetech.items.ItemSharpStone;
import tfcprimitivetech.items.ItemHardStone;
import tfcprimitivetech.items.ItemSoftStone;
import tfcprimitivetech.items.ItemSlingshot;

public class ModItems 
{
	// Items
	public static Item itemWoodenTwig;
	public static Item powderAsh;
	public static Item woodenBucket_BasePotashLiquor;
	public static Item itemCelluloseFibers;
	public static Item itemWoodenPress;
	public static Item itemLeatherBelt;
	public static Item itemSharpStone;
	public static Item itemHardStone;
	public static Item itemSoftStone;	
	public static Item itemSlingshot;	
	
	public static void initialise()
	{
		System.out.println("[" + ModDetails.ModName + "] Registering Items");
		
		itemWoodenTwig = new ItemWoodenTwig();
		powderAsh = new PowderAsh();
		woodenBucket_BasePotashLiquor = new WoodenBucket_BasePotashLiquor();
		itemCelluloseFibers = new ItemCelluloseFibers();
		itemWoodenPress = new ItemWoodenPress();
		itemLeatherBelt = new ItemLeatherBelt();
        if (TFCPrimitiveTech.instance.isSlingshotEnabled)
        {
        	itemSharpStone = new ItemSharpStone();
        	itemHardStone = new ItemHardStone();
        	itemSoftStone = new ItemSoftStone();
        	itemSlingshot = new ItemSlingshot();
        }
		
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
	  GameRegistry.registerItem(itemLeatherBelt, "itemLeatherBelt");
      if (TFCPrimitiveTech.instance.isSlingshotEnabled)
      {
    	  GameRegistry.registerItem(itemSharpStone, "itemSharpStone");
    	  GameRegistry.registerItem(itemHardStone, "itemHardStone");
    	  GameRegistry.registerItem(itemSoftStone, "itemSoftStone");
    	  GameRegistry.registerItem(itemSlingshot, "itemSlingshot");
      }
	}
}
