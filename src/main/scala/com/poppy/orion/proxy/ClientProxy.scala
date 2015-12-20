package com.poppy.orion.proxy

import com.poppy.orion.renders.TESRAxle
import com.poppy.orion.tileents.TEAxle
import cpw.mods.fml.client.registry.ClientRegistry

class ClientProxy extends CommonProxy{
  ClientRegistry.bindTileEntitySpecialRenderer(classOf[TEAxle], new TESRAxle)

}
