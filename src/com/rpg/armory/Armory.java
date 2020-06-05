package com.rpg.armory;

import java.util.ArrayList;
import java.util.List;

import com.rpg.shields.ConstantsShieldsEnum;
import com.rpg.shields.Shield;
import com.rpg.store.IEquipment;
import com.rpg.weapons.Axe;
import com.rpg.weapons.Bow;
import com.rpg.weapons.ConstantsWeaponsEnum;
import com.rpg.weapons.CrossBow;
import com.rpg.weapons.Dagger;
import com.rpg.weapons.Glaive;
import com.rpg.weapons.Mace;
import com.rpg.weapons.RodeMagic;
import com.rpg.weapons.Spear;
import com.rpg.weapons.Stick;
import com.rpg.weapons.Sword;
import com.rpg.classesManipulation.IWarrior;
import com.rpg.classesOfRpg.DeathKnight;
import com.rpg.classesOfRpg.DemonHunter;
import com.rpg.classesOfRpg.Druid;
import com.rpg.classesOfRpg.Hunter;
import com.rpg.classesOfRpg.Magus;
import com.rpg.classesOfRpg.Monk;
import com.rpg.classesOfRpg.Paladin;
import com.rpg.classesOfRpg.Priest;
import com.rpg.classesOfRpg.Shaman;
import com.rpg.classesOfRpg.Thief;
import com.rpg.classesOfRpg.Warlock;
import com.rpg.classesOfRpg.Warrior;

public class Armory {

	public <E> List<Weapon> WeaponsWithClassName(IWarrior<E> rpgClass) {

		List<Weapon> weapons = new ArrayList<Weapon>();

		if (rpgClass.getClass() == Warrior.class) {
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
		} else if (rpgClass.getClass() == Hunter.class) {			weapons.add(new Bow(ConstantsWeaponsEnum.BOWARIELNAME.getValue()));
			weapons.add(new CrossBow(ConstantsWeaponsEnum.CROSSBOW.getValue()));
		} else if (rpgClass.getClass() == Priest.class) {
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
			weapons.add(new RodeMagic(ConstantsWeaponsEnum.RODEMAGIC.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
		} else if (rpgClass.getClass() == Magus.class) {
			weapons.add(new RodeMagic(ConstantsWeaponsEnum.RODEMAGIC.getValue()));
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
		} else if (rpgClass.getClass() == Monk.class) {
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
		} else if (rpgClass.getClass() == DemonHunter.class) {
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Glaive(ConstantsWeaponsEnum.GLAIVE.getValue()));
		} else if (rpgClass.getClass() == Paladin.class) {
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Spear(ConstantsWeaponsEnum.SPEAR.getValue()));
		} else if (rpgClass.getClass() == Thief.class) {
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
		} else if (rpgClass.getClass() == Shaman.class) {
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
		} else if (rpgClass.getClass() == Warlock.class) {
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new RodeMagic(ConstantsWeaponsEnum.RODEMAGIC.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
		} else if (rpgClass.getClass() == Druid.class) {
			weapons.add(new Dagger(ConstantsWeaponsEnum.DAGGERHALLEBARDE.getValue()));
			weapons.add(new Stick(ConstantsWeaponsEnum.STICKS.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
		} else if (rpgClass.getClass() == DeathKnight.class) {
			weapons.add(new Axe(ConstantsWeaponsEnum.AXEBLACKCLEAVERNAME.getValue()));
			weapons.add(new Sword(ConstantsWeaponsEnum.SWORDEXCALIBURNAME.getValue()));
			weapons.add(new Mace(ConstantsWeaponsEnum.MACESNASHSHAB.getValue()));
		}

		return weapons;
	}

	public <E> List<IEquipment> ShieldsWithClassName(IWarrior<E> rpgClass) {
		List<IEquipment> shields = new ArrayList<IEquipment>();

		if (rpgClass.getClass() == Warrior.class) {
			shields.add(new Shield(ConstantsShieldsEnum.MeshShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.SteelShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.StoneShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.DragonSlayerShield.toString()));
		} else if (rpgClass.getClass() == Hunter.class) {
			shields.add(new Shield(ConstantsShieldsEnum.MeshShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.LeatherShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.StoneShield.toString()));

		} else if (rpgClass.getClass() == Priest.class) {
			shields.add(new Shield(ConstantsShieldsEnum.LeatherShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.CelestialShield.toString()));

		} else if (rpgClass.getClass() == Magus.class) {
			shields.add(new Shield(ConstantsShieldsEnum.MeshShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.WaterShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.LightningShield.toString()));

		} else if (rpgClass.getClass() == Monk.class) {
			shields.add(new Shield(ConstantsShieldsEnum.CelestialShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.WoodShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.SteelShield.toString()));

		} else if (rpgClass.getClass() == DemonHunter.class) {
			shields.add(new Shield(ConstantsShieldsEnum.DragonSlayerShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.CelestialShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.VolcanicShield.toString()));

		} else if (rpgClass.getClass() == Paladin.class) {
			shields.add(new Shield(ConstantsShieldsEnum.StoneShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.MeshShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.SteelShield.toString()));

		} else if (rpgClass.getClass() == Thief.class) {
			shields.add(new Shield(ConstantsShieldsEnum.MeshShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.SteelShield.toString()));

		} else if (rpgClass.getClass() == Shaman.class) {
			shields.add(new Shield(ConstantsShieldsEnum.VolcanicShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.ArcaneShield.toString()));

		} else if (rpgClass.getClass() == Warlock.class) {
			shields.add(new Shield(ConstantsShieldsEnum.StoneShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.VolcanicShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.ArcaneShield.toString()));

		} else if (rpgClass.getClass() == Druid.class) {
			shields.add(new Shield(ConstantsShieldsEnum.ArcaneShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.VolcanicShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.WaterShield.toString()));

		} else if (rpgClass.getClass() == DeathKnight.class) {
			shields.add(new Shield(ConstantsShieldsEnum.DragonSlayerShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.SteelShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.LightningShield.toString()));
			shields.add(new Shield(ConstantsShieldsEnum.VolcanicShield.toString()));

		}

		return shields;
	}

}