package com.poppy.orion.renders

import com.poppy.orion.Cnst
import com.poppy.orion.models.ModelAxle
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import org.lwjgl.opengl.GL11

class TESRAxle extends TileEntitySpecialRenderer{
  val axleModel: ModelAxle = new ModelAxle

  override def renderTileEntityAt(te: TileEntity, x: Double, y: Double, z: Double, f: Float): Unit = {
    GL11.glPushMatrix()
    Cnst.bindTexture("orion:textures/blocks/axle.png")
    GL11.glTranslated(x,y,z)
    axleModel.render()
    GL11.glPopMatrix()
  }
}
