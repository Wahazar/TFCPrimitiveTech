package tfcprimitivetech.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import tfcprimitivetech.core.ModDetails;
import tfcprimitivetech.core.ModItems;
import tfcprimitivetech.entities.EntityProjectileSharpStone;
import tfcprimitivetech.entities.EntityProjectileHardStone;
import tfcprimitivetech.entities.EntityProjectileSoftStone;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Enums.EnumAmmo;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISize;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSlingshot extends ItemBow implements ISize
{
	private String[] slingshotPullIconNameArray = new String[] {"pull_0", "pull_1", "pull_2", "pull_3"};
	private IIcon[] iconArray;
	private static int SlingshotDurability 				= 100;
	private static double SlingshotVelocityModifier 	= 1.2d;
	private static double SlingshotAccuracyModifier 	= 0.04d;

	public ItemSlingshot()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(SlingshotDurability);
		setCreativeTab(TFCTabs.TFC_WEAPONS);
		setNoRepair();
		this.setUnlocalizedName("ItemSlingshot");			
	}


	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, is);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			return event.result;

		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.itemSharpStone) || player.inventory.hasItem(ModItems.itemHardStone) || player.inventory.hasItem(ModItems.itemSoftStone) )
			player.setItemInUse(is, this.getMaxItemUseDuration(is));

		return is;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int inUseCount)
	{
			int j = this.getMaxItemUseDuration(is) - inUseCount;	

		ArrowLooseEvent event = new ArrowLooseEvent(player, is, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			return;
		j = event.charge;

		boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, is) > 0;

		boolean hasAmmo = flag || player.inventory.hasItem(ModItems.itemSharpStone) || player.inventory.hasItem(ModItems.itemHardStone) || player.inventory.hasItem(ModItems.itemSoftStone);
		if (hasAmmo)
		{
			float forceMult = j / getUseSpeed(player);
			//f = (f * f + f * 2.0F) / 3.0F;

			if (forceMult < 0.25D)
				return;

			if (forceMult > 1.25F)
				forceMult = 1.25F;

			EntityProjectileSharpStone entitysharpstone = new EntityProjectileSharpStone(world, player, forceMult * 1.2F);
			EntityProjectileHardStone entityhardstone = new EntityProjectileHardStone(world, player, forceMult * 1.5F);
			EntityProjectileSoftStone entitysoftstone = new EntityProjectileSoftStone(world, player, forceMult * 0.8F);

			entitysharpstone.setDamage(forceMult * 40.0);
			entityhardstone.setDamage(forceMult * 50.0);
			entitysoftstone.setDamage(forceMult * 30.0);


			is.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + forceMult * 0.5F);

			if (flag)
			{
//				entitysharpstone.canBePickedUp = 2;
				entityhardstone.canBePickedUp = 2;
//				entitysoftstone.canBePickedUp = 2;
				  if (!world.isRemote)
						world.spawnEntityInWorld(entityhardstone);
				
			}
			else if(hasAmmo)
			{
				if (player.inventory.hasItem(ModItems.itemHardStone))
				{
				  player.inventory.consumeInventoryItem(ModItems.itemHardStone);
				  if (!world.isRemote)
						world.spawnEntityInWorld(entityhardstone);
				}
				else if (player.inventory.hasItem(ModItems.itemSharpStone))
					{
					  player.inventory.consumeInventoryItem(ModItems.itemSharpStone);
					  if (!world.isRemote)
							world.spawnEntityInWorld(entitysharpstone);
					}
				else 
					{
						player.inventory.consumeInventoryItem(ModItems.itemSoftStone);
						if (!world.isRemote)
							world.spawnEntityInWorld(entitysoftstone);
					}
			}
		}
	}

	public float getUseSpeed(EntityPlayer player)
	{
		float speed = 60.0f;
		ItemStack[] armor = player.inventory.armorInventory;
		if(armor[0] != null && armor[0].getItem() instanceof ISize)
			speed += 20.0f / ((ISize)armor[0].getItem()).getWeight(armor[0]).multiplier;
		if(armor[1] != null && armor[1].getItem() instanceof ISize)
			speed += 20.0f / ((ISize)armor[1].getItem()).getWeight(armor[1]).multiplier;
		if(armor[2] != null && armor[2].getItem() instanceof ISize)
			speed += 20.0f / ((ISize)armor[2].getItem()).getWeight(armor[2]).multiplier;
		if(armor[3] != null && armor[3].getItem() instanceof ISize)
			speed += 20.0f / ((ISize)armor[3].getItem()).getWeight(armor[3]).multiplier;

		return speed;
	}

	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag) 
	{
		ItemTerra.addSizeInformation(is, arraylist);
	}

	@Override
	public EnumSize getSize(ItemStack is)
	{
		return EnumSize.MEDIUM;
	}

	@Override
	public EnumWeight getWeight(ItemStack is)
	{
		return EnumWeight.LIGHT;
	}

	@Override
	public boolean canStack()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ModDetails.ModID + ":" + "ItemSlingshot" + "_standby");
		iconArray = new IIcon[slingshotPullIconNameArray.length];

		for (int i = 0; i < iconArray.length; ++i)
			iconArray[i] = par1IconRegister.registerIcon(ModDetails.ModID + ":" + "ItemSlingshot" + "_" + slingshotPullIconNameArray[i]);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int par1)
	{
		return iconArray[par1];
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
        if (usingItem != null && usingItem.getItem() == this)
        {
            int j = usingItem.getMaxItemUseDuration() - useRemaining;
            float force = j / getUseSpeed(player);

			if (force >= 1.25) // Fully drawn
            {
				return getItemIconForUseDuration(3);
			}
			else if (force > 0.75)
            {
				return getItemIconForUseDuration(2);
            }
			else if (force > 0.25) // Minimum required force to fire
            {
                return getItemIconForUseDuration(1);
            }
			else if (force > 0)
            {
                return getItemIconForUseDuration(0);
            }
        }
        return getIcon(stack, renderPass);
	}

	@Override
	public EnumItemReach getReach(ItemStack is) {
		return EnumItemReach.SHORT;
	}
}
