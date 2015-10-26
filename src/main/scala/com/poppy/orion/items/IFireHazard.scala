package com.poppy.orion.items

import com.poppy.orion.{Cnst, Config}
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.world.World

trait IFireHazard extends itemSimple{
  var cntdwn:Int = Cnst.rand.nextInt(Config.fireHazardBurnChanceHigh - Config.fireHazardBurnChanceLow) + Config.fireHazardBurnChanceLow

  override def onUpdate(stack: ItemStack, world: World, player: Entity, slot: Int, b: Boolean){
      if (!world.isRemote && slot > 8) {
        cntdwn -= 1
        if (cntdwn <= 1){

          cntdwn = Cnst.rand.nextInt(Config.fireHazardBurnChanceHigh - Config.fireHazardBurnChanceLow) + Config.fireHazardBurnChanceLow
          player.setFire(Config.fireHazardBurnLenght)
        }
      }
  }

}
