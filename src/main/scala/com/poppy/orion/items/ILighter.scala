package com.poppy.orion.items

import com.poppy.orion.Cnst
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.world.World

trait ILighter extends itemSimple{

  override def onItemUse(stack: ItemStack, player: EntityPlayer, world: World,x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float):Boolean = {
    var nx =x
    var ny =y
    var nz =z
    side match {
      case 0 => ny= y-1
      case 1 => ny= y+1
      case 2 => nz= z-1
      case 3 => nz= z+1
      case 4 => nx= x-1
      case 5 => nx= x+1
      case _ => return false
    }

    if (!player.canPlayerEdit(nx, ny, nz, side, stack)) return false
    else if (world.isAirBlock(nx, ny, nz)) {
      world.playSoundEffect(nx + 0.5D, ny + 0.5D, nz + 0.5D, "fireIgnite", 1.0F, Cnst.rand.nextFloat() * 0.4F + 0.8F)
      world.setBlock(nx, ny, nz, Blocks.fire)
      stack.damageItem(1, player)
      return true
    }
    return false
  }

}
