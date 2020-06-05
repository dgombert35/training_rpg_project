package com.rpg.classesManipulation;

import java.util.ArrayList;
import java.util.List;

import com.rpg.armory.Armory;
import com.rpg.armory.Weapon;
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

public class ThisIsChoiceClass {
	
	private Armory armory = new Armory();
	private List<Weapon> weapons = new ArrayList<Weapon>();
	
	public Armory getArmory() {
		return armory;
	}

	public void setArmory(Armory armory) {
		this.armory = armory;
	}
	
	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	public Warrior thisIsWarrior(String str) {
		Warrior warrior = new Warrior(str);
		System.out.println(warrior);

		if (warrior.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(warrior));
			warrior.chooseWeaponFrom(weapons);
		}
		return warrior;
	}
	
	public Hunter thisIsHunter(String str) {
		Hunter hunter = new Hunter(str);
		System.out.println(hunter);

		if (hunter.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(hunter));
			hunter.chooseWeaponFrom(weapons);
		}
		return hunter;
	}
	
	public Priest thisIsPriest(String str) {
		Priest priest = new Priest(str);
		System.out.println(priest);

		if (priest.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(priest));
			priest.chooseWeaponFrom(weapons);
		}
		return priest;
	}
	
	public Magus thisIsMagus(String str) {
		Magus magus = new Magus(str);
		System.out.println(magus);

		if (magus.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(magus));
			magus.chooseWeaponFrom(weapons);
		}
		return magus;
	}
	
	public Monk thisIsMonk(String str) {
		Monk monk = new Monk(str);
		System.out.println(monk);

		if (monk.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(monk));
			monk.chooseWeaponFrom(weapons);
		}
		return monk;
	}
	
	public DemonHunter thisIsDemonHunter(String str) {
		DemonHunter demonHunter = new DemonHunter(str);
		System.out.println(demonHunter);

		if (demonHunter.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(demonHunter));
			demonHunter.chooseWeaponFrom(weapons);
		}
		return demonHunter;
	}
	
	public Paladin thisIsPaladin(String str) {
		Paladin paladin = new Paladin(str);
		if (paladin.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(paladin));
			paladin.chooseWeaponFrom(weapons);
		}
		return paladin;

	}
	
	public Thief thisIsThief(String str) {
		Thief thief = new Thief(str);
		System.out.println(thief);

		if (thief.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(thief));
			thief.chooseWeaponFrom(weapons);
		}
		return thief;
	}
	
	public Shaman thisIsShaman(String str) {
		Shaman shaman = new Shaman(str);
		System.out.println(shaman);

		if (shaman.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(shaman));
			shaman.chooseWeaponFrom(weapons);
		}
		return shaman;
	}
	
	public Warlock thisIsWarlock(String str) {
		Warlock warlock = new Warlock(str);
		System.out.println(warlock);

		if (warlock.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(warlock));
			warlock.chooseWeaponFrom(weapons);
		}
		return warlock;
	}
	
	public Druid thisIsDruid(String str) {
		Druid druid = new Druid(str);
		System.out.println(druid);

		if (druid.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(druid));
			druid.chooseWeaponFrom(weapons);
		}
		return druid;
	}
	
	public DeathKnight thisIsDeathKnight(String str) {
		DeathKnight deathKnight = new DeathKnight(str);
		System.out.println(deathKnight);

		if (deathKnight.getWeapon() == null) {

			setWeapons(armory.WeaponsWithClassName(deathKnight));
			deathKnight.chooseWeaponFrom(weapons);
		}
		return deathKnight;
	}

}
