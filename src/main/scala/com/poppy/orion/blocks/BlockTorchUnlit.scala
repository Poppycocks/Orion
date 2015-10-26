package com.poppy.orion.blocks

import java.util.Random
import com.enderio.core.common.util.OreDictionaryHelper
import com.poppy.orion.Blocks
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.block.BlockTorch
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World


class BlockTorchUnlit extends BlockTorch {

  val name: String = "torchunlit"
  setBlockName(s"orion.$name")
	setBlockTextureName(s"orion:$name")
	setCreativeTab(CreativeTabs.tabDecorations)
  this.setTickRandomly(false)
  setLightLevel(0.0F)

  override def onBlockActivated(world: World , x: Int, y: Int,z: Int, player: EntityPlayer, metadata: Int, sideX: Float, sideY: Float, sideZ: Float): Boolean = {
    val meta = world.getBlockMetadata(x, y, z)
    val stack: ItemStack = player.getCurrentEquippedItem()
    if (stack != null && (OreDictionaryHelper.getOreNames(stack) contains("itemIgniter"))) {
      stack.damageItem(1, player);
      world.setBlock(x, y, z, Blocks.blockTorchLit, meta, 2);
      world.playSoundEffect(x, y, z, "random.fizz", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
    }
    true
  }

  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) = {}

}