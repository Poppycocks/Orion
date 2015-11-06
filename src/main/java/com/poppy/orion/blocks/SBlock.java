package com.poppy.orion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;


public class SBlock extends Block {

    public SBlock(Material mat)
    {
        super(mat);
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.addAll(getSubBlocks(p_149666_1_, p_149666_2_));
    }

    public List<ItemStack> getSubBlocks(Item item, CreativeTabs tab)
    {
        List<ItemStack> l = new LinkedList<ItemStack>();
        l.add(new ItemStack(item, 1, 0));
        return l;

    }


}
