package com.rpg.classesManipulation;

import java.util.List;

import com.rpg.armory.Weapon;
import com.rpg.store.IEquipment;

public interface IWarrior<E> {
	Weapon getWeapon();
	void setWeapon(Weapon weapon);
	
	E getEquipment();
	void setEquipment(IEquipment equipment);

	String getName();

	int getDifferenceBetweenLevels();

	void chooseWeaponFrom(List<Weapon> weapons);
	
	void chooseEquipmentFrom(List<IEquipment> objects, int number);

	void attack(String monsterType, int lifePointsMonster, int expMonster);

	void defense(int damage);

	int playerLevel(int exp);
	
}
