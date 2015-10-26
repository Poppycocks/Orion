package com.poppy.orion.blocks

import java.util.Random
import com.enderio.core.common.util.OreDictionaryHelper
import com.poppy.orion.{Config, Blocks}
import net.minecraft.block.BlockTorch
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World


class BlockTorchLit extends BlockTorch {

  val name: String = "torchlit"
  setBlockName(s"orion.$name")
  setBlockTextureName(s"orion:$name")
  setCreativeTab(CreativeTabs.tabDecorations)
  this.setTickRandomly(false)
  setLightLevel(0.9375F)

  override def onBlockAdded(world: World, x: Int, y:Int, z:Int): Unit ={
    if (Config.torchBurnTime!=0)world.scheduleBlockUpdate(x, y, z, this, (Config.torchBurnTime * 0.9).toInt)
  }

  override def updateTick(world: World, x: Int, y: Int, z:Int, rand: Random): Unit ={
    val meta = world.getBlockMetadata(x,y,z)
    world.setBlock(x,y,z,Blocks.blockTorchSmoldering, meta, 2)
    world.playSoundEffect(x,y,z,"random.fizz", 1.0F, rand.nextFloat() * 0.1F + 0.9F)
  }

  override def onBlockActivated(world: World , x: Int, y: Int,z: Int, player: EntityPlayer, metadata: Int, sideX: Float, sideY: Float, sideZ: Float): Boolean = {
    val stack: ItemStack = player.getCurrentEquippedItem()
    val meta = world.getBlockMetadata(x,y,z)
    if (stack != null && (OreDictionaryHelper.getOreNames(stack) contains("itemIgniter"))) {
      stack.damageItem(1, player)
      world.setBlock(x, y, z, Blocks.blockTorchLit, meta, 2)
      world.playSoundEffect(x, y, z, "random.fizz", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F)
    }
    true
  }

  override def getItemDropped(x$1: Int, x$2: java.util.Random, x$3: Int): Item = {
    Item.getItemFromBlock(Blocks.blockTorchUnlit)
  }
}
