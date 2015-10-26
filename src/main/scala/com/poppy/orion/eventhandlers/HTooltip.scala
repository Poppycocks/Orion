package com.poppy.orion.eventhandlers


import com.enderio.core.common.Handlers.Handler
import com.poppy.orion.items.itemSimple
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.util.StatCollector
import net.minecraftforge.event.entity.player.ItemTooltipEvent

@Handler()
object HTooltip {
  @SubscribeEvent
  def onTooltip(event: ItemTooltipEvent)
  {
    if (event.itemStack != null && event.itemStack.getItem().isInstanceOf[itemSimple])
    {
      val unloc: String= event.itemStack.getUnlocalizedName() + ".tooltip.line"
      var lineNum: Int = 1
      while (StatCollector.canTranslate(unloc + lineNum))
      {
        event.toolTip.add(StatCollector.translateToLocal(unloc + lineNum))
        lineNum+=1
      }
    }
  }


}
