package com.poppy.orion.proxy

import com.poppy.orion.{Items, TileEntities, Orion, Blocks}
import cpw.mods.fml.common.event.FMLPreInitializationEvent

/**
 * Created by Ľubko on 7. 5. 2015.
 */
class CommonProxy {
  def preInit(e: FMLPreInitializationEvent): Unit = {
    Orion.logger.info("Initialising Items")
    Items.init()
    Orion.logger.info("Initialising Blocks")
    Blocks.init()
    Orion.logger.info("Registering TileEntities")
    TileEntities.init()
  }
}
