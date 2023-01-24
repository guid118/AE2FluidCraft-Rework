package com.glodblock.github.client.render;

import com.glodblock.github.FluidCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderBlockWalrus extends TileEntitySpecialRenderer {
    IModelCustom modelWalrus = AdvancedModelLoader.loadModel(FluidCraft.resource("models/walrus.obj"));
    ResourceLocation textureWalrus = FluidCraft.resource("textures/blocks/walrus.png");

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTickTime) {
        Minecraft.getMinecraft().renderEngine.bindTexture(this.textureWalrus);
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        int orientation = tileentity.getBlockMetadata();
        if (orientation == 4) {
            GL11.glRotatef(90, 0, 1, 0);
        } else if (orientation == 5) {
            GL11.glRotatef(-90, 0, 1, 0);
        } else if (orientation == 3) {
            GL11.glRotatef(180, 0, 1, 0);
        }
        this.modelWalrus.renderAll();
        GL11.glPopMatrix();
    }
}
