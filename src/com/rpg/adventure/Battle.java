package com.rpg.adventure;

import com.rpg.classesManipulation.RpgClasse;
import com.rpg.monsters.Monster;
import com.rpg.monsters.Type;
import com.rpg.textSyntaxes.SyntaxsText;

public class Battle {
	
	private String typeMonster;
	private int lifePointsMonster;
	private int expPointsMonster;
	private int powerMonster;
	private int resultBattle;
	private Type monsterOfBattle;
	

	public void monsterBattle(RpgClasse rpgClass, Type battleMonster) {

		if(battleMonster != null) {
			monsterOfBattle = battleMonster;
		} else {
			monsterOfBattle = Type.getRandomMonsterType();
		}
		

		Monster monster = new Monster(monsterOfBattle);
		int playerLevel = rpgClass.getPlayerStat().getLevel();
		monster.monsterStatAccordingToPlayerAndMonsterTypeLevel(playerLevel, monster.getType());
		System.out.println(monster.getMonsterDescription());

		System.out.println(ConstantBattleEnum.CANTRUNFIGHT.getValue()+ SyntaxsText.lineSeparator);

		// TODO faut-il stocker les valeurs du monstre dans des variables?
		// => ou passer le monstre en parametre? => lien // classes?

		while (monster.getLifePoints() > 0 && rpgClass.getPlayerStat().getLifePoints() > 0) {
			monsterStatistics(monster);

			rpgClass.attack(typeMonster, lifePointsMonster, expPointsMonster);
			resultBattle = rpgClass.getResultBattle();
			monster.setLifePoints(resultBattle);

			if (resultBattle > 0) {
				monster.attack();
				rpgClass.defense(powerMonster);
			}
		}

	}

	private void monsterStatistics(Monster monster) {
		typeMonster = monster.getType().toString();
		lifePointsMonster = monster.getLifePoints();
		expPointsMonster = monster.getExperimentsPoints();
		powerMonster = monster.getPower();
	}

}
