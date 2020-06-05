package com.rpg.adventure;

import com.rpg.textSyntaxes.SyntaxsText;

public enum ConstantAdventureWayEnum {
	
	/*
	 * /AdventureWAy Constants
	 */
	CHOICETODO("What do you want to do ?"),
	
	WAYTOCHOOSE("What way do you want to choose ?"),
	WAYNUMBERTOCHOOSE("you choose the way number "),
				
			//Titles of way
	WAYBEGINNNINGBEAUTIFULADVENTURE(" The beginning of a beautiful adventure !"),
	WAYOFBRAV(" The way of brav"),
	WAYGOODLUCK(" Good luck !!!"),
	WAYGOODBY(" Good by"),
	STOPADVENTURE("Stop the adventure ?"),
	
		//Events on the way of player
	EVENTMONSTERFIGHT("You meet a monster. It is a monster !!!! Go fight"),
	EVENTFINDTREASURE("You find a treasure."),
	EVENTBUILDING("You are in front of a building."),
	EVENTPLAYERCONTINUEADVENTURE("You continue"),
	EVENTENDADVENTURE("You quit the adventure"),
	
	    //Choice player in front of the treasure
	OPENTREASURECHOICE("1. Open the Treasue ?"),
	CONTINUECHOICE("2. Continue"),
	OPENTREASUREEVENT("You find a TODO RANDOM ON OBJECTS LIST"),
	OPENTREASUREEVENTNOTHING("There is nothing !!!!");
	
	private String value;
	
	private ConstantAdventureWayEnum(String value) {
		this.value = value;
	}
	
	
	public String getValue() {
		if(value.startsWith("You")) {
			return value + SyntaxsText.lineSeparator;
		}else {
			return value;
		}
	}

}
