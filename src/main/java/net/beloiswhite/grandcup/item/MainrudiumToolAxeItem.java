
package net.beloiswhite.grandcup.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.beloiswhite.grandcup.itemgroup.TabItemGroup;
import net.beloiswhite.grandcup.GrandcupModElements;

@GrandcupModElements.ModElement.Tag
public class MainrudiumToolAxeItem extends GrandcupModElements.ModElement {
	@ObjectHolder("grandcup:mainrudium_tool_axe")
	public static final Item block = null;

	public MainrudiumToolAxeItem(GrandcupModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 900;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 18;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MainrudiumItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TabItemGroup.tab)) {
		}.setRegistryName("mainrudium_tool_axe"));
	}
}
