package com.poppy.orion

import com.poppy.orion.blocks._
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
  val blockGlowTorch = new BlockTorch {setStepSound(Block.soundTypeWood) setBlockName("orion.glowtorch") setBlockTextureName("orion:glowtorchlit"); override def randomDisplayTick(w: World, x: Int, y: Int, z: Int, r: java.util.Random) = null}
  //val blockGlowTorchLit = new BlockGlowTorch(true){setStepSound(Block.soundTypeWood) setBlockName("orion.glowtorchlit") setBlockTextureName("orion:glowtorchlit")}
  //val blockGlowTorchUnlit = new BlockGlowTorch(false){setStepSound(Block.soundTypeWood) setBlockName("orion.glowtorchunlit") setBlockTextureName("orion:glowtorchunlit") setCreativeTab(CreativeTabs.tabRedstone) setLightLevel(1.0F)}
  val blockAutoMining = new Block(Material.dragonEgg) {setStepSound(Block.soundTypeStone) setBlockName("orion.mininglevelauto") setBlockTextureName("minecraft:bedrock")}
  val blockEndGame = new Block(Material.dragonEgg) {setStepSound(Block.soundTypeStone) setBlockName("orion.mininglevelend") setBlockTextureName("minecraft:bedrock")}

  val blocksIronOre = new BlockHardOre("iron")

  def init(){
    GameRegistry.registerBlock(blockTorchLit, "torchlit")
    OreDictionary.registerOre("blockTorch", blockTorchLit)

    GameRegistry.registerBlock(blockTorchSmoldering, "torchsmoldering")
    GameRegistry.registerBlock(blockTorchUnlit, "torchunlit")
    GameRegistry.registerBlock(blockGlowComposite, "glowcomposite")
    GameRegistry.registerBlock(blockGlowTorch,"glowtorch")
    GameRegistry.registerBlock(blockAutoMining, "automining")
    GameRegistry.registerBlock(blockEndGame, "endgame")
    //GameRegistry.registerBlock(blockGlowTorchLit, "glowtorchlit")
    //OreDictionary.registerOre("itemLight", blockGlowTorchLit)
    //GameRegistry.registerBlock(blockGlowTorchUnlit, "glowtorchunlit")
    GameRegistry.registerBlock(blocksIronOre, "ironore")
    OreDictionary.registerOre("oreIron", new ItemStack(blocksIronOre,1, OreDictionary.WILDCARD_VALUE))
  }

}
