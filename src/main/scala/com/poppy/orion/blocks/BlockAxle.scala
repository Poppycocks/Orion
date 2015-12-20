package com.poppy.orion.blocks

import com.poppy.orion.tileents.TEAxle
import net.minecraft.block.{ITileEntityProvider, Block}
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.{IBlockAccess, World}

class BlockAxle extends Block(Material.wood) with ITileEntityProvider{
  setBlockName(s"orion.axle")
  override def isOpaqueCube = false
  override def shouldSideBeRendered(iblockaccess: IBlockAccess, i:Int, j:Int, k:Int, l:Int):Boolean = {false}
  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity = new TEAxle
}
