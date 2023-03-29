
package net.beloiswhite.grandcup.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.beloiswhite.grandcup.itemgroup.TabItemGroup;
import net.beloiswhite.grandcup.GrandcupModElements;

@GrandcupModElements.ModElement.Tag
public class KorundPickaxeItem extends GrandcupModElements.ModElement {
	@ObjectHolder("grandcup:korund_pickaxe")
	public static final Item block = null;

	public KorundPickaxeItem(GrandcupModElements instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1100;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KorundIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TabItemGroup.tab)) {
		}.setRegistryName("korund_pickaxe"));
	}
}
