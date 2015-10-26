package com.poppy.orion.items

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class itemSimple(name:String, Tab: CreativeTabs, mStackSize: Int, mDamage: Int) extends Item {
  setUnlocalizedName(s"orion.$name")
  setTextureName(s"orion:$name")
  setCreativeTab(Tab)
  maxStackSize = mStackSize
  setMaxDamage(mDamage)

}