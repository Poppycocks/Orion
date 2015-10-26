package com.poppy.orion.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.util.AxisAlignedBB
import net.minecraft.world.World

class BlockLight extends Block(Material.air){

  setBlockName("lightblock")
  setBlockTextureName("lightblock")
  setTickRandomly(false)
  setLightLevel(0.9375F)

  override def getCollisionBoundingBoxFromPool(world: World ,x: Int, y:Int, z: Int):AxisAlignedBB = null
  override def isOpaqueCube(): Boolean = false
  override def renderAsNormalBlock(): Boolean = false
  override def canPlaceBlockAt(worldn: World, x: Int, y: Int, z: Int): Boolean = true

  override def onBlockAdded(w: World, x: Int, y: Int, z: Int){
    w.scheduleBlockUpdate(x,y,z,this,20)
  }



}
