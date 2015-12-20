package com.poppy.orion

import com.poppy.orion.tileents.TEAxle
import cpw.mods.fml.common.registry.GameRegistry

object TileEntities {

  def init(){
    GameRegistry.registerTileEntity(classOf[TEAxle], "AFuckingTileEntity")
  }
}
