package com.poppy.orion

import com.poppy.orion.proxy.CommonProxy
import cpw.mods.fml.common.event._
import cpw.mods.fml.common.{Mod, SidedProxy}
import org.apache.logging.log4j.LogManager


@Mod(modid= Cnst.MOD_ID, name= "Orion", version=Cnst.VERSION, modLanguage="scala")
object Orion{

  val logger = LogManager.getLogger("Orion")

  @SidedProxy(clientSide = Cnst.CLIENT_PROXY_CLASS, serverSide = Cnst.SERVER_PROXY_CLASS)
  var proxy:CommonProxy = null

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent) {
    Config.init(e.getSuggestedConfigurationFile())

    //logger. info("OMG I'm in the preInit phase! Hooray!")
    proxy.preInit(e)
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent) {
    //logger.info("OMG I'm in the init phase! Huzzah!")
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent) {
    //logger.info("OMG I'm in the postInit phase! Praise Cthulhu!")
  }

}

