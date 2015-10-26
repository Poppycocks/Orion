package com.poppy.orion

import java.io.File

import net.minecraftforge.common.config.Configuration


object Config {

  var config: Configuration = null
  def init(file: File): Unit ={
    config= new Configuration(file)
    config.load()
    loadDefaults()
    if (config.hasChanged) config.save()
  }

  var torchBurnTime: Int = 48000
  var fireHazardBurnChanceLow: Int = 300
  var fireHazardBurnChanceHigh: Int = 2400
  var fireHazardBurnLenght: Int = 6


  private def loadDefaults(): Unit ={
    torchBurnTime = config.getInt("TorchBurnTime","BLOCKS", torchBurnTime, 0,Int.MaxValue, "How long torches burns 0 is until knocked down")
    fireHazardBurnChanceLow = config.getInt("FireHazardBurnChanceLow", "ITEMS", fireHazardBurnChanceLow, 0, Int.MaxValue, "Shortest time before a fire hazard sets you on fire")
    fireHazardBurnChanceHigh = config.getInt("FireHazardBurnChanceHigh", "ITEMS", fireHazardBurnChanceHigh, 1, Int.MaxValue, "Longest time before a fire hazard sets you on fire")
    fireHazardBurnLenght = config.getInt("FireHazardBurnLenght", "ITEMS", fireHazardBurnLenght, 0, 10, "How long you burn after being set on fire by a fire hazard")
  }

}
