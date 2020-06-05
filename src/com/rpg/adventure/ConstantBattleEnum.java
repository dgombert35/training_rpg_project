package com.rpg.adventure;

public enum ConstantBattleEnum {
	
	/*
	 * Battle classes Constants
	 */
		CANTRUNFIGHT("You can't run away : Go fight!!!");
		
		private String value;
		
		private ConstantBattleEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
				return value;
		}

}
