package com.poppy.orion.blocks

import java.util.Random

import com.enderio.core.common.util.OreDictionaryHelper
import com.poppy.orion.{Blocks, Config}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.BlockTorch
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World

class BlockTorchR(name: String, xvariant: Byte) extends BlockTorch {
  val variant = List(Blocks.blockTorchLit, Blocks.blockTorchSmoldering, Blocks.blockTorchUnlit)
  val xrand = new Random

  setBlockName(s"orion.$name")
  setBlockTextureName(s"orion:$name")
  setCreativeTab(CreativeTabs.tabDecorations)
  this.setTickRandomly(false)
  xvariant match {
    case 0 => setLightLevel(0.9375F)
    case 1 => setLightLevel(0.875F)
    case _ => setLightLevel(0.0F)
  }


  override def onBlockAdded(world: World, x: Int, y:Int, z:Int): Unit ={
    if (Config.torchBurnTime!=0) xvariant match {
      case 0 => world.scheduleBlockUpdate (x, y, z, this, (Config.torchBurnTime * 0.9).toInt)
      case 1 => world.scheduleBlockUpdate (x, y, z, this, (Config.torchBurnTime * 0.1).toInt)
      case _ =>
    }
  }

  override def updateTick(world: World, x: Int, y: Int, z:Int, rand: Random): Unit ={
    if (xvariant != 2) {
      val meta = world.getBlockMetadata(x, y, z)
      world.setBlock(x, y, z, variant(xvariant + 1), meta, 2)
      world.playSoundEffect(x, y, z, "random.fizz", 1.0F, rand.nextFloat() * 0.1F + 0.9F)
    }
  }

  override def onBlockActivated(world: World , x: Int, y: Int,z: Int, player: EntityPlayer, metadata: Int, sideX: Float, sideY: Float, sideZ: Float): Boolean = {
    val stack: ItemStack = player.getCurrentEquippedItem()
    val meta = world.getBlockMetadata(x,y,z)
    if (stack != null && (OreDictionaryHelper.getOreNames(stack) contains("itemIgniter"))) {
      if (!stack.isItemStackDamageable && stack.getMaxStackSize>1) stack.stackSize-=1 else stack.damageItem(1, player)
      world.setBlock(x, y, z, variant.head, meta, 2)
      world.playSoundEffect(x, y, z, "random.fizz", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F)
    }
    true
  }

  override def getItemDropped(x$1: Int, x$2: java.util.Random, x$3: Int): Item = {
    Item.getItemFromBlock(variant(2))
  }

  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) = {
    var meta: Int = world.getBlockMetadata(x, y, z)
    var r: Int = rand.nextInt(4)
    var d0 = (x + 0.5F).toDouble
    var d1 = (y + 0.7F).toDouble
    var d2 = (z + 0.5F).toDouble
    val d3 = 0.2199999988079071D
    val d4 = 0.27000001072883606D
    meta match{
      case 1 => d0 -= d4; d1 += d3
      case 2 => d0 += d4; d1 += d3
      case 3 => d1 += d3; d2 -= d4
      case 4 => d1 += d3; d2 += d4
      case _ =>
    }
    xvariant match {
      case 0 => world.spawnParticle("smoke", d0, d1, d2, 0D, 0D, 0D); world.spawnParticle("flame", d0, d1, d2, 0D, 0D, 0D)
      case 1 => world.spawnParticle("smoke", d0, d1, d2, 0D, 0D, 0D); if (r == 2) world.spawnParticle("flame", d0, d1, d2, 0D, 0D, 0D)
      case _ =>
    }
  }


  }
