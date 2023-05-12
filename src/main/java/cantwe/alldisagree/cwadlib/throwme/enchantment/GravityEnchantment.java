/*               | Copyright (c) 2023 CantWeAllDisagree |
|
|   This program is free software: you can redistribute it and/or modify
|   it under the terms of the GNU Affero General Public License as published by
|   the Free Software Foundation, version 3 of the License, or
|   (at your option) any later version.
|
|   This program is distributed in the hope that it will be useful,
|   but WITHOUT ANY WARRANTY; without even the implied warranty of
|   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
|   GNU Affero General Public License for more details.
*/
package cantwe.alldisagree.cwadlib.throwme.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class GravityEnchantment extends Enchantment{
	public GravityEnchantment(Enchantment.Rarity rarityIn, EquipmentSlot... slots) {
		  super(rarityIn, EnchantmentTarget.WEAPON, slots);
	}

	public int getMinPower(int enchantmentLevel) {
	      return 25;
	}

	public int getMaxPower(int enchantmentLevel) {
	      return 50;
	}

	public int getMaxLevel() {
	      return 1;
	}

	public boolean isTreasure() {
		 return true;
	}

	public boolean isCursed() {
		 return true;
	}

	@Override
	/*public boolean isAcceptableItem(ItemStack stack) {
		   boolean enchantAll = ConfigRegistry.COMMON.getConfig().enchantments.enchantAllWeapons;
		   boolean isAxe = stack.getItem() instanceof AxeItem;
		   boolean canApply = super.isAcceptableItem(stack);
		   return (isAxe || canApply || enchantAll) && ConfigRegistry.COMMON.getConfig().enchantments.enableGravity;
	}*/
	public boolean isAcceptableItem(ItemStack stack) {
		boolean enchantAll = false;
		boolean isAxe = stack.getItem() instanceof AxeItem;
		boolean canApply = super.isAcceptableItem(stack);
		return (isAxe || canApply);
	}
}
