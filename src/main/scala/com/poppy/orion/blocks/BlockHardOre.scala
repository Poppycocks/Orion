package com.poppy.orion.blocks

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import collection.JavaConverters._

import scala.collection.mutable.ListBuffer

class BlockHardOre(name: String) extends Block(Material.rock){
  setBlockName(s"orion.${name}Ore")
  setHardness(2.0F)
  setResistance(6.0F)
  setStepSound(Block.soundTypeStone)

  var icons: ListBuffer[IIcon] = ListBuffer()
  //var icons: List[IIcon] = List()

  override def registerBlockIcons(reg: IIconRegister): Unit = {
    val icons_inner: List[IIcon]

    def f(a:ListBuffer[IIcon], n: Int):IIcon = n match {
      case 11 => reg.registerIcon(s"orion:ore$name$n")
      case _ => f(a += reg.registerIcon(s"orion:ore$name$n"),n+1)
    }
    f(icons, 0)

  }

  override def getSubBlocks(item: Item , tab: CreativeTabs , list: java.util.List ): Unit = {
    val scalaList = list.asInstanceOf[java.util.List[ItemStack]].asScala
    for (i <- 0 to 3) scalaList += new ItemStack(item, 1, i)
  }

  override def getIcon(side: Int, meta: Int): IIcon = {
    icons(meta)
  }

}
