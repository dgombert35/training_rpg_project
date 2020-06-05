package com.rpg.monsters;

public enum ConstantsMonsterEnum {

	/*
	 * Monster class Constants
	 */
		//values for attack method	
		MONSTERTHE("The "),
		MONSTERATTACK(" attacking you!!"),
		MONSTERINFLICTS("The monster inflicts you "),
		MONSTERDAMAGES(" damages points!!"),
		
		//values for monsterDescription method
		MONSTERDESCRIPTION("This is a "),
		MONSTEREXCLAMATIONPOINTS(" !!!!!!"),
		MONSTERHAS(" has ");
				
		private String value;
		
		private ConstantsMonsterEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
				return value;
		}
}
