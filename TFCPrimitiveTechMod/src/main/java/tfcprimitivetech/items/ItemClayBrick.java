package tfcprimitivetech.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import tfcprimitivetech.core.ModDetails;
import tfcprimitivetech.core.ModItems;

import com.bioxx.tfc.Items.Pottery.ItemPotteryBase;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemClayBrick extends ItemPotteryBase
{

	public ItemClayBrick()
	{
		super();
		this.metaNames = new String[]{"Clay Brick", "Ceramic Brick"};
		this.maxStackSize = 64;
		this.stackable = true;
		this.setWeight(EnumWeight.MEDIUM);
		this.setSize(EnumSize.SMALL);
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		this.clayIcon = registerer.registerIcon(ModDetails.ModID+":"+ "ItemClayBrick");
		this.ceramicIcon = registerer.registerIcon("minecraft:brick");
	}

}
