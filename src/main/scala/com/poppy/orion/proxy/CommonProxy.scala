package com.poppy.orion.proxy

import com.poppy.orion.{OItems, TileEntities, Orion, OBlocks}
import cpw.mods.fml.common.event.FMLPreInitializationEvent

/**
 * Created by Ľubko on 7. 5. 2015.
 */
class CommonProxy {
  def preInit(e: FMLPreInitializationEvent): Unit = {
    Orion.logger.info("Initialising Items")
    OItems.init()
    Orion.logger.info("Initialising Blocks")
    OBlocks.init()
    Orion.logger.info("Registering TileEntities")
    TileEntities.init()
  }
}
