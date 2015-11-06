package com.poppy.orion

import com.poppy.orion.blocks._
import com.poppy.orion.items.ItemHardOre
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockTorch}
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.oredict.OreDictionary


object Blocks {
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

  //Overworld hard ore blocks
  val blocksIronOre = new BlockHardOre("iron",1) {drops = List( (Items.itemIronChunk, 0), (Items.itemNickelChunk, 20), (Items.itemUncutPeridot, 3) )}
  val blocksNickelOre = new BlockHardOre("nickel",1) {drops = List( (Items.itemNickelChunk, 0), (Items.itemIronChunk, 20))}
  val blocksGoldOre = new BlockHardOre("gold",1) {drops = List((Items.itemGoldChunk, 0), (Items.itemCopperChunk, 20))}
  val blocksCopperOre = new BlockHardOre("copper",1) {drops = List((Items.itemCopperChunk, 0), (Items.itemGoldChunk, 20))}
  val blocksTinOre = new BlockHardOre("tin",1) {drops = List((Items.itemTinChunk, 0))}
  val blocksSilverOre = new BlockHardOre("silver",1) {drops = List((Items.itemSilverChunk, 0), (Items.itemLeadChunk, 40))}
  val blocksLeadOre = new BlockHardOre("lead",1) {drops = List((Items.itemLeadChunk, 0), (Items.itemSilverChunk, 40))}
  val blocksAluminumOre = new BlockHardOre("aluminum",1) {drops = List((Items.itemAluminumChunk, 0),(Items.itemIronChunk, 10), (Items.itemUncutRuby, 3), (Items.itemUncutSapphire, 3))}

  val blocksRedstoneOre = new BlockHardOre("redstone",1) {drops = List((Items.itemRedStone, 0))}
  val blocksLapisOre = new BlockHardOre("lapis",1) {drops = List((Items.itemLapisChunk, 0))}
  val blocksElectrotineOre = new BlockHardOre("electrotine",1) {drops = List((Items.itemElectrotineChunk, 0))}
  val blocksDiamondOre = new BlockHardOre("diamond",1) {drops = List((Items.itemUncutDiamond, 0))}
  val blocksEmeraldOre = new BlockHardOre("emerald",1) {drops = List((Items.itemUncutEmerald, 0))}
  //Nether hard ore blocks
  val blocksNetherIronOre = new BlockHardOre("netheriron",1) {drops = List( (Items.itemIronChunk, 0), (Items.itemNickelChunk, 20), (Items.itemUncutPeridot, 4) )}
  val blocksNetherNickelOre = new BlockHardOre("nethernickel",1) {drops = List( (Items.itemNickelChunk, 0), (Items.itemIronChunk, 20))}
  val blocksNetherGoldOre = new BlockHardOre("nethergold",1) {drops = List((Items.itemGoldChunk, 0), (Items.itemCopperChunk, 20))}
  val blocksNetherCopperOre = new BlockHardOre("nethercopper",1) {drops = List((Items.itemCopperChunk, 0), (Items.itemGoldChunk, 20))}
  val blocksNetherTinOre = new BlockHardOre("nethertin",1) {drops = List((Items.itemTinChunk, 0))}
  val blocksNetherSilverOre = new BlockHardOre("nethersilver",1) {drops = List((Items.itemSilverChunk, 0), (Items.itemLeadChunk, 40))}
  val blocksNetherLeadOre = new BlockHardOre("netherlead",1) {drops = List((Items.itemLeadChunk, 0), (Items.itemSilverChunk, 40))}
  val blocksNetherAluminumOre = new BlockHardOre("netheraluminum",1) {drops = List((Items.itemAluminumChunk, 0),(Items.itemIronChunk, 10), (Items.itemUncutRuby, 4), (Items.itemUncutSapphire, 4))}
  val blocksNetherOsmiumOre = new BlockHardOre("netherosmium", 1) {drops = List ((Items.itemOsmiumChunk, 0))}

  val blocksNetherRedstoneOre = new BlockHardOre("netherredstone",1) {drops = List((Items.itemRedStone, 0))}
  val blocksNetherLapisOre = new BlockHardOre("netherlapis",1) {drops = List((Items.itemLapisChunk, 0))}
  val blocksNetherElectrotineOre = new BlockHardOre("netherelectrotine",1) {drops = List((Items.itemElectrotineChunk, 0))}
  val blocksNetherDiamondOre = new BlockHardOre("netherdiamond",1) {drops = List((Items.itemUncutDiamond, 0))}
  val blocksNetherQuartzOre = new BlockHardOre("netherquartz", 1) {drops = List((Items.itemUncutNetherQuartz, 0))}
  //DD hard ore blocks
  val blocksDDIronOre = new BlockHardOre("ddiron",1) {drops = List( (Items.itemIronChunk, 0), (Items.itemNickelChunk, 20), (Items.itemUncutPeridot, 5) )}
  val blocksDDNickelOre = new BlockHardOre("ddnickel",1) {drops = List( (Items.itemNickelChunk, 0), (Items.itemIronChunk, 20))}
  val blocksDDGoldOre = new BlockHardOre("ddgold",1) {drops = List((Items.itemGoldChunk, 0), (Items.itemCopperChunk, 20))}
  val blocksDDCopperOre = new BlockHardOre("ddcopper",1) {drops = List((Items.itemCopperChunk, 0), (Items.itemGoldChunk, 20))}
  val blocksDDTinOre = new BlockHardOre("ddtin",1) {drops = List((Items.itemTinChunk, 0))}
  val blocksDDSilverOre = new BlockHardOre("ddsilver",1) {drops = List((Items.itemSilverChunk, 0), (Items.itemLeadChunk, 40))}
  val blocksDDLeadOre = new BlockHardOre("ddlead",1) {drops = List((Items.itemLeadChunk, 0), (Items.itemSilverChunk, 40))}
  val blocksDDAluminumOre = new BlockHardOre("ddaluminum",1) {drops = List((Items.itemAluminumChunk, 0),(Items.itemIronChunk, 10), (Items.itemUncutRuby, 5), (Items.itemUncutSapphire, 5))}
  val blocksDDOsmiumOre = new BlockHardOre("ddosmium", 1) {drops = List((Items.itemOsmiumChunk, 0))}

  val blocksDDRedstoneOre = new BlockHardOre("ddredstone",1) {drops = List((Items.itemRedStone, 0))}
  val blocksDDLapisOre = new BlockHardOre("ddlapis",1) {drops = List((Items.itemLapisChunk, 0))}
  val blocksDDElectrotineOre = new BlockHardOre("ddelectrotine",1) {drops = List((Items.itemElectrotineChunk, 0))}
  val blocksDDDiamondOre = new BlockHardOre("dddiamond",1) {drops = List((Items.itemUncutDiamond, 0))}
  val blocksDDEmeraldOre = new BlockHardOre("ddemerald",1) {drops = List((Items.itemUncutEmerald, 0))}
  val blocksDDCertusQuartzOre = new BlockHardOre("ddcertusquartz", 1) {drops = List((Items.itemUncutCertusQuartz, 0))}
  val blocksDDChargedCertusQuartzOre = new BlockHardOre("ddchargedcertusquartz", 1) {drops = List((Items.itemUncutChargedCertusQuartz, 0))}

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


    //Overworld Ores
    GameRegistry.registerBlock(blocksIronOre, classOf[ItemHardOre], "ironore")
    OreDictionary.registerOre("oreIron", new ItemStack(blocksIronOre,1, 7))
    GameRegistry.registerBlock(blocksNickelOre, classOf[ItemHardOre], "nickelore")
    OreDictionary.registerOre("oreNickel", new ItemStack(blocksNickelOre,1, 7))
    GameRegistry.registerBlock(blocksGoldOre, classOf[ItemHardOre], "goldore")
    OreDictionary.registerOre("oreGold", new ItemStack(blocksGoldOre,1, 7))
    GameRegistry.registerBlock(blocksCopperOre, classOf[ItemHardOre], "copperore")
    OreDictionary.registerOre("oreCopper", new ItemStack(blocksCopperOre,1, 7))
    GameRegistry.registerBlock(blocksTinOre, classOf[ItemHardOre], "tinore")
    OreDictionary.registerOre("oreTin", new ItemStack(blocksTinOre,1, 7))
    GameRegistry.registerBlock(blocksSilverOre, classOf[ItemHardOre], "silverore")
    OreDictionary.registerOre("oreSilver", new ItemStack(blocksSilverOre,1, 7))
    GameRegistry.registerBlock(blocksLeadOre, classOf[ItemHardOre], "leadore")
    OreDictionary.registerOre("oreLead", new ItemStack(blocksLeadOre,1, 7))
    GameRegistry.registerBlock(blocksAluminumOre, classOf[ItemHardOre], "aluminumore")
    OreDictionary.registerOre("oreAluminum", new ItemStack(blocksAluminumOre,1, 7))
    OreDictionary.registerOre("oreAluminium", new ItemStack(blocksAluminumOre, 1, 7))
    GameRegistry.registerBlock(blocksRedstoneOre, classOf[ItemHardOre], "redstoneore")
    OreDictionary.registerOre("oreRedstone", new ItemStack(blocksRedstoneOre,1, 7))
    GameRegistry.registerBlock(blocksLapisOre, classOf[ItemHardOre], "lapisore")
    OreDictionary.registerOre("oreLapis", new ItemStack(blocksLapisOre,1, 7))
    GameRegistry.registerBlock(blocksElectrotineOre, classOf[ItemHardOre], "electrotineore")
    OreDictionary.registerOre("oreElectrotine", new ItemStack(blocksElectrotineOre,1, 7))
    GameRegistry.registerBlock(blocksDiamondOre, classOf[ItemHardOre], "diamondore")
    OreDictionary.registerOre("oreDiamond", new ItemStack(blocksDiamondOre,1, 7))
    GameRegistry.registerBlock(blocksEmeraldOre, classOf[ItemHardOre], "emeraldore")
    OreDictionary.registerOre("oreEmerald", new ItemStack(blocksEmeraldOre,1, 7))
   //Nether Ores
    GameRegistry.registerBlock(blocksNetherIronOre, classOf[ItemHardOre], "ironnetherore")
    OreDictionary.registerOre("oreNetherIron", new ItemStack(blocksNetherIronOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherNickelOre, classOf[ItemHardOre], "nickelnetherore")
    OreDictionary.registerOre("oreNetherNickel", new ItemStack(blocksNetherNickelOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherGoldOre, classOf[ItemHardOre], "goldnetherore")
    OreDictionary.registerOre("oreNetherGold", new ItemStack(blocksNetherGoldOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherCopperOre, classOf[ItemHardOre], "coppernetherore")
    OreDictionary.registerOre("oreNetherCopper", new ItemStack(blocksNetherCopperOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherTinOre, classOf[ItemHardOre], "tinnetherore")
    OreDictionary.registerOre("oreNetherTin", new ItemStack(blocksNetherTinOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherSilverOre, classOf[ItemHardOre], "silvernetherore")
    OreDictionary.registerOre("oreNetherSilver", new ItemStack(blocksNetherSilverOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherLeadOre, classOf[ItemHardOre], "leadnetherore")
    OreDictionary.registerOre("oreNetherLead", new ItemStack(blocksNetherLeadOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherAluminumOre, classOf[ItemHardOre], "aluminumnetherore")
    OreDictionary.registerOre("oreNetherAluminum", new ItemStack(blocksNetherAluminumOre, 1, 9))
    OreDictionary.registerOre("oreNetherAluminium", new ItemStack(blocksNetherAluminumOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherOsmiumOre, classOf[ItemHardOre], "osmiumnetherore")
    OreDictionary.registerOre("oreNetherOsmium", new ItemStack(blocksNetherOsmiumOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherRedstoneOre, classOf[ItemHardOre], "redstonenetherore")
    OreDictionary.registerOre("oreNetherRedstone", new ItemStack(blocksNetherRedstoneOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherLapisOre, classOf[ItemHardOre], "lapisnetherore")
    OreDictionary.registerOre("oreNetherLapis", new ItemStack(blocksNetherLapisOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherElectrotineOre, classOf[ItemHardOre], "electrotinenetherore")
    OreDictionary.registerOre("oreNetherElectrotine", new ItemStack(blocksNetherElectrotineOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherDiamondOre, classOf[ItemHardOre], "diamondnetherore")
    OreDictionary.registerOre("oreNetherDiamond", new ItemStack(blocksNetherDiamondOre, 1, 9))
    GameRegistry.registerBlock(blocksNetherQuartzOre, classOf[ItemHardOre], "netherquartznetherore")
    OreDictionary.registerOre("oreNetherQuartz", new ItemStack(blocksNetherQuartzOre, 1, 9))
    //Ores Deep Dark
    GameRegistry.registerBlock(blocksDDIronOre, classOf[ItemHardOre], "ironddore")
    OreDictionary.registerOre("oreDDIron", new ItemStack(blocksIronOre,1, 12))
    GameRegistry.registerBlock(blocksDDNickelOre, classOf[ItemHardOre], "nickelddore")
    OreDictionary.registerOre("oreDDNickel", new ItemStack(blocksDDNickelOre,1, 12))
    GameRegistry.registerBlock(blocksDDGoldOre, classOf[ItemHardOre], "goldddore")
    OreDictionary.registerOre("oreDDGold", new ItemStack(blocksDDGoldOre,1, 12))
    GameRegistry.registerBlock(blocksDDCopperOre, classOf[ItemHardOre], "copperddore")
    OreDictionary.registerOre("oreDDCopper", new ItemStack(blocksDDCopperOre,1, 12))
    GameRegistry.registerBlock(blocksDDTinOre, classOf[ItemHardOre], "tinddore")
    OreDictionary.registerOre("oreDDTin", new ItemStack(blocksDDTinOre,1, 12))
    GameRegistry.registerBlock(blocksDDSilverOre, classOf[ItemHardOre], "silverddore")
    OreDictionary.registerOre("oreDDSilver", new ItemStack(blocksDDSilverOre,1, 12))
    GameRegistry.registerBlock(blocksDDLeadOre, classOf[ItemHardOre], "leadddore")
    OreDictionary.registerOre("oreDDLead", new ItemStack(blocksDDLeadOre,1, 12))
    GameRegistry.registerBlock(blocksDDAluminumOre, classOf[ItemHardOre], "aluminumddore")
    OreDictionary.registerOre("oreDDAluminum", new ItemStack(blocksDDAluminumOre,1, 12))
    OreDictionary.registerOre("oreDDAluminium", new ItemStack(blocksDDAluminumOre, 1, 12))
    GameRegistry.registerBlock(blocksDDOsmiumOre, classOf[ItemHardOre], "osmiumddore")
    OreDictionary.registerOre("oreDDOsmium", new ItemStack(blocksDDOsmiumOre, 1, 12))

    GameRegistry.registerBlock(blocksDDRedstoneOre, classOf[ItemHardOre], "redstoneddore")
    OreDictionary.registerOre("oreDDRedstone", new ItemStack(blocksDDRedstoneOre,1, 12))
    GameRegistry.registerBlock(blocksDDLapisOre, classOf[ItemHardOre], "lapisddore")
    OreDictionary.registerOre("oreDDLapis", new ItemStack(blocksDDLapisOre,1, 12))
    GameRegistry.registerBlock(blocksDDElectrotineOre, classOf[ItemHardOre], "electrotineddore")
    OreDictionary.registerOre("oreDDElectrotine", new ItemStack(blocksDDElectrotineOre,1, 12))
    GameRegistry.registerBlock(blocksDDDiamondOre, classOf[ItemHardOre], "diamondddore")
    OreDictionary.registerOre("oreDDDiamond", new ItemStack(blocksDDDiamondOre,1, 12))
    GameRegistry.registerBlock(blocksDDEmeraldOre, classOf[ItemHardOre], "emeraldddore")
    OreDictionary.registerOre("oreDDEmerald", new ItemStack(blocksDDEmeraldOre,1, 12))
    GameRegistry.registerBlock(blocksDDCertusQuartzOre, classOf[ItemHardOre], "certusquartzddore")
    OreDictionary.registerOre("oreDDCertusQuartz", new ItemStack(blocksDDCertusQuartzOre, 1, 12))
    GameRegistry.registerBlock(blocksDDChargedCertusQuartzOre, classOf[ItemHardOre], "chargedcertusquartzddore")
    OreDictionary.registerOre("oreDDChargedCertusQuartz", new ItemStack(blocksDDChargedCertusQuartzOre, 1, 12))


  }

}
