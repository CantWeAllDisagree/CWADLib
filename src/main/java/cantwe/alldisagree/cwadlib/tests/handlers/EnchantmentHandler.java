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
package cantwe.alldisagree.cwadlib.tests.handlers;

import cantwe.alldisagree.cwadlib.CWADLibMain;
import cantwe.alldisagree.cwadlib.tests.enchantment.ConccusionEnchantment;
import cantwe.alldisagree.cwadlib.tests.enchantment.GravityEnchantment;
import cantwe.alldisagree.cwadlib.tests.enchantment.GroundedEdgeEnchantment;
import cantwe.alldisagree.cwadlib.tests.enchantment.ReturnEnchantment;
import cantwe.alldisagree.cwadlib.tests.enchantment.ThrowEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentHandler {

	public static final Enchantment THROW = Registry.register(Registry.ENCHANTMENT, new Identifier(CWADLibMain.ModID, "throw"), new ThrowEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
	public static final Enchantment GROUNDEDEDGE = Registry.register(Registry.ENCHANTMENT, new Identifier(CWADLibMain.ModID, "groundededge"), new GroundedEdgeEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));
	public static final Enchantment CONCCUSION = Registry.register(Registry.ENCHANTMENT, new Identifier(CWADLibMain.ModID, "conccusion"), new ConccusionEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
	public static final Enchantment GRAVITY = Registry.register(Registry.ENCHANTMENT, new Identifier(CWADLibMain.ModID, "gravity"), new GravityEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
	public static final Enchantment RETURN = Registry.register(Registry.ENCHANTMENT, new Identifier(CWADLibMain.ModID, "return"), new ReturnEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
	
	public static void registerEnchantments() {}
}
