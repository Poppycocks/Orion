package com.poppy.orion

import net.minecraft.client.Minecraft
import net.minecraft.util.ResourceLocation

import scala.util.Random

object Cnst {
  final val CLIENT_PROXY_CLASS = "com.poppy.orion.proxy.ClientProxy"
  final val SERVER_PROXY_CLASS = "com.poppy.orion.proxy.CommonProxy"
  final val MOD_ID = "orion"
  final val VERSION = "0.01"
  val rand = new Random()

def bindTexture(textureLocationString: String) = Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(textureLocationString))


}
