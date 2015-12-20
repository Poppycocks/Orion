package com.poppy.orion.blocks

import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon
import net.minecraft.world.{Explosion, World}
import net.minecraftforge.common.util.ForgeDirection
import net.minecraftforge.event.ForgeEventFactory

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

class BlockHardOre(name: String, miningLevel: Int, defaultLevel: Int) extends SBlock(Material.rock){
  setBlockName(s"orion.${name}ore")
  setHardness(2.0F)
  setResistance(6.0F)
  setStepSound(Block.soundTypeStone)
  setHarvestLevel("pickaxe",miningLevel)


  val rand = new util.Random()
  var icons: List[IIcon] = List()
  var drops: List[(Item, Int)] = List()
  var dropBase: Int = 1
  var fortuneBase: Int = 1
  var fortuneVariance: Int = 1

  override def canDropFromExplosion(explosion: Explosion) = false
  @SideOnly(Side.CLIENT)
  override def registerBlockIcons(reg: IIconRegister): Unit = icons = List.tabulate(12)(n => reg.registerIcon(s"orion:${name}ore$n"))
  override def damageDropped(meta: Int) = meta
  override def quantityDropped(meta: Int, fortune: Int, random: java.util.Random): Int = {if (fortune == 0) dropBase else dropBase + (fortune - 1)*fortuneBase + (if (fortuneVariance>0)rand.nextInt(fortuneVariance+1) else 0)}
  @SideOnly(Side.CLIENT)
  override def getIcon(side: Int, meta: Int): IIcon = icons(if (meta <= 11) meta else 11)

  @SideOnly(Side.CLIENT)
  override def getSubBlocks(item: Item , tab: CreativeTabs): java.util.List[ItemStack] = {
    val l: List[ItemStack] = List (new ItemStack(item, 1, defaultLevel))
    l.asJava
  }


  def getDrops(world: World, x: Int, y: Int, z: Int, fortune: Int): util.ArrayList[ItemStack] = {
    var actualDropsList: ArrayBuffer[ItemStack] = ArrayBuffer[ItemStack]()
    var dropsLeft: Int = quantityDropped(0, fortune, rand)
    if (drops != null && 75 >= rand.nextInt(101)) {
      actualDropsList += new ItemStack(drops(0)._1, 1)
      dropsLeft -= 1
    }

    if (drops != null && drops.length > 1) for (drop <- drops.tail){
        if (dropsLeft>0 && drop._2 >= rand.nextInt(101)) {actualDropsList += new ItemStack(drop._1, 1); dropsLeft-=1}
    }
    if (drops != null && dropsLeft>0) actualDropsList += new ItemStack(drops.head._1, dropsLeft)
    new util.ArrayList[ItemStack](actualDropsList.asJava)
  }

  override def getDrops(world: World, x: Int, y: Int, z: Int, metadata:Int, fortune: Int): util.ArrayList[ItemStack] = {
    val actualDropsList = ArrayBuffer.fill(metadata){getDrops(world,x,y,z,fortune).asScala}.flatten
    new util.ArrayList[ItemStack](actualDropsList.asJava)
  }

  /*override def harvestBlock (world : World, player : EntityPlayer, x : Int, y : Int, z : Int, meta : Int) {
    player.addStat(StatList.mineBlockStatArray(Block.getIdFromBlock(this)), 1)
    player.addExhaustion(0.025F)
    if (this.canSilkHarvest(world, player, x, y, z, meta) && EnchantmentHelper.getSilkTouchModifier(player)) {
      val items : util.ArrayList[ItemStack] = new util.ArrayList[ItemStack]
      items.add(createStackedBlock(meta))
      ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, meta, 0, 1.0f, true, player)
      this.dropBlockAsItem(world, x, y, z, createStackedBlock(meta))
    }
    else {
      harvesters.set(player)
      val i1 : Int = EnchantmentHelper.getFortuneModifier(player)
      this.dropBlockAsItem(world, x, y, z, meta, i1)
      harvesters.set(null)
    }
  } */

  /*override def breakBlock(world: World, x: Int, y: Int, z: Int, block: Block, meta: Int): Unit = {
     if (meta > 0) world.setBlock(x,y,z,block,meta-1,2)
  } */

  override def dropBlockAsItemWithChance(world : World, x : Int, y : Int, z : Int, meta : Int, chance : Float, fortune : Int) {
    if (!world.isRemote && !world.restoringBlockSnapshots) {
      var items: util.ArrayList[ItemStack] = getDrops(world, x, y, z, fortune)

      val ch = ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, meta, fortune, chance, false, harvesters.get)
      if (meta > 0) world.setBlock(x,y,z,this,meta-1,2)
      import scala.collection.JavaConversions._
      for (item <- items) {
        if (world.rand.nextFloat <= ch) {
          dropBlockAsItem(world, x, y, z, item)
        }
      }
    }
  }

  override protected def dropBlockAsItem(world : World, x : Int, y : Int, z : Int, stack : ItemStack) {
    if (!world.isRemote && world.getGameRules.getGameRuleBooleanValue("doTileDrops") && !world.restoringBlockSnapshots) {
      if (captureDrops.get.booleanValue()) {
        capturedDrops.get.add(stack)
        return
      }
      val directions = ForgeDirection.VALID_DIRECTIONS.tail ++ List(ForgeDirection.DOWN)
      for (direction <- directions)
        if (!world.getBlock(x+direction.offsetX, y+direction.offsetY, z+direction.offsetZ).isNormalCube || direction==ForgeDirection.DOWN){
          val spawnOffset = List(direction.offsetX, direction.offsetY, direction.offsetZ).map(i => if (i == 0) rand.nextFloat()*0.7D+0.15D else i.toDouble * 0.6D)
          val entityitem: EntityItem = new EntityItem(world, x.toDouble + spawnOffset(0), y.toDouble + spawnOffset(1), z.toDouble + spawnOffset(2), stack)
          entityitem.delayBeforeCanPickup = 10
          world.spawnEntityInWorld(entityitem)
          return
      }
    }
  }

  override def removedByPlayer(world: World, player: EntityPlayer,x: Int, y: Int, z: Int, willHarvest: Boolean): Boolean = {
    if(player != null && player.capabilities.isCreativeMode) world.setBlockMetadataWithNotify(x, y, z, 0, 3)
    world.setBlockToAir(x,y,z)
  }

  override def onBlockExploded (world : World, x: Int, y: Int, z: Int, explosion : Explosion): Unit = {
    val meta = world.getBlockMetadata(x,y,z)
    if (!world.isRemote && !world.restoringBlockSnapshots){
      val drops = getDrops(world,x,y,z,meta,1).asScala
      for (drop <- drops) dropBlockAsItem(world, x, y, z, drop)
      world.setBlockToAir(x, y, z)
      onBlockDestroyedByExplosion(world, x, y, z, explosion)
    }
  }

}
