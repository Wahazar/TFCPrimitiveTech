package tfcprimitivetech.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.bioxx.tfc.Reference;

import tfcprimitivetech.core.ModDetails;
import tfcprimitivetech.entities.EntityProjectileSharpStone;

public class RenderSharpStone extends Render
{
	public void render(EntityProjectileSharpStone entity, double x, double y, double z, float par8, float par9)
	{
		bindEntityTexture(entity);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
		Tessellator tessellator = Tessellator.instance;
		float fx1 = 0.0F;
		float fx2 = 8 / 32.0F;
		float fy1 = 0.0F;
		float fy2 = 8 / 32.0F;

		float f10 = 0.05625F;

		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(f10, f10, f10);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);

		for (int i = 0; i < 2; ++i)
		{
			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-2.0D, -2.0D, 0.0D, fx1, fy1);
			tessellator.addVertexWithUV(2.0D, -2.0D, 0.0D, fx2, fy1);
			tessellator.addVertexWithUV(2.0D, 2.0D, 0.0D, fx2, fy2);
			tessellator.addVertexWithUV(-2.0D, 2.0D, 0.0D, fx1, fy2);
			tessellator.draw();
		}

		for (int i = 0; i < 2; ++i)
		{
			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(0.0D, -2.0D, -2.0D, fx1, fy1);
			tessellator.addVertexWithUV(0.0D, -2.0D, 2.0D, fx2, fy1);
			tessellator.addVertexWithUV(0.0D, 2.0D, 2.0D, fx2, fy2);
			tessellator.addVertexWithUV(0.0D, 2.0D, -2.0D, fx1, fy2);
			tessellator.draw();
		}
		
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.render((EntityProjectileSharpStone)par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation(ModDetails.ModID, "textures/models/sharpstone.png");
	}
}
