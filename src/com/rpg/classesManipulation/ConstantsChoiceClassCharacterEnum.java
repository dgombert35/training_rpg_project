package com.rpg.classesManipulation;

public enum ConstantsChoiceClassCharacterEnum {
	
	/*
	 * Choice character classes Constants
	 */
	
		CHOICECHARACTERQUESTION("What is your character class ?"),
		CHOICECHARACTERINDICATIONS("type your choice with number");
				
		private String value;
		
		private ConstantsChoiceClassCharacterEnum() {}
		
		private ConstantsChoiceClassCharacterEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
				return value;
		}
}
