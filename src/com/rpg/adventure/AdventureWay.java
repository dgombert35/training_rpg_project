package com.rpg.adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.rpg.building.Building;
import com.rpg.classesManipulation.RpgClasse;
import com.rpg.commun.ObjectsListChoice;
import com.rpg.monsters.Type;
import com.rpg.shields.ConstantsShieldsEnum;
import com.rpg.store.ConstantsClothEnum;
import com.rpg.treasure.Treasure;
import com.rpg.weapons.ConstantsWeaponsEnum;
//Common
import com.rpg.textSyntaxes.ConstantCommunEnum;
import com.rpg.textSyntaxes.ConstantCommunNumberEnum;
import com.rpg.textSyntaxes.SyntaxsText;

public class AdventureWay {

	private String wayChoice = "";
	private String eventOnTheWay = "";
	private String title = "";
	private RpgClasse rpgClasse;
	private int wayNumber;
	private Building building = new Building();
	private Battle battle = new Battle();

	// boolean variable for to know the end of adventure
	private boolean adventureContinue = true;

	public AdventureWay(RpgClasse rpgClass) {
		this.rpgClasse = rpgClass;
	}

	public AdventureWay() {
	}

	public RpgClasse getRpgClasse() {
		return rpgClasse;
	}

	public void choiceWay(Scanner sc) {

		System.out.println(ConstantAdventureWayEnum.WAYTOCHOOSE.getValue());
		int choiceWayValue[] = new int[5];
		for (int i = 0; i < choiceWayValue.length; i++) {
			title(i);
			choiceWayValue[i] = i + 1;
			if (i != 0) {
				System.out.println(i + ConstantCommunEnum.ONEPOINTS.getValue() + title);
			}
		}

		wayNumber = sc.nextInt();

		title(wayNumber);
		wayChoice = ConstantAdventureWayEnum.WAYNUMBERTOCHOOSE.getValue() + wayNumber
				+ ConstantCommunEnum.TWOPOINTS.getValue() + title + SyntaxsText.lineSeparator;
		System.out.println(wayChoice);

		while (adventureContinue) {
			if (wayNumber >= 1 && wayNumber <= 5) {
				choiceDirection(sc);

			} else {
				choiceDirection(sc);

			}
		}
	}

	private String title(int i) {
		switch (i) {
		case 1:
			title = ConstantAdventureWayEnum.WAYBEGINNNINGBEAUTIFULADVENTURE.getValue();
			break;
		case 2:
			title = ConstantAdventureWayEnum.WAYOFBRAV.getValue();
			break;
		case 3:
			title = ConstantAdventureWayEnum.WAYGOODLUCK.getValue();
			break;
		case 4:
			title = ConstantAdventureWayEnum.WAYGOODBY.getValue();
			break;
		}
		return title;
	}

	private void choiceDirection(Scanner sc) {

		choiceDirectionMouvement(sc);

		// TODO management of back way choice move
		switch (wayNumber) {
		case 1:
		case 2:
		case 3:
		case 4:
			randomWay(wayNumber, sc);
			break;
		case 5:
			rpgClasse.getInventory().checkInventory();
			break;
		case 6:
			theEndWay();
			break;
		default:
			choiceDirection(sc);
			break;
		}
	}

	public void choiceDirectionMouvement(Scanner sc) {

		System.out.println(ConstantAdventureWayEnum.CHOICETODO.getValue());
		System.out.println(ConstantCommunNumberEnum.CHOICEONE.getValue() + Mouvements.Back);
		System.out.println(ConstantCommunNumberEnum.CHOICETWO.getValue() + Mouvements.Right);
		System.out.println(ConstantCommunNumberEnum.CHOICETHREE.getValue() + Mouvements.Left);
		System.out.println(ConstantCommunNumberEnum.CHOICEFOUR.getValue() + Mouvements.Straight);
		System.out.println(ConstantCommunNumberEnum.CHOICEFIVE.getValue() + Mouvements.CheckInventory);
		System.out.println(
				ConstantCommunNumberEnum.CHOICESIX.getValue() + ConstantAdventureWayEnum.STOPADVENTURE.getValue());
		wayNumber = sc.nextInt();

	}

	private void randomWay(int number, Scanner sc) {
		Random random = new Random();
		number = random.nextInt(3);
		number = 2;
		switch (number) {
		case 0:
			battleWay();
			break;
		case 1:
			treasureWay(sc);
			break;
		case 2:
			buildingWay(sc);
			break;
		case 3:
			nothingWay(sc);
			break;
		}
	}

	private void battleWay() {
		eventOnTheWay = ConstantAdventureWayEnum.EVENTMONSTERFIGHT.getValue();
		System.out.println(eventOnTheWay);
		battle.monsterBattle(rpgClasse, null);
	}

	private void treasureWay(Scanner sc) {
		eventOnTheWay = ConstantAdventureWayEnum.EVENTFINDTREASURE.getValue();
		System.out.println(eventOnTheWay);
		userChoiceToDoWithTreasure(sc);
	}

	private void buildingWay(Scanner sc) {

		eventOnTheWay = ConstantAdventureWayEnum.EVENTBUILDING.getValue();
		System.out.println(eventOnTheWay);
		building.userFrontToTheBuilding(sc, rpgClasse);
	}

	private void nothingWay(Scanner sc) {
		eventOnTheWay = ConstantAdventureWayEnum.EVENTPLAYERCONTINUEADVENTURE.getValue();
		System.out.println(eventOnTheWay);
		choiceDirectionMouvement(sc);
	}

	private void theEndWay() {
		eventOnTheWay = ConstantAdventureWayEnum.EVENTENDADVENTURE.getValue();
		System.out.println(eventOnTheWay);
		adventureContinue = false;
	}

	private void userChoiceToDoWithTreasure(Scanner sc) {

		/*
		 * TODO à déplacer dans le trésor
		 */
		System.out.println(ConstantAdventureWayEnum.CHOICETODO.getValue());
		System.out.println(ConstantAdventureWayEnum.OPENTREASURECHOICE.getValue());
		System.out.println(ConstantAdventureWayEnum.CONTINUECHOICE.getValue());

		Treasure treasure = new Treasure();
		String treasureContent = new String();

		int treasureNumbers = treasure.treasuresNumbers();

		if (treasureNumbers == 0) {
			System.out.println(ConstantAdventureWayEnum.OPENTREASUREEVENTNOTHING.getValue());
		}

		int userChoice = sc.nextInt();

		switch (userChoice) {
		case 1:

			for (int i = 1; i < treasureNumbers; i++) {
				treasureContent = treasure.treasureOpen();
				randomTreasureContent(treasureContent);
			}

			break;
		case 2:
			choiceDirectionMouvement(sc);
			break;

		default:
			userChoiceToDoWithTreasure(sc);
			break;
		}
	}

	private void randomTreasureContent(String treasureContent) {
		
		/*
		 * TODO in treasure class
		 */

		ObjectsListChoice objectListChoice = new ObjectsListChoice();
		List<String> monsterList = new ArrayList<String>();
		List<String> equipmentList = new ArrayList<String>();

		monsterList.addAll(objectListChoice.enumArrayNotGetValue(Type.class));
		equipmentList.addAll(objectListChoice.enumValuesStringArrayWithGetValue(ConstantsClothEnum.class));
		equipmentList.addAll(objectListChoice.enumArrayNotGetValue(ConstantsShieldsEnum.class));
		equipmentList.addAll(objectListChoice.enumArrayNotGetValue(ConstantsWeaponsEnum.class));

		for (int i = 0; i < monsterList.size(); i++) {
			if (monsterList.get(i).equals(treasureContent)) {
				battle.monsterBattle(rpgClasse, Type.valueOf(treasureContent));
			}
		}

		for (int i = 0; i < equipmentList.size(); i++) {
			if (equipmentList.get(i).equals(treasureContent)) {
				System.out.println("You find a " + treasureContent);
				System.out.println("Do you want to equip it or to put it in your bag?");
			}
		}
	}

}
