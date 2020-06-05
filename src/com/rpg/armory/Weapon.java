package com.rpg.armory;

import com.rpg.stat.Stat;
import com.rpg.store.IEquipment;

public class Weapon implements IEquipment {

	protected String weaponName;
	protected int weaponDamage;


	public Weapon(String name) {
		this.weaponName = name;
	}

	@Override
	public String getName() {
		return weaponName;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	@Override
	public void getEquipmentStatusModification(Stat playerStat) {
	}

	
	/**
	 * 
	 * @param playerStat
	 * @param percent
	 * @param getParameterStat
	 * @param calculType
	 * 
	 * method give infos stats about weapon
	 * stat depends of weapon class
	 */

	@Override
	public int setEquipmentStat(Stat playerStat, double percent, int getParameterStat, String calculType) {
		getParameterStat = psmc.getWeaponStatResult(playerStat.getLevel(), percent, getParameterStat, calculType);
		return getParameterStat;
	};
	

}