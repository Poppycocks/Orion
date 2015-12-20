package com.poppy.orion

import com.poppy.orion.blocks._
import com.poppy.orion.items.ItemHardOre
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockTorch}
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.oredict.OreDictionary


object OBlocks {
  val blockTorchLit = new BlockTorchR("torchlit", 0)
  val blockTorchSmoldering = new BlockTorchR("torchsmoldering", 1)
  val blockTorchUnlit: Block = new BlockTorchR("torchunlit", 2)
  val torchVariants = List(blockTorchLit, blockTorchSmoldering, blockTorchUnlit)

  val blockGlowComposite = new BlockGlowComposite
  val blockGlowTorch = new BlockTorch {setStepSound(Block.soundTypeWood) setBlockName("orion.glowtorch") setBlockTextureName("orion:glowtorchlit") setLightLevel(1.0F); override def randomDisplayTick(w: World, x: Int, y: Int, z: Int, r: java.util.Random) = null}
  //val blockGlowTorchLit = new BlockGlowTorch(true){setStepSound(Block.soundTypeWood) setBlockName("orion.glowtorchlit") setBlockTextureName("orion:glowtorchlit")}
  //val blockGlowTorchUnlit = new BlockGlowTorch(false){setStepSound(Block.soundTypeWood) setBlockName("orion.glowtorchunlit") setBlockTextureName("orion:glowtorchunlit") setCreativeTab(CreativeTabs.tabRedstone) setLightLevel(1.0F)}
  val blockAutoMining = new Block(Material.dragonEgg) {setStepSound(Block.soundTypeStone) setBlockName("orion.mininglevelauto") setBlockTextureName("minecraft:bedrock")}
  val blockEndGame = new Block(Material.dragonEgg) {setStepSound(Block.soundTypeStone) setBlockName("orion.mininglevelend") setBlockTextureName("minecraft:bedrock")}
  val blockAxle = new BlockAxle

  //Overworld hard ore blocks
  val blocksIronOre = new BlockHardOre("iron", 2, 6) {drops = List( (OItems.itemIronChunk, 0), (OItems.itemNickelChunk, 20), (OItems.itemUncutPeridot, 3) )}
  val blocksNickelOre = new BlockHardOre("nickel", 2, 6) {drops = List( (OItems.itemNickelChunk, 0), (OItems.itemPlatinumChunk, 20))}
  val blocksGoldOre = new BlockHardOre("gold", 2, 6) {drops = List((OItems.itemGoldChunk, 0), (OItems.itemCopperChunk, 20))}
  val blocksCopperOre = new BlockHardOre("copper", 1, 6) {drops = List((OItems.itemCopperChunk, 0), (OItems.itemGoldChunk, 20))}
  val blocksTinOre = new BlockHardOre("tin", 1, 6) {drops = List((OItems.itemTinChunk, 0))}
  val blocksSilverOre = new BlockHardOre("silver", 3, 6) {drops = List((OItems.itemSilverChunk, 0), (OItems.itemLeadChunk, 40))}
  val blocksLeadOre = new BlockHardOre("lead", 3, 6) {drops = List((OItems.itemLeadChunk, 0), (OItems.itemSilverChunk, 40))}
  val blocksAluminumOre = new BlockHardOre("aluminum", 1, 6) {drops = List((OItems.itemAluminumChunk, 0),(OItems.itemIronChunk, 10), (OItems.itemUncutRuby, 3), (OItems.itemUncutSapphire, 3))}
  val blocksPlatinumOre = new BlockHardOre("platinum", 1, 6) {drops = List((OItems.itemPlatinumChunk, 0))}

  val blocksCoalOre = new BlockHardOre("coal", 0, 3) {drops = List((Items.coal, 0), (OItems.itemUncutDiamond, 1)); fortuneVariance = 0}
  val blocksRedstoneOre = new BlockHardOre("redstone", 4, 6) {drops = List((OItems.itemRedStone, 0))}
  val blocksLapisOre = new BlockHardOre("lapis", 3, 6) {drops = List((OItems.itemLapisChunk, 0))}
  val blocksElectrotineOre = new BlockHardOre("electrotine", 4, 6) {drops = List((OItems.itemElectrotineChunk, 0))}
  val blocksDiamondOre = new BlockHardOre("diamond", 5, 6) {drops = List((OItems.itemUncutDiamond, 0))}
  val blocksEmeraldOre = new BlockHardOre("emerald", 5, 6) {drops = List((OItems.itemUncutEmerald, 0))}
  //Nether hard ore blocks
  val blocksNetherIronOre = new BlockHardOre("netheriron", 8, 8) {drops = List( (OItems.itemIronChunk, 0), (OItems.itemNickelChunk, 20), (OItems.itemUncutPeridot, 4) )}
  val blocksNetherNickelOre = new BlockHardOre("nethernickel", 8, 8) {drops = List( (OItems.itemNickelChunk, 0), (OItems.itemPlatinumChunk, 20))}
  val blocksNetherGoldOre = new BlockHardOre("nethergold", 8, 8) {drops = List((OItems.itemGoldChunk, 0), (OItems.itemCopperChunk, 20))}
  val blocksNetherCopperOre = new BlockHardOre("nethercopper", 8, 8) {drops = List((OItems.itemCopperChunk, 0), (OItems.itemGoldChunk, 20))}
  val blocksNetherTinOre = new BlockHardOre("nethertin", 8, 8) {drops = List((OItems.itemTinChunk, 0))}
  val blocksNetherSilverOre = new BlockHardOre("nethersilver", 8, 8) {drops = List((OItems.itemSilverChunk, 0), (OItems.itemLeadChunk, 40))}
  val blocksNetherLeadOre = new BlockHardOre("netherlead", 8, 8) {drops = List((OItems.itemLeadChunk, 0), (OItems.itemSilverChunk, 40))}
  val blocksNetherAluminumOre = new BlockHardOre("netheraluminum", 8, 8) {drops = List((OItems.itemAluminumChunk, 0),(OItems.itemIronChunk, 10), (OItems.itemUncutRuby, 4), (OItems.itemUncutSapphire, 4))}
  val blocksNetherOsmiumOre = new BlockHardOre("netherosmium", 8, 8) {drops = List ((OItems.itemOsmiumChunk, 0))}
  val blocksNetherCobaltOre = new BlockHardOre("nethercobalt", 8, 8) {drops = List ((OItems.itemCobaltChunk, 0))}
  val blocksNetherArditeOre = new BlockHardOre("netherardite", 7, 8) {drops = List ((OItems.itemArditeChunk, 0))}

  val blocksNetherCoalOre = new BlockHardOre("nethercoal", 8, 5) {drops = List((Items.coal, 0), (OItems.itemUncutDiamond, 1)); fortuneVariance = 0}
  val blocksNetherRedstoneOre = new BlockHardOre("netherredstone", 8, 8) {drops = List((OItems.itemRedStone, 0))}
  val blocksNetherLapisOre = new BlockHardOre("netherlapis", 8, 8) {drops = List((OItems.itemLapisChunk, 0))}
  val blocksNetherElectrotineOre = new BlockHardOre("netherelectrotine", 8, 8) {drops = List((OItems.itemElectrotineChunk, 0))}
  val blocksNetherDiamondOre = new BlockHardOre("netherdiamond", 8, 8) {drops = List((OItems.itemUncutDiamond, 0))}
  val blocksNetherQuartzOre = new BlockHardOre("netherquartz", 8, 8) {drops = List((OItems.itemUncutNetherQuartz, 0))}
  //DD hard ore blocks
  val blocksDDIronOre = new BlockHardOre("ddiron", 11, 11) {drops = List( (OItems.itemIronChunk, 0), (OItems.itemNickelChunk, 20), (OItems.itemUncutPeridot, 5) )}
  val blocksDDNickelOre = new BlockHardOre("ddnickel", 11, 11) {drops = List( (OItems.itemNickelChunk, 0), (OItems.itemPlatinumChunk, 20))}
  val blocksDDGoldOre = new BlockHardOre("ddgold", 11, 11) {drops = List((OItems.itemGoldChunk, 0), (OItems.itemCopperChunk, 20))}
  val blocksDDCopperOre = new BlockHardOre("ddcopper", 11, 11) {drops = List((OItems.itemCopperChunk, 0), (OItems.itemGoldChunk, 20))}
  val blocksDDTinOre = new BlockHardOre("ddtin", 11, 11) {drops = List((OItems.itemTinChunk, 0))}
  val blocksDDSilverOre = new BlockHardOre("ddsilver", 11, 11) {drops = List((OItems.itemSilverChunk, 0), (OItems.itemLeadChunk, 40))}
  val blocksDDLeadOre = new BlockHardOre("ddlead", 11, 11) {drops = List((OItems.itemLeadChunk, 0), (OItems.itemSilverChunk, 40))}
  val blocksDDAluminumOre = new BlockHardOre("ddaluminum", 11, 11) {drops = List((OItems.itemAluminumChunk, 0),(OItems.itemIronChunk, 10), (OItems.itemUncutRuby, 5), (OItems.itemUncutSapphire, 5))}
  val blocksDDOsmiumOre = new BlockHardOre("ddosmium", 11, 11) {drops = List((OItems.itemOsmiumChunk, 0))}

  val blocksDDCoalOre = new BlockHardOre("ddcoal", 11, 7) {drops = List((Items.coal, 0), (OItems.itemUncutDiamond, 1)); fortuneVariance = 0}
  val blocksDDRedstoneOre = new BlockHardOre("ddredstone", 11, 11) {drops = List((OItems.itemRedStone, 0))}
  val blocksDDLapisOre = new BlockHardOre("ddlapis", 11, 11) {drops = List((OItems.itemLapisChunk, 0))}
  val blocksDDElectrotineOre = new BlockHardOre("ddelectrotine", 1, 11) {drops = List((OItems.itemElectrotineChunk, 0))}
  val blocksDDDiamondOre = new BlockHardOre("dddiamond", 11, 11) {drops = List((OItems.itemUncutDiamond, 0))}
  val blocksDDEmeraldOre = new BlockHardOre("ddemerald", 11, 11) {drops = List((OItems.itemUncutEmerald, 0))}
  val blocksDDCertusQuartzOre = new BlockHardOre("ddcertusquartz", 11, 11) {drops = List((OItems.itemUncutCertusQuartz, 0))}
  //val blocksDDChargedCertusQuartzOre = new BlockHardOre("ddchargedcertusquartz", 11, 11) {drops = List((Items.itemUncutChargedCertusQuartz, 0))}

  def init(){
    GameRegistry.registerBlock(blockTorchLit, "torchlit")
    OreDictionary.registerOre("blockTorch", blockTorchLit)
    GameRegistry.registerBlock(blockTorchSmoldering, "torchsmoldering")
    GameRegistry.registerBlock(blockTorchUnlit, "torchunlit")
    GameRegistry.registerBlock(blockGlowTorch,"glowtorch")
    OreDictionary.registerOre("blockTorch", blockGlowTorch)

    GameRegistry.registerBlock(blockGlowComposite, "glowcomposite")
    GameRegistry.registerBlock(blockAutoMining, "automining")
    GameRegistry.registerBlock(blockEndGame, "endgame")
    //GameRegistry.registerBlock(blockGlowTorchLit, "glowtorchlit")
    //OreDictionary.registerOre("itemLight", blockGlowTorchLit)
    //GameRegistry.registerBlock(blockGlowTorchUnlit, "glowtorchunlit")
    GameRegistry.registerBlock(blockAxle, "blockaxle")


    //Overworld Ores
    GameRegistry.registerBlock(blocksIronOre, classOf[ItemHardOre], "ironore")
    OreDictionary.registerOre("oreIron", new ItemStack(blocksIronOre,1, 6))
    GameRegistry.registerBlock(blocksNickelOre, classOf[ItemHardOre], "nickelore")
    OreDictionary.registerOre("oreNickel", new ItemStack(blocksNickelOre,1, 6))
    GameRegistry.registerBlock(blocksGoldOre, classOf[ItemHardOre], "goldore")
    OreDictionary.registerOre("oreGold", new ItemStack(blocksGoldOre,1, 6))
    GameRegistry.registerBlock(blocksCopperOre, classOf[ItemHardOre], "copperore")
    OreDictionary.registerOre("oreCopper", new ItemStack(blocksCopperOre,1, 6))
    GameRegistry.registerBlock(blocksTinOre, classOf[ItemHardOre], "tinore")
    OreDictionary.registerOre("oreTin", new ItemStack(blocksTinOre,1, 6))
    GameRegistry.registerBlock(blocksSilverOre, classOf[ItemHardOre], "silverore")
    OreDictionary.registerOre("oreSilver", new ItemStack(blocksSilverOre,1, 6))
    GameRegistry.registerBlock(blocksLeadOre, classOf[ItemHardOre], "leadore")
    OreDictionary.registerOre("oreLead", new ItemStack(blocksLeadOre,1, 6))
    GameRegistry.registerBlock(blocksAluminumOre, classOf[ItemHardOre], "aluminumore")
    OreDictionary.registerOre("oreAluminum", new ItemStack(blocksAluminumOre,1, 6))
    OreDictionary.registerOre("oreAluminium", new ItemStack(blocksAluminumOre, 1, 6))
    GameRegistry.registerBlock(blocksRedstoneOre, classOf[ItemHardOre], "redstoneore")
    OreDictionary.registerOre("oreRedstone", new ItemStack(blocksRedstoneOre,1, 6))
    GameRegistry.registerBlock(blocksLapisOre, classOf[ItemHardOre], "lapisore")
    OreDictionary.registerOre("oreLapis", new ItemStack(blocksLapisOre,1, 6))
    GameRegistry.registerBlock(blocksElectrotineOre, classOf[ItemHardOre], "electrotineore")
    OreDictionary.registerOre("oreElectrotine", new ItemStack(blocksElectrotineOre,1, 6))
    GameRegistry.registerBlock(blocksDiamondOre, classOf[ItemHardOre], "diamondore")
    OreDictionary.registerOre("oreDiamond", new ItemStack(blocksDiamondOre,1, 6))
    GameRegistry.registerBlock(blocksEmeraldOre, classOf[ItemHardOre], "emeraldore")
    OreDictionary.registerOre("oreEmerald", new ItemStack(blocksEmeraldOre, 1, 6))
    GameRegistry.registerBlock(blocksPlatinumOre, classOf[ItemHardOre], "platinumore")
    OreDictionary.registerOre("orePlatinum", new ItemStack(blocksPlatinumOre, 1, 6))
    GameRegistry.registerBlock(blocksCoalOre, classOf[ItemHardOre], "coalore")
    OreDictionary.registerOre("oreCoal", new ItemStack(blocksCoalOre, 1, 3))
   //Nether Ores
    GameRegistry.registerBlock(blocksNetherIronOre, classOf[ItemHardOre], "ironnetherore")
    OreDictionary.registerOre("oreNetherIron", new ItemStack(blocksNetherIronOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherNickelOre, classOf[ItemHardOre], "nickelnetherore")
    OreDictionary.registerOre("oreNetherNickel", new ItemStack(blocksNetherNickelOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherGoldOre, classOf[ItemHardOre], "goldnetherore")
    OreDictionary.registerOre("oreNetherGold", new ItemStack(blocksNetherGoldOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherCopperOre, classOf[ItemHardOre], "coppernetherore")
    OreDictionary.registerOre("oreNetherCopper", new ItemStack(blocksNetherCopperOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherTinOre, classOf[ItemHardOre], "tinnetherore")
    OreDictionary.registerOre("oreNetherTin", new ItemStack(blocksNetherTinOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherSilverOre, classOf[ItemHardOre], "silvernetherore")
    OreDictionary.registerOre("oreNetherSilver", new ItemStack(blocksNetherSilverOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherLeadOre, classOf[ItemHardOre], "leadnetherore")
    OreDictionary.registerOre("oreNetherLead", new ItemStack(blocksNetherLeadOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherAluminumOre, classOf[ItemHardOre], "aluminumnetherore")
    OreDictionary.registerOre("oreNetherAluminum", new ItemStack(blocksNetherAluminumOre, 1, 8))
    OreDictionary.registerOre("oreNetherAluminium", new ItemStack(blocksNetherAluminumOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherOsmiumOre, classOf[ItemHardOre], "osmiumnetherore")
    OreDictionary.registerOre("oreNetherOsmium", new ItemStack(blocksNetherOsmiumOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherRedstoneOre, classOf[ItemHardOre], "redstonenetherore")
    OreDictionary.registerOre("oreNetherRedstone", new ItemStack(blocksNetherRedstoneOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherLapisOre, classOf[ItemHardOre], "lapisnetherore")
    OreDictionary.registerOre("oreNetherLapis", new ItemStack(blocksNetherLapisOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherElectrotineOre, classOf[ItemHardOre], "electrotinenetherore")
    OreDictionary.registerOre("oreNetherElectrotine", new ItemStack(blocksNetherElectrotineOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherDiamondOre, classOf[ItemHardOre], "diamondnetherore")
    OreDictionary.registerOre("oreNetherDiamond", new ItemStack(blocksNetherDiamondOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherQuartzOre, classOf[ItemHardOre], "netherquartzore")
    OreDictionary.registerOre("oreNetherQuartz", new ItemStack(blocksNetherQuartzOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherCobaltOre, classOf[ItemHardOre], "cobaltnetheror")
    OreDictionary.registerOre("oreNetherCobalt", new ItemStack(blocksNetherCobaltOre, 1, 8))
    GameRegistry.registerBlock(blocksNetherArditeOre, classOf[ItemHardOre], "arditenetherore")
    OreDictionary.registerOre("oreNetherArdite", new ItemStack(blocksNetherArditeOre, 1 ,8))
    GameRegistry.registerBlock(blocksNetherCoalOre, classOf[ItemHardOre], "nethercoalore")
    OreDictionary.registerOre("oreNetherCoal", new ItemStack(blocksNetherCoalOre, 1, 5))
    //Ores Deep Dark
    GameRegistry.registerBlock(blocksDDIronOre, classOf[ItemHardOre], "ironddore")
    OreDictionary.registerOre("oreDDIron", new ItemStack(blocksIronOre,1, 11))
    GameRegistry.registerBlock(blocksDDNickelOre, classOf[ItemHardOre], "nickelddore")
    OreDictionary.registerOre("oreDDNickel", new ItemStack(blocksDDNickelOre,1, 11))
    GameRegistry.registerBlock(blocksDDGoldOre, classOf[ItemHardOre], "goldddore")
    OreDictionary.registerOre("oreDDGold", new ItemStack(blocksDDGoldOre,1, 11))
    GameRegistry.registerBlock(blocksDDCopperOre, classOf[ItemHardOre], "copperddore")
    OreDictionary.registerOre("oreDDCopper", new ItemStack(blocksDDCopperOre,1, 11))
    GameRegistry.registerBlock(blocksDDTinOre, classOf[ItemHardOre], "tinddore")
    OreDictionary.registerOre("oreDDTin", new ItemStack(blocksDDTinOre,1, 11))
    GameRegistry.registerBlock(blocksDDSilverOre, classOf[ItemHardOre], "silverddore")
    OreDictionary.registerOre("oreDDSilver", new ItemStack(blocksDDSilverOre,1, 11))
    GameRegistry.registerBlock(blocksDDLeadOre, classOf[ItemHardOre], "leadddore")
    OreDictionary.registerOre("oreDDLead", new ItemStack(blocksDDLeadOre,1, 11))
    GameRegistry.registerBlock(blocksDDAluminumOre, classOf[ItemHardOre], "aluminumddore")
    OreDictionary.registerOre("oreDDAluminum", new ItemStack(blocksDDAluminumOre,1, 11))
    OreDictionary.registerOre("oreDDAluminium", new ItemStack(blocksDDAluminumOre, 1, 11))
    GameRegistry.registerBlock(blocksDDOsmiumOre, classOf[ItemHardOre], "osmiumddore")
    OreDictionary.registerOre("oreDDOsmium", new ItemStack(blocksDDOsmiumOre, 1, 11))

    GameRegistry.registerBlock(blocksDDRedstoneOre, classOf[ItemHardOre], "redstoneddore")
    OreDictionary.registerOre("oreDDRedstone", new ItemStack(blocksDDRedstoneOre,1, 11))
    GameRegistry.registerBlock(blocksDDLapisOre, classOf[ItemHardOre], "lapisddore")
    OreDictionary.registerOre("oreDDLapis", new ItemStack(blocksDDLapisOre,1, 11))
    GameRegistry.registerBlock(blocksDDElectrotineOre, classOf[ItemHardOre], "electrotineddore")
    OreDictionary.registerOre("oreDDElectrotine", new ItemStack(blocksDDElectrotineOre,1, 11))
    GameRegistry.registerBlock(blocksDDDiamondOre, classOf[ItemHardOre], "diamondddore")
    OreDictionary.registerOre("oreDDDiamond", new ItemStack(blocksDDDiamondOre,1, 11))
    GameRegistry.registerBlock(blocksDDEmeraldOre, classOf[ItemHardOre], "emeraldddore")
    OreDictionary.registerOre("oreDDEmerald", new ItemStack(blocksDDEmeraldOre,1, 11))
    GameRegistry.registerBlock(blocksDDCertusQuartzOre, classOf[ItemHardOre], "certusquartzddore")
    OreDictionary.registerOre("oreDDCertusQuartz", new ItemStack(blocksDDCertusQuartzOre, 1, 11))
    GameRegistry.registerBlock(blocksDDCoalOre, classOf[ItemHardOre], "coalddore")
    OreDictionary.registerOre("oreDDCoal", new ItemStack(blocksDDCoalOre, 1, 7))
    //GameRegistry.registerBlock(blocksDDChargedCertusQuartzOre, classOf[ItemHardOre], "chargedcertusquartzddore")
    //OreDictionary.registerOre("oreDDChargedCertusQuartz", new ItemStack(blocksDDChargedCertusQuartzOre, 1, 12))


  }

}
