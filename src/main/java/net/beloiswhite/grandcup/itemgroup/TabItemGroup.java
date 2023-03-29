
package net.beloiswhite.grandcup.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.beloiswhite.grandcup.item.GctabItem;
import net.beloiswhite.grandcup.GrandcupModElements;

@GrandcupModElements.ModElement.Tag
public class TabItemGroup extends GrandcupModElements.ModElement {
	public TabItemGroup(GrandcupModElements instance) {
		super(instance, 106);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GctabItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
