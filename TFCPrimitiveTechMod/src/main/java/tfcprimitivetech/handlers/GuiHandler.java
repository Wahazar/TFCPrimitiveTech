package tfcprimitivetech.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
//import tfcprimitivetech.containers.ContainerBurlapSack;
// import tfcprimitivetech.containers.ContainerBurlapSack;
// import tfcprimitivetech.gui.GuiBurlapSack;
// import tfcprimitivetech.items.InventoryItem;


//import com.bioxx.tfc.Containers.ContainerVessel;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
//	public static final int GuiIdCustom = ModDetails.GuiOffset + 1;
	
	@Override
	public Object getServerGuiElement(int Id, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity;
		
		try
		{
			tileEntity = world.getTileEntity(x, y, z);
		}
		catch(Exception e)
		{
			return null;
		}
		
		switch (Id)
		{
//			case 2:
//				return new ContainerBurlapSack(player.inventory, world, x, y, z);
//				return new ContainerVessel(player.inventory, world, x, y, z);
//				return new ContainerItem(player, player.inventory, new InventoryItem(player.getHeldItem()));
//				return new ContainerBurlapSack(player.inventory, new InventoryItem(player.getHeldItem()));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int Id, EntityPlayer player, World world, int x, int y, int z)
	{
        TileEntity tileEntity = world.getTileEntity(x, y, z);
		switch (Id)
		{
			case 2:
//				return new GuiBurlapSack(player.inventory, new InventoryItem(player.getHeldItem()));
			default:
				return null;
		}

	}
}
