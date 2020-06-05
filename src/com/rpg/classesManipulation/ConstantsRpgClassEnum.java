package com.rpg.classesManipulation;

public enum ConstantsRpgClassEnum {
	
	/*
	 * RPGclass Constants
	 */
		//values for tpString() method	
		RPGCLASSEEMPTYHANDS(" walking around with empty hands!!"),
		RPGCLASSPROUD("proud "),
		RPGCLASSAGILE("agile "),
		RPGCLASSEQUIPED(" equip with "),
		RPGCLASSGRIEVES(" that grieves "),
		RPGCLASSDAMAGES(" damage anyway!!"),
		RPGCLASSIS(" is a ");
				
		private String value;
		
		private ConstantsRpgClassEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
				return value;
		}

}
