package com.rpg.classesOfRpg;

import java.util.List;

import com.rpg.armory.Weapon;
import com.rpg.classesManipulation.ConstantClassEnum;
import com.rpg.classesManipulation.RpgClasse;
//Store
import com.rpg.store.IEquipment;

//Common
import com.rpg.textSyntaxes.ConstantCommunEnum;
import com.rpg.textSyntaxes.SyntaxsText;
import com.rpg.commun.ObjectsListChoice;

//Weapons
import com.rpg.weapons.Bow;
import com.rpg.weapons.CrossBow;

public class Hunter extends RpgClasse {

	private IEquipment object;
	// TODO a changer car faut un calcul selon ce qui est porté

	public Hunter(String name) {
		super(name);
	}

	@Override
	public void chooseWeaponFrom(List<Weapon> weapons) {

		if (getWeapon() == null) {
			ObjectsListChoice weaponListChoice = new ObjectsListChoice();
			weaponListChoice.weaponListChoice(weapons);
		}

		int choice = SyntaxsText.sc.nextInt();

		weaponInstanceOf(weapons, choice);

		System.out.println(super.toString());
	}

	private void weaponInstanceOf(List<Weapon> weapons, int choice) {
		switch (choice) {
		case 1:
			instanceOfWeapon(weapons, Bow.class);
			break;
		case 2:
			instanceOfWeapon(weapons, CrossBow.class);
			break;
		default:
			chooseWeaponFrom(weapons);
			break;
		}
	}

	@Override
	public void chooseEquipmentFrom(List<IEquipment> objects, int choice) {

		object = objects.get(choice);
		super.setEquipment(object);
		super.toStringStatsInformations();

	}

	/*
	 * TODO check if it is possible to put this method on RpgClass.java
	 */

	@Override
	public void attack(String monsterType, int lifePointsMonster, int expByMonster) {

		System.out.println(name + ConstantClassEnum.ATTACK.getValue() + monsterType + ConstantClassEnum.WITH.getValue()
				+ weapon.getClass().getSimpleName() + ConstantClassEnum.GIVEIT.getValue() + weapon.getWeaponDamage()
				+ ConstantClassEnum.DAMAGES.getValue());

		super.setResultBattle(lifePointsMonster - weapon.getWeaponDamage());

		if (super.getResultBattle() <= 0) {
			System.out.println(ConstantClassEnum.KILLMONSTER.getValue() + expByMonster
					+ ConstantClassEnum.EXPERIMENTSPOINTS.getValue());
			playerLevel(expByMonster);
		} else {
			System.out.println(ConstantClassEnum.MONSTERGET.getValue() + super.getResultBattle()
					+ ConstantCommunEnum.LIFEPOINTS.getValue());
		}
	}

}
