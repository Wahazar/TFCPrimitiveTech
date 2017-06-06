package tfcprimitivetech.core;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Crafting.BarrelManager;
import com.bioxx.tfc.api.Crafting.BarrelMultiItemRecipe;
import com.bioxx.tfc.api.Crafting.BarrelRecipe;
import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
import com.bioxx.tfc.api.HeatRaw;

import java.util.List;

import com.bioxx.tfc.api.HeatIndex;
import com.bioxx.tfc.api.HeatRegistry;
import com.bioxx.tfc.api.TFCFluids;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import tfcprimitivetech.TFCPrimitiveTech;
import tfcprimitivetech.core.ModItems;
import tfcprimitivetech.fluids.FluidList;

public class ModRecipes
{	
	public static final int WILD = OreDictionary.WILDCARD_VALUE;
	
	//private static AnvilManager anvilManager = AnvilManager.getInstance();
	//private static BarrelManager barrelManager = BarrelManager.getInstance();
	//private static CraftingManagerTFC craftingManager = CraftingManagerTFC.getInstance();
	//private static KilnCraftingManager kilnCraftingManager = KilnCraftingManager.getInstance();
	//private static QuernManager quernManager = QuernManager.getInstance();

	// Plans

	public static void initialise()
	{
		System.out.println("[" + ModDetails.ModName + "] Registering Recipes");

		registerRecipes();

		RegisterItemHeat();
		
        registerBarrelRecipes();

		
		System.out.println("[" + ModDetails.ModName + "] Done Registering Recipes");
	}

	public static void initialiseAnvil()
	{
		// check if the plans/recipes have already been initialised.
		if (ModRecipes.areAnvilRecipesInitialised()) return;
		
		System.out.println("[" + ModDetails.ModName + "] Registering Anvil Recipes");
		
		registerAnvilPlans();
		registerAnvilRecipes();
		
		System.out.println("[" + ModDetails.ModName + "] Done Registering Anvil Recipes");
	}

	public static void RegisterItemHeat(){
        HeatRegistry heatRegistry = HeatRegistry.getInstance();		
		heatRegistry.addIndex( new HeatIndex( new ItemStack( ModItems.itemWoodenTwig, 1 ), 0.7f, 500f, new ItemStack( ModItems.powderAsh, 1 ) ) );
	}

    public static boolean areAnvilRecipesInitialised() 
    { 
        return true;
    } 

	private static void registerAnvilPlans()
	{
	}
	
	private static void registerAnvilRecipes()
	{		
	}
	
    private static void registerBarrelRecipes()
    {
        BarrelManager.getInstance().addRecipe(new BarrelRecipe(new ItemStack(ModItems.powderAsh, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 500), null, new FluidStack(FluidList.BasePotashLiquor, 500), 8).setMinTechLevel(0).setSealedRecipe(true).setRemovesLiquid(false).setAllowAnyStack(false));
        BarrelManager.getInstance().addRecipe(new BarrelRecipe(new ItemStack(TFCItems.reeds, 1, 0), new FluidStack(FluidList.BasePotashLiquor, 156), new ItemStack(ModItems.itemCelluloseFibers, 1, 0), new FluidStack(FluidList.Waste, 156), 24).setMinTechLevel(0).setSealedRecipe(true).setRemovesLiquid(false).setAllowAnyStack(false));
        
        BarrelManager.getInstance().addRecipe(new BarrelMultiItemRecipe(new ItemStack(TFCItems.hide, 1, 0), new FluidStack(FluidList.BasePotashLiquor, 300), new ItemStack(TFCItems.soakedHide, 1, 0), new FluidStack(FluidList.Waste, 300)).setMinTechLevel(0));
        BarrelManager.getInstance().addRecipe(new BarrelMultiItemRecipe(new ItemStack(TFCItems.hide, 1, 1), new FluidStack(FluidList.BasePotashLiquor, 600), new ItemStack(TFCItems.soakedHide, 1, 1), new FluidStack(FluidList.Waste, 600)).setMinTechLevel(0));
        BarrelManager.getInstance().addRecipe(new BarrelMultiItemRecipe(new ItemStack(TFCItems.hide, 1, 2), new FluidStack(FluidList.BasePotashLiquor, 900), new ItemStack(TFCItems.soakedHide, 1, 2), new FluidStack(FluidList.Waste, 900)).setMinTechLevel(0));
        
    }

    private static void RemoveRecipe(ItemStack resultItem)
    {
    	 List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
    	 for (int i = 0; i < recipes.size(); i++)
    	 {
    			 IRecipe tmpRecipe = recipes.get(i);
    			 ItemStack recipeResult = null;	 
    			 if (tmpRecipe instanceof ShapedRecipes) {
    					 ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
    					 recipeResult = recipe.getRecipeOutput();
    			 }
    			 else if (tmpRecipe instanceof ShapedOreRecipe)
    			 {
    				 ShapedOreRecipe recipe = (ShapedOreRecipe)tmpRecipe;
					 recipeResult = recipe.getRecipeOutput();    				 
    			 }   			
    			 if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
    							 recipes.remove(i--);
    				}
    		}
    }
    
	private static void registerRecipes()
	{
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemWoodenTwig, 3, 0), new Object[] { "logWood", "itemHammer" }));	
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TFCItems.stick, 1, 0), new Object[] {
				new ItemStack(ModItems.itemWoodenTwig, 1, 0), "itemKnife" }));
        if (TFCPrimitiveTech.instance.isPaperEnabled)
        	GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.WoodenPressWet, 1, 0), new Object[] { new ItemStack(ModItems.itemWoodenPress, 1, 0), new ItemStack(ModItems.itemCelluloseFibers, 1, 0), new ItemStack(ModItems.itemCelluloseFibers, 1, 0), new ItemStack(ModItems.itemWoodenPress, 1, 0) });	
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemWoodenPress, 1, 0), new Object[] { "logWood", "logWood", "logWood", "logWood"}));	
        if (TFCPrimitiveTech.instance.isSlingshotEnabled)
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemSlingshot, 1, 0), new Object[] { new ItemStack(ModItems.itemWoodenTwig, 1, 0), new ItemStack(ModItems.itemLeatherBelt, 1, 0) });	

		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(ModItems.itemLeatherBelt, 1), new Object[] { "#####", Character.valueOf('#'), TFCItems.flatLeather});		
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(ModItems.itemLeatherBelt, 3), new Object[] { "#####","     ","#####","     ","#####", Character.valueOf('#'), TFCItems.flatLeather});		

		for(int i = 0; i < Global.STONE_IGIN.length; i++)
		{		
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(ModItems.itemHardStone, 4), new Object[]
				{ "## ##", "## ##", "     ", "## ##", "## ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGIN_START) });
		}
		for(int i = 0; i < Global.STONE_IGEX.length; i++)
		{		
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(ModItems.itemHardStone, 4), new Object[]
				{ "## ##", "## ##", "     ", "## ##", "## ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
		}
		for(int i = 0; i < Global.STONE_MM.length; i++)
		{		
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(ModItems.itemSharpStone, 4), new Object[]
				{ "## ##", "## ##", "     ", "## ##", "## ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
		}
		for(int i = 0; i < Global.STONE_SED.length; i++)
		{		
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(ModItems.itemSoftStone, 4), new Object[]
				{ "## ##", "## ##", "     ", "## ##", "## ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
		}
		
        if (TFCPrimitiveTech.instance.isPaperEnabled)
        	RemoveRecipe(new ItemStack(Items.paper, 3));

	}
}
