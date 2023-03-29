
package net.beloiswhite.grandcup.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.beloiswhite.grandcup.itemgroup.TabItemGroup;
import net.beloiswhite.grandcup.GrandcupModElements;

@GrandcupModElements.ModElement.Tag
public class MainrudiumToolShovelItem extends GrandcupModElements.ModElement {
	@ObjectHolder("grandcup:mainrudium_tool_shovel")
	public static final Item block = null;

	public MainrudiumToolShovelItem(GrandcupModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 600;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 1f;
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
		}.setRegistryName("mainrudium_tool_shovel"));
	}
}
