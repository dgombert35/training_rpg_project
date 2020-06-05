package com.rpg.building;

import java.util.Random;
import java.util.Scanner;

import com.rpg.classesManipulation.RpgClasse;
import com.rpg.store.Store;
import com.rpg.textSyntaxes.ConstantCommunEnum;
import com.rpg.textSyntaxes.SyntaxsText;

public class Building {

	private String name;
	private static Store store = new Store();

	public Building() {
	}

	public Building(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void userFrontToTheBuilding(Scanner sc, RpgClasse rpgClass) {

		randomBuildingName();

		System.out.println(ConstantBuildingEnum.BUILDINGINTRODUCTION.getValue() + name
				+ ConstantBuildingEnum.BUILDINGENTERQUESTION.getValue());
		System.out.println(ConstantBuildingEnum.BUILDINGENTERYES.getValue());
		System.out.println(ConstantBuildingEnum.BUILDINGENTERNO.getValue());

		int enterBuildingUserChoice = sc.nextInt();

		switch (enterBuildingUserChoice) {
		case 1:
			userEnterInTheBuilding(rpgClass);
			break;
		case 2:
			userNotEnter();
			break;

		default:
			userFrontToTheBuilding(sc, rpgClass);
			break;
		}
	}

	private void userNotEnter() {
		/*
		 * TODO appeler la méthode continueWay() dans adventure
		 */
	}

	private void userEnterInTheBuilding(RpgClasse rpgClass) {

		switch (ConstantBuildingEnum.valueOf(name.toUpperCase())) {
		case STORE:
			System.out.println(ConstantBuildingEnum.BUILDINGSTOREACCESS.getValue() + SyntaxsText.lineSeparator);
			store.storeEquipmentList(SyntaxsText.sc, rpgClass);
			break;
		case CHURCH:
			/*
			 * TODO menu
			 * sauvegarde => il faut une BDD pour le faire
			 * retrouver ses points de vie
			 * 
			 */
			System.err.println(ConstantCommunEnum.NOTWORKFORNOW.getValue());
			System.out.println(SyntaxsText.lineSeparator);
			break;
		case TAVERN:
			System.err.println(ConstantCommunEnum.NOTWORKFORNOW.getValue());
			System.out.println(SyntaxsText.lineSeparator);
			break;
		case HOUSE:
			/*
			 * TODO menu 
			 * repos = retrouver ses points de vie
			 * stock = ce qui peut avoir dans l'inventaire
			 *
			 */
			System.err.println(ConstantCommunEnum.NOTWORKFORNOW.getValue());
			System.out.println(SyntaxsText.lineSeparator);
			break;
		default:
			break;
		}
	};

	private String randomBuildingName() {

		Random random = new Random();
		int number = random.nextInt(3);
		number = 0; // on force le numéro pour test ici entrer danns le batiment voulu
		switch (number) {
		case 0:
			name = ConstantBuildingEnum.BUILDINGSTORE.getValue();
			break;
		case 1:
			name = ConstantBuildingEnum.BUILDINGCHURCH.getValue();
			break;
		case 2:
			name = ConstantBuildingEnum.BUILDINGTAVERN.getValue();
			break;
		case 3:
			name = ConstantBuildingEnum.BUILDINGHOUSE.getValue();
			break;
		}
		return name;
	}

}
