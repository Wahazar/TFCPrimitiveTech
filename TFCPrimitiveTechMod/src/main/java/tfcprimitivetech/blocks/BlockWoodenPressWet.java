package tfcprimitivetech.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import tfcprimitivetech.core.ModBlocks;
import tfcprimitivetech.core.ModItems;
import tfcprimitivetech.render.RenderWoodenPress;
import tfcprimitivetech.tileentities.TileEntityWoodenPressWet;
import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.Core.TFCTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodenPressWet extends BlockTerraContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon _sideIconWet;

    @SideOnly(Side.CLIENT)
    private IIcon _sideIconDry;

    @SideOnly(Side.CLIENT)
    private IIcon _topIcon;
    
    private static int WoodenPress_ColorWet = 0xACADAF;
    private static int WoodenPress_ColorDry = 0xAA9C88;
       
    public BlockWoodenPressWet()
    {
        super(Material.wood);
        
        this.setHardness(0.3f);
        this.setResistance(10.0f);
        this.setCreativeTab(TFCTabs.TFC_TOOLS);
        this.setBlockBounds((float)RenderWoodenPress.VoxelSizeScaled, 0, (float)RenderWoodenPress.VoxelSizeScaled, 1 - (float)RenderWoodenPress.VoxelSizeScaled, 8 * (float)RenderWoodenPress.VoxelSizeScaled, 1 - (float)RenderWoodenPress.VoxelSizeScaled);
        
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops_dry = new ArrayList<ItemStack>();
        ArrayList<ItemStack> drops_wet = new ArrayList<ItemStack>();        
        drops_wet.add(new ItemStack(ModItems.itemCelluloseFibers, 2));        
        drops_wet.add(new ItemStack(ModItems.itemWoodenPress, 2));
        drops_dry.add(new ItemStack(Items.paper, world.rand.nextInt(2) + 1));        
        drops_dry.add(new ItemStack(ModItems.itemWoodenPress, 2 - world.rand.nextInt(20)/20));
        return metadata == 0 ? drops_wet : drops_dry;
        		
    }    

 
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderColor(int meta)
    {
        return meta == 0 ? WoodenPress_ColorWet: WoodenPress_ColorDry;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        return getRenderColor(meta);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
    }

    @Override
    public int damageDropped(int i)
    {
        return i;
    }

 
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return side <= 1 ? _topIcon: (metadata == 0 ?_sideIconWet : _sideIconDry);
    }

    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        String baseName = "tfcprimitivetech:";
        
        _topIcon = register.registerIcon(baseName + "blockWoodenPressTop");
        _sideIconWet = register.registerIcon(baseName + "blockWoodenPressSide1");
        _sideIconDry = register.registerIcon(baseName + "blockWoodenPressPaper");        
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer)
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer)
    {
        return true;
    }

    @Override
    public int getRenderType()
    {
        return ModBlocks.WoodenPressRenderId;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return metadata == 0 ? new TileEntityWoodenPressWet(): null;
    }
}
