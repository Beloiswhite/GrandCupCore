
package net.beloiswhite.grandcup.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.SlabType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.beloiswhite.grandcup.itemgroup.TabItemGroup;
import net.beloiswhite.grandcup.GrandcupModElements;

import java.util.List;
import java.util.Collections;

@GrandcupModElements.ModElement.Tag
public class AbyssWoodSlabBlock extends GrandcupModElements.ModElement {
	@ObjectHolder("grandcup:abyss_wood_slab")
	public static final Block block = null;

	public AbyssWoodSlabBlock(GrandcupModElements instance) {
		super(instance, 92);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(TabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.8f, 5.699999999999999f).setLightLevel(s -> 0));
			setRegistryName("abyss_wood_slab");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}
	}
}
