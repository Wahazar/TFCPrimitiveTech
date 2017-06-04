package tfcprimitivetech.handlers;

import com.bioxx.tfc.Core.TFC_Time;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import tfcprimitivetech.tileentities.TileEntityWoodenPressWet;
import tfcprimitivetech.blocks.BlockWoodenPressWet;
import tfcprimitivetech.core.ModBlocks;

import java.util.List;

public class WailaHandler implements IWailaDataProvider {
	
	public static void callbackRegister(IWailaRegistrar register) {
		WailaHandler instance = new WailaHandler();
		
		register.registerBodyProvider(instance, BlockWoodenPressWet.class);
		register.registerNBTProvider(instance, BlockWoodenPressWet.class);
	}
	
	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		
		Block block = accessor.getBlock();
		
		if(block == ModBlocks.WoodenPressWet) {
			
//			NBTTagCompound tagCompound = accessor.getNBTData();
			
//			int md = tagCompound.getInteger("metadata");
			
			String tip = (accessor.getMetadata() == 0 ? (EnumChatFormatting.RED + "Wait until dry")
					: (EnumChatFormatting.GREEN + "Break to obtain paper"));
		
			currenttip.add(tip);
			
		} 	        
		
		return currenttip;
	}

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		
		return currenttip;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		
		return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x,
			int y, int z) {
		
		if(te != null) {
			te.writeToNBT(tag);
		}
            
        return tag;
	}

}
