package com.poppy.orion.blocks

import net.minecraft.block.{BlockFalling, Block}
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.world.IBlockAccess

class BlockGlowComposite extends BlockFalling(Material.sand){
  val name = "glowcomposite"

  setBlockName(s"orion.$name")
  setBlockTextureName(s"orion:$name")
  setCreativeTab(CreativeTabs.tabRedstone)
  setHardness(0.5F)
  setResistance(0.5F)
  setStepSound(Block.soundTypeSand)
  setHarvestLevel("shovel", 0)
  setLightLevel(1F)

  override def canProvidePower = true
  override def isProvidingWeakPower(p_149709_1_ : IBlockAccess, p_149709_2_ : Int, p_149709_3_ : Int, p_149709_4_ : Int, p_149709_5_ : Int): Int = 15

}
