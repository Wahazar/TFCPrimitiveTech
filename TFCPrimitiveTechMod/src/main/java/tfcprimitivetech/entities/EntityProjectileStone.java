package tfcprimitivetech.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import tfcprimitivetech.core.ModItems;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Enums.EnumDamageType;
import com.bioxx.tfc.api.Interfaces.ICausesDamage;


public class EntityProjectileStone extends EntityArrow implements ICausesDamage
{

	public EntityProjectileStone(World par1World)
	{
		super(par1World);
	}

	public EntityProjectileStone(World world, double i, double j, double k)
	{
		super(world, i, j, k);
	}

	public EntityProjectileStone(World world, EntityLivingBase shooter, EntityLivingBase victim, float force, float forceVariation)
	{
		super(world, shooter, victim, force, forceVariation);
	}

	public EntityProjectileStone(World world, EntityLivingBase par2EntityLivingBase, float force)
	{
		super(world, par2EntityLivingBase, force);
	}


	@Override
	public EnumDamageType getDamageType()
	{
		return EnumDamageType.GENERIC;
	}
}

