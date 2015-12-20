package com.poppy.orion.models

import net.minecraft.client.model.ModelRenderer
import net.minecraft.client.model.ModelBase

class ModelAxle extends ModelBase {

  textureWidth = 16
  textureHeight = 16

  //Cube
  val Axle: ModelRenderer = new ModelRenderer(this)
  Axle.setTextureSize(textureWidth, textureHeight)
  Axle.addBox(0F, 0F, 0F, 4, 16, 4)
  Axle.setRotationPoint(-2F, 8F, -2F)

  setRotation(Axle, -0F, -0F, -0F)

  def render(){Axle.render(0.625F)}

  def setRotation(model: ModelRenderer, x: Float, y: Float, z: Float){
      model.rotateAngleX = x
      model.rotateAngleY = y
      model.rotateAngleZ = z
  }

}