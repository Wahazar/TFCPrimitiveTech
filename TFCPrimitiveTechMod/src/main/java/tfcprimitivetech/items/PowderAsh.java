package tfcprimitivetech.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tfcprimitivetech.core.ModDetails;
import net.minecraft.entity.player.EntityPlayer;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISize;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PowderAsh extends ItemTerra {

	public PowderAsh() {
		super();
		this.maxStackSize = 64;
		this.setCreativeTab(TFCTabs.TFC_MATERIALS);
		this.hasSubtypes = false;
		this.setUnlocalizedName("PowderAsh");		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister registerer)
	{
		this.itemIcon = registerer.registerIcon(ModDetails.ModID+":"+"PowderAsh");
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag)
	{
		ItemTerra.addSizeInformation(is, arraylist);
	}

	@Override
	public EnumSize getSize(ItemStack is)
	{
		return EnumSize.SMALL;
	}

	@Override
	public EnumWeight getWeight(ItemStack is)
	{
		return EnumWeight.LIGHT;
	}

	@Override
	public boolean canStack()
	{
		return true;
	}

	@Override
	public EnumItemReach getReach(ItemStack is)
	{
		return EnumItemReach.SHORT;
	}
}
