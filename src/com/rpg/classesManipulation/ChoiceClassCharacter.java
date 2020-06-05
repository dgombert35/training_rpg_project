package com.rpg.classesManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rpg.textSyntaxes.ConstantCommunNumberEnum;

public class ChoiceClassCharacter {

	private RpgClasse rpgClass;
	

	public RpgClasse getRpgClass() {
		return rpgClass;
	}

	public void setRpgClass(RpgClasse rpgClass) {
		this.rpgClass = rpgClass;
	}


	public RpgClasse classCharacterChoice(String str, Scanner sc) {
		characterClassChoice();
		ThisIsChoiceClass thisIsChoiceClasse = new ThisIsChoiceClass();

		int classCharacter = sc.nextInt();

		switch (classCharacter) {
		case 1:
			setRpgClass(thisIsChoiceClasse.thisIsWarrior(str));
			return rpgClass;
		case 2:
			setRpgClass(thisIsChoiceClasse.thisIsHunter(str));
			return rpgClass;
		case 3:
			setRpgClass(thisIsChoiceClasse.thisIsPriest(str));
			return rpgClass;
		case 4:
			setRpgClass(thisIsChoiceClasse.thisIsMagus(str));
			return rpgClass;
		case 5:
			setRpgClass(thisIsChoiceClasse.thisIsMonk(str));
			return rpgClass;
		case 6:
			setRpgClass(thisIsChoiceClasse.thisIsDemonHunter(str));
			return rpgClass;
		case 7:
			setRpgClass(thisIsChoiceClasse.thisIsPaladin(str));
			return rpgClass;
		case 8:
			setRpgClass(thisIsChoiceClasse.thisIsThief(str));
			return rpgClass;
		case 9:
			setRpgClass(thisIsChoiceClasse.thisIsShaman(str));
			return rpgClass;
		case 10:
			setRpgClass(thisIsChoiceClasse.thisIsWarlock(str));
			return rpgClass;
		case 11:
			setRpgClass(thisIsChoiceClasse.thisIsDruid(str));
			return rpgClass;
		case 12:
			setRpgClass(thisIsChoiceClasse.thisIsDeathKnight(str));
			return rpgClass;
		default:
			return classCharacterChoice(str, sc);
		}
	}

	private void characterClassChoice() {
		List<ClassTypeEnum> classTypeEnumList = new ArrayList<ClassTypeEnum>();
		List<String> numberEnum = new ArrayList<String>();

		System.out.println(ConstantsChoiceClassCharacterEnum.CHOICECHARACTERQUESTION.getValue());
		System.out.println(ConstantsChoiceClassCharacterEnum.CHOICECHARACTERINDICATIONS.getValue());

		for (ConstantCommunNumberEnum constantNumberEnum : ConstantCommunNumberEnum.values()) {
			numberEnum.add(constantNumberEnum.getValue());
		}

		for (ClassTypeEnum classTypeEnum : ClassTypeEnum.values()) {
			classTypeEnumList.add(classTypeEnum);
		}

		String[] classTypeAndNumber = new String[classTypeEnumList.size()];
		int counter = 0;

		for (int i = 0; i < numberEnum.size(); i++) {

			for (int j = 0; j < classTypeEnumList.size(); j++) {
				if (i == j) {
					classTypeAndNumber[counter] = numberEnum.get(i) + classTypeEnumList.get(j);
				}
			}

			counter++;
		}

		for (int i = 0; i < classTypeAndNumber.length; i++) {
			System.out.println(classTypeAndNumber[i]);
		}
	}

}
