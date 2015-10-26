package com.poppy.orion

import com.poppy.orion.items.{IFireHazard, ILighter, itemSimple}
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

object Items {

  val itemFireSticks = new itemSimple("firesticks", CreativeTabs.tabTools, 1, 1) with ILighter
  val itemFlintAndSteel = new itemSimple("flintandsteel", CreativeTabs.tabTools, 1, 512) with ILighter
  val itemFireBox = new itemSimple("firebox", CreativeTabs.tabTools, 1, 0) with ILighter with IFireHazard
  val itemMatches = new itemSimple("matches", CreativeTabs.tabTools, 1, 64)
  val itemGlowCrystal = new itemSimple("glowcrystal", CreativeTabs.tabMaterials, 64, 0)

  def init(){

    GameRegistry.registerItem(itemFireSticks, "firesticks")

    GameRegistry.registerItem(itemFlintAndSteel, "flintandsteel")
    OreDictionary.registerOre("itemIgniter", new ItemStack(itemFlintAndSteel,1, OreDictionary.WILDCARD_VALUE))

    GameRegistry.registerItem(itemFireBox, "firebox")
    OreDictionary.registerOre("itemIgniter", itemFireBox)
    OreDictionary.registerOre("itemLight", itemFireBox)

    GameRegistry.registerItem(itemMatches, "matches")
    OreDictionary.registerOre("itemIgniter", new ItemStack(itemMatches, 1, OreDictionary.WILDCARD_VALUE))

    GameRegistry.registerItem(itemGlowCrystal, "glowcrystal")
    OreDictionary.registerOre("itemLight", itemGlowCrystal)


  }

}
