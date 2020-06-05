package com.rpg.classesManipulation;

import java.util.List;

import com.rpg.armory.Weapon;
import com.rpg.classesOfRpg.Warrior;
import com.rpg.inventory.Inventory;
import com.rpg.stat.PlayerStatisticsMotorCalculation;
import com.rpg.stat.Stat;
import com.rpg.store.IEquipment;
import com.rpg.textSyntaxes.SyntaxsText;

public abstract class RpgClasse implements IWarrior<IEquipment> {

	protected String name;
	protected Weapon weapon;
	protected Stat playerState = new Stat();
	protected IEquipment equipment;
	protected ClassTypeEnum classType;
	protected PlayerStatisticsMotorCalculation playerStatsMotor = new PlayerStatisticsMotorCalculation();
	protected Inventory inventory = new Inventory();

	protected int levelsDifference;
	protected String getInformations = "";

	private int resultBattle;

	public RpgClasse(String name) {
		this.name = name;
		playerState.playerStatInit();
		int lifePointsPlayerInit = playerStatsMotor.playerLifePointsInit(getClass().getSimpleName());
		playerState.setLifePoints(lifePointsPlayerInit);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Weapon getWeapon() {
		return this.weapon;
	}

	@Override
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public IEquipment getEquipment() {
		return this.equipment;
	}

	@Override
	public void setEquipment(IEquipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public int getDifferenceBetweenLevels() {
		return levelsDifference;
	}

	public Stat getPlayerStat() {
		return playerState;
	}

	public String getGetInformations() {
		return getInformations;
	}

	public void setGetInformations(String getInformations) {
		this.getInformations = getInformations;
	}

	public int getResultBattle() {
		return resultBattle;
	}

	public void setResultBattle(int resultBattle) {
		this.resultBattle = resultBattle;
	}		

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public abstract void chooseWeaponFrom(List<Weapon> weapons);

	@Override
	public abstract void attack(String monsterType, int lifePointsMonster, int expMonster);

	@Override
	public void defense(int damage) {
		int playerDefense = playerState.getDefense();
		
		int valueBetweenPlayerDefenseDamage = damage - playerDefense;//dommage déduit de la défense
		int lifePointsRest = playerState.getLifePoints() - valueBetweenPlayerDefenseDamage ;
		
		playerState.setLifePoints(lifePointsRest);

	}

	protected void statAttackWithWeaponEquipment(IEquipment weapon) {
		playerState.setAttack(playerState.getAttack());
	}

	public int playerLevel(int exp) {
		return playerStatsMotor.playerLevelCalculation(exp, getDifferenceBetweenLevels());
	}

	public void toStringStatsInformations() {
		/*
		 * TODO jouer sur la list et la parcourir
		 * shield implements IEquipment
		 */
		playerStatsMotor.statPayerCalculationWithEquipment(weapon, equipment, getPlayerStat(), getName());
	}

	public void instanceOfWeapon(List<Weapon> weapons, Class<?> weaponObject) {
		for (Weapon iWeapon : weapons) {
			if (weaponObject.isInstance(iWeapon)) {
				weapon = iWeapon;
				setWeaponAndWeaponStats(weapon);
				inventory.putWeaponInInventory(weapon);
				
			}
		}
	}
	
	private void setWeaponAndWeaponStats(IEquipment weapon) {
		this.setEquipment(weapon);
		this.statAttackWithWeaponEquipment(weapon);
		this.toStringStatsInformations();
	}

	@Override
	public String toString() {
		String getStyle = "";
		getInformations = ConstantsRpgClassEnum.RPGCLASSEEMPTYHANDS.getValue() + SyntaxsText.lineSeparator;

		/*
		 * TODO getstyle modification depend of class
		 */
		if (getClass() == Warrior.class) {
			getStyle = ConstantsRpgClassEnum.RPGCLASSPROUD.getValue();
		} else {
			getStyle = ConstantsRpgClassEnum.RPGCLASSAGILE.getValue();
		}

		if (weapon != null) {
			getInformations = ConstantsRpgClassEnum.RPGCLASSEQUIPED.getValue() + weapon.getName()
					+ ConstantsRpgClassEnum.RPGCLASSGRIEVES.getValue() + weapon.getWeaponDamage()
					+ ConstantsRpgClassEnum.RPGCLASSDAMAGES.getValue() + SyntaxsText.lineSeparator;

			return name + ConstantsRpgClassEnum.RPGCLASSIS.getValue() + getStyle + getClass().getSimpleName()
					+ getInformations;
		} else {
			return name + ConstantsRpgClassEnum.RPGCLASSIS.getValue() + getStyle + getClass().getSimpleName()
					+ getInformations;
		}
	}

}
