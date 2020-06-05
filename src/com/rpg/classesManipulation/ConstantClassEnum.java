package com.rpg.classesManipulation;

public enum ConstantClassEnum {
	
	/*
	 * Warrior classes Constants
	 */
		//values for attack method	
		ATTACK(" attack the "),
		WITH(" with his "),
		GIVEIT(" and give it "),
		DAMAGES(" damages."),
		KILLMONSTER("You kill the monster. And you win "),
		EXPERIMENTSPOINTS(" experiements points."),
		MONSTERGET("The monster get "),
	
		//values for weapon text
		CHOICEWEAPONQUESTION("Choose your weapon");
				
		private String value;
		
		private ConstantClassEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
				return value;
		}

}
