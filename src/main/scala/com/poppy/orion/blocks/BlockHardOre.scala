package com.poppy.orion.blocks

import java.util

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon
import net.minecraft.world.{Explosion, World}

import scala.collection.JavaConverters._
import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.util.Random

class BlockHardOre(name: String, miningLevel: Int) extends SBlock(Material.rock){
  setBlockName(s"orion.${name}ore")
  setHardness(2.0F)
  setResistance(6.0F)
  setStepSound(Block.soundTypeStone)
  setHarvestLevel("pickaxe",miningLevel)


  val rand = new Random()
  var icons: List[IIcon] = List()
  var drops: List[(Item, Int)] = List()
  var defaultLevel: Int = 7
  var dropBase: Int = 1
  var fortuneBase: Int = 1
  var fortuneVariance: Int = 1

  override def canDropFromExplosion(explosion: Explosion) = false
  override def registerBlockIcons(reg: IIconRegister): Unit = icons = List.tabulate(12)(n => reg.registerIcon(s"orion:${name}ore$n"))
  override def damageDropped(meta: Int) = meta
  override def getIcon(side: Int, meta: Int): IIcon = icons(meta)

  override def getSubBlocks(item: Item , tab: CreativeTabs): java.util.List[ItemStack] = {
    val l: List[ItemStack] = List.tabulate(12)(n => new ItemStack(item, 1, n))
    l.asJava
  }

  override def getDrops(world: World, x: Int, y: Int, z: Int, metadata: Int, fortune: Int): util.ArrayList[ItemStack] = {
    var actualDropsList: ArrayBuffer[ItemStack] = ArrayBuffer[ItemStack]()
    var dropsLeft: Int = if (fortune <= 0) dropBase else dropBase + (fortune - 1)*fortuneBase + rand.nextInt(fortuneVariance)
    if (drops != null && drops.length > 1) for (drop <- drops.tail){
        if (dropsLeft>0 && rand.nextInt((100 / drop._2)-1)==0) {actualDropsList += new ItemStack(drop._1, 1); dropsLeft-=1}
    }
    if (drops != null && dropsLeft>0) actualDropsList += new ItemStack(drops.head._1, dropsLeft)
    new util.ArrayList[ItemStack](actualDropsList.asJava)
  }

  override def onBlockHarvested(world: World, x: Int, y: Int, z: Int, meta: Int, player: EntityPlayer): Unit ={
    if (meta>0) world.setBlock(x,y,z,this,meta-1,2)
  }

  override def onBlockDestroyedByExplosion (world : World, x: Int, y: Int, z: Int, explosion : Explosion): Unit = {
    val meta = world.getBlockMetadata(x,y,z)
    if (!world.isRemote && !world.restoringBlockSnapshots){
      var i = 0
      var drops: ListBuffer[ItemStack] = new ListBuffer()
      for (i <- i to meta) {
        drops ++= getDrops(world, x, y, z, i, 1).asScala
      }
      for (drop <- drops) dropBlockAsItem(world, x, y, z, drop)
    }
  }


}
