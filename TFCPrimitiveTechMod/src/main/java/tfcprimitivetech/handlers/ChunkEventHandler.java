package tfcprimitivetech.handlers;

import tfcprimitivetech.core.ModRecipes;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChunkEventHandler 
{
    @SubscribeEvent 
    public void onLoadWorld(WorldEvent.Load e) 
    { 
        if (!e.world.isRemote && e.world.provider.dimensionId == 0) 
        { 
            ModRecipes.initialiseAnvil(); 
        } 
    } 
    
	@SubscribeEvent
	public void onUnloadWorld(WorldEvent.Unload e)
	{
		
	}
}
