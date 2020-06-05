package com.rpg.building;

public enum ConstantBuildingEnum {
	
	/*
	 * Building classes Constants
	 */
	STORE,
	TAVERN,
	CHURCH,
	HOUSE,
		BUILDINGINTRODUCTION("It is a "),
		BUILDINGENTERQUESTION(". Do you want to enter?"),
		BUILDINGENTERYES("1. Yes"),
		BUILDINGENTERNO("2. No"),
		BUILDINGSTOREACCESS("You have access to the store!!"),
		BUILDINGSTORE("Store"),
		BUILDINGCHURCH("Church"),
		BUILDINGTAVERN("Tavern"),
		BUILDINGHOUSE("House");
		
		
		private String value;
		
		private ConstantBuildingEnum() {}
		
		private ConstantBuildingEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
				return value;
		}

}
