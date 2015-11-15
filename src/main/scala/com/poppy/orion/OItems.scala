package com.poppy.orion

import com.poppy.orion.items.{IFireHazard, ILighter, itemSimple}
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

object OItems {

  val itemFireSticks = new itemSimple("firesticks", CreativeTabs.tabTools, 1, 1) with ILighter
  val itemFlintAndSteel = new itemSimple("flintandsteel", CreativeTabs.tabTools, 1, 512) with ILighter
  val itemFireBox = new itemSimple("firebox", CreativeTabs.tabTools, 1, 0) with ILighter with IFireHazard
  val itemMatches = new itemSimple("matches", CreativeTabs.tabTools, 1, 64)

  val itemGlowCrystal = new itemSimple("glowcrystal", CreativeTabs.tabMaterials, 64, 0)

  val itemIronChunk = new itemSimple("ironchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemNickelChunk = new itemSimple("nickelchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemGoldChunk = new itemSimple("goldchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemCopperChunk = new itemSimple("copperchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemTinChunk = new itemSimple("tinchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemSilverChunk = new itemSimple("silverchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemLeadChunk = new itemSimple("leadchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemAluminumChunk = new itemSimple("aluminumchunk",CreativeTabs.tabMaterials, 64, 0)
  val itemOsmiumChunk = new itemSimple ("osmiumchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemPlatinumChunk = new itemSimple ("platinumchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemCobaltChunk = new itemSimple("cobaltchunk", CreativeTabs.tabMaterials, 64, 0)
  val itemArditeChunk = new itemSimple("arditechunk", CreativeTabs.tabMaterials, 64, 0)

  val itemUncutSapphire = new itemSimple("sapphireuncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutPeridot = new itemSimple("peridotuncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutRuby = new itemSimple("rubyuncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutDiamond = new itemSimple("diamonduncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutEmerald = new itemSimple("emeralduncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutNetherQuartz = new itemSimple("netherquartzuncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutCertusQuartz = new itemSimple("certusquartzuncut", CreativeTabs.tabMaterials, 64, 0)
  val itemUncutChargedCertusQuartz = new itemSimple("chargedcertusquartzuncut", CreativeTabs.tabMaterials, 64, 0)

  val itemRedStone = new itemSimple("redstonechunk", CreativeTabs.tabMaterials, 64, 0)
  val itemLapisChunk = new itemSimple("lapischunk", CreativeTabs.tabMaterials, 64, 0)
  val itemElectrotineChunk = new itemSimple("electrotinechunk", CreativeTabs.tabMaterials, 64, 0)

  val itemIronTinyDust = new itemSimple("irontinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemNickelTinyDust = new itemSimple("nickeltinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemGoldTinyDust = new itemSimple("goldtinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemCopperTinyDust = new itemSimple("coppertinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemTinTinyDust = new itemSimple("tintinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemSilverTinyDust = new itemSimple("silvertinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemLeadTinyDust = new itemSimple("leadtinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemAluminumTinyDust = new itemSimple("aluminumtinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemOsmiumTinyDust = new itemSimple("osmiumtinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemPlatinumTinyDust = new itemSimple("platinumtinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemCobaltTinyDust = new itemSimple("cobalttinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemArditeTinyDust = new itemSimple("arditetinydust", CreativeTabs.tabMaterials, 64, 0)

  val itemRedstoneTinyDust = new itemSimple("redstonetinydust", CreativeTabs.tabMaterials, 64, 0)
  val itemElectrotineTinyDust = new itemSimple("electrotinetinydust", CreativeTabs.tabMaterials, 64, 0)



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

    GameRegistry.registerItem(itemIronChunk, "ironchunk")
    OreDictionary.registerOre("chunkIron", itemIronChunk)
    GameRegistry.registerItem(itemNickelChunk, "nickelchunk")
    OreDictionary.registerOre("chunkNickel", itemNickelChunk)
    GameRegistry.registerItem(itemGoldChunk, "goldchunk")
    OreDictionary.registerOre("chunkGold", itemGoldChunk)
    GameRegistry.registerItem(itemCopperChunk, "copperchunk")
    OreDictionary.registerOre("chunkCopper", itemCopperChunk)
    GameRegistry.registerItem(itemTinChunk, "tinchunk")
    OreDictionary.registerOre("chunkTin", itemTinChunk)
    GameRegistry.registerItem(itemSilverChunk, "silverchunk")
    OreDictionary.registerOre("chunkSilver", itemSilverChunk)
    GameRegistry.registerItem(itemLeadChunk, "leadchunk")
    OreDictionary.registerOre("chunkLead", itemLeadChunk)
    GameRegistry.registerItem(itemAluminumChunk, "aluminumchunk")
    OreDictionary.registerOre("chunkAluminum", itemAluminumChunk)
    OreDictionary.registerOre("chunkAluminium", itemAluminumChunk)
    GameRegistry.registerItem(itemOsmiumChunk, "osmiumchunk")
    OreDictionary.registerOre("chunkOsmium", itemOsmiumChunk)
    GameRegistry.registerItem(itemPlatinumChunk, "platinumchunk")
    OreDictionary.registerOre("chunkPlatinum", itemPlatinumChunk)

    GameRegistry.registerItem(itemCobaltChunk, "cobaltchunk")
    OreDictionary.registerOre("chunkCobalt", itemCobaltChunk)
    GameRegistry.registerItem(itemArditeChunk, "arditechunk")
    OreDictionary.registerOre("chunkArdite", itemArditeChunk)

    GameRegistry.registerItem(itemUncutSapphire, "uncutsapphire")
    OreDictionary.registerOre("chunkSapphire", itemUncutSapphire)
    GameRegistry.registerItem(itemUncutPeridot, "uncutperidot")
    OreDictionary.registerOre("chunkPeridot", itemUncutPeridot)
    GameRegistry.registerItem(itemUncutRuby, "uncutruby")
    OreDictionary.registerOre("chunkRuby", itemUncutRuby)
    GameRegistry.registerItem(itemUncutDiamond, "uncutdiamond")
    OreDictionary.registerOre("chunkDiamond", itemUncutDiamond)
    GameRegistry.registerItem(itemUncutEmerald, "uncutemerald")
    OreDictionary.registerOre("chunkEmerald", itemUncutEmerald)
    GameRegistry.registerItem(itemUncutNetherQuartz, "uncutnetherquartz")
    OreDictionary.registerOre("chunkNetherQuartz", itemUncutNetherQuartz)
    GameRegistry.registerItem(itemUncutCertusQuartz, "uncutcertusquartz")
    OreDictionary.registerOre("chunkCertusQuartz", itemUncutCertusQuartz)
    GameRegistry.registerItem(itemUncutChargedCertusQuartz, "uncutchargednetherquartz")
    OreDictionary.registerOre("chunkCertusChargedQuartz", itemUncutChargedCertusQuartz)
    GameRegistry.registerItem(itemRedStone, "redstone")
    OreDictionary.registerOre("chunkRedstone", itemRedStone)
    GameRegistry.registerItem(itemLapisChunk, "lapischunk")
    OreDictionary.registerOre("chunkLapis", itemLapisChunk)
    GameRegistry.registerItem(itemElectrotineChunk, "electrotinechunk")
    OreDictionary.registerOre("chunkElectrotine", itemElectrotineChunk)

    GameRegistry.registerItem(itemIronTinyDust,"irontinydust")
    GameRegistry.registerItem(itemNickelTinyDust,"nickeltinydust")
    GameRegistry.registerItem(itemGoldTinyDust,"goldtinydust")
    GameRegistry.registerItem(itemCopperTinyDust,"coppertinydust")
    GameRegistry.registerItem(itemTinTinyDust,"tintinydust")
    GameRegistry.registerItem(itemSilverTinyDust,"silvertinydust")
    GameRegistry.registerItem(itemLeadTinyDust,"leadtinydust")
    GameRegistry.registerItem(itemAluminumTinyDust,"aluminumtinydust")
    GameRegistry.registerItem(itemOsmiumTinyDust,"osmiumtinydust")
    GameRegistry.registerItem(itemPlatinumTinyDust,"platinumtinydust")
    GameRegistry.registerItem(itemCobaltTinyDust,"cobalttinydust")
    GameRegistry.registerItem(itemArditeTinyDust,"arditetinydust")

    GameRegistry.registerItem(itemRedstoneTinyDust,"redstonetinydust")
    GameRegistry.registerItem(itemElectrotineTinyDust,"electrotinetinydust")


  }

}
