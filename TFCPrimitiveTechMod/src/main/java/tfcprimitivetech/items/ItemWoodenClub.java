package tfcprimitivetech.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import tfcprimitivetech.TFCPrimitiveTech;
import tfcprimitivetech.core.ModDetails;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.TFC_Textures;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumDamageType;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ICausesDamage;
import com.bioxx.tfc.api.Interfaces.ISize;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;


public class ItemWoodenClub extends ItemSword implements ISize, ICausesDamage
 {
	private final ToolMaterial toolMat;
	private float weaponBaseDamage;
	public EnumDamageType damageType = EnumDamageType.CRUSHING;
	public ItemWoodenClub() {
		super(TFCPrimitiveTech.instance.woodenClubMaterial);
		this.maxStackSize = 1;
		this.setCreativeTab(TFCTabs.TFC_WEAPONS);
		this.hasSubtypes = false;
		this.setUnlocalizedName("ItemWoodenClub");
		this.toolMat = TFCPrimitiveTech.instance.woodenClubMaterial;
		this.setMaxDamage(toolMat.getMaxUses());

		this.weaponBaseDamage = 90;
		
	}

	@Override
	public float func_150931_i()
	{
		return this.toolMat.getDamageVsEntity();
	}

	@Override
	public EnumDamageType getDamageType() 
	{
		return damageType;
	}


	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister registerer)
	{
		this.itemIcon = registerer.registerIcon(ModDetails.ModID+":"+"ItemWoodenClub");
	}

	
	@Override
	public EnumSize getSize(ItemStack is)
	{
		return EnumSize.MEDIUM;
	}

	@Override
	public EnumWeight getWeight(ItemStack is)
	{
		return EnumWeight.HEAVY;
	}

	@Override
	public boolean canStack()
	{
		return false;
	}

	@Override
	public EnumItemReach getReach(ItemStack is)
	{
		return EnumItemReach.SHORT;
	}

	@Override
	public IIcon getIcon(ItemStack stack, int pass)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		if(pass == 1 && nbt != null && nbt.hasKey("broken"))
			return TFC_Textures.brokenItem;
		else
			return getIconFromDamageForRenderPass(stack.getItemDamage(), pass);
	}

	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", weaponBaseDamage, 0));
		return multimap;
	}


	public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag) 
	{

		ItemTerra.addSizeInformation(is, arraylist);

		if(is.getItem() instanceof ICausesDamage)
			arraylist.add(EnumChatFormatting.AQUA + TFC_Core.translate(((ICausesDamage) this).getDamageType().toString()));
		addExtraInformation(is, player, arraylist);
	}

	public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist)
	{
	}

	
}
