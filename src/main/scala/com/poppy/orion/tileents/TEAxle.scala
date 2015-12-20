package com.poppy.orion.tileents

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.{NetworkManager, Packet}
import net.minecraft.network.play.server.S35PacketUpdateTileEntity
import net.minecraft.tileentity.TileEntity

class TEAxle extends TileEntity{

  override def getDescriptionPacket: Packet = {
    new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, getNBTTagCompound)
  }

  def getNBTTagCompound: NBTTagCompound = {
    val tag = new NBTTagCompound()
    writeToNBT(tag)
    tag
  }

  override def onDataPacket(net: NetworkManager, packet: S35PacketUpdateTileEntity)= {
    super.onDataPacket(net, packet)
    val tag = packet.func_148857_g
    readFromNBT(tag)
  }

  override def writeToNBT(par1: NBTTagCompound): Unit = {
    super.writeToNBT(par1)
  }

  override def readFromNBT(par1: NBTTagCompound): Unit = {
    super.readFromNBT(par1)
  }

}
