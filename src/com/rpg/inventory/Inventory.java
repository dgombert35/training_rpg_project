package com.rpg.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rpg.armory.Weapon;
import com.rpg.quitElement.QuitElement;
import com.rpg.store.IEquipment;
import com.rpg.textSyntaxes.ConstantCommunEnum;
import com.rpg.textSyntaxes.SyntaxsText;

public class Inventory {

	private int maxInventorySize = 0;
	private int maxWeaponsSize = 1;
	private int maxShieldsSize = 10;
	private int maxClothsSize = 20;
	private int maxObjectsSize = 20;
	private boolean isMax = true;
	
	private QuitElement quitElement = new QuitElement();

	public int getMaxInventorySize() {
		return maxInventorySize;
	}

	public void setMaxInventorySize(int maxInventorySize) {
		this.maxInventorySize = maxInventorySize;
	}

	public int getMaxWeaponsSize() {
		return maxWeaponsSize;
	}

	public void setMaxWeaponsSize(int maxWeaponsSize) {
		this.maxWeaponsSize = maxWeaponsSize;
	}

	public int getMaxShieldsSize() {
		return maxShieldsSize;
	}

	public void setMaxShieldsSize(int maxShieldsSize) {
		this.maxShieldsSize = maxShieldsSize;
	}

	public int getMaxClothsSize() {
		return maxClothsSize;
	}

	public void setMaxClothsSize(int maxClothsSize) {
		this.maxClothsSize = maxClothsSize;
	}

	public int getMaxObjectsSize() {
		return maxObjectsSize;
	}

	public void setMaxObjectsSize(int maxObjectsSize) {
		this.maxObjectsSize = maxObjectsSize;
	}

	private List<?> completeInventory = new ArrayList<>();
	private List<Weapon> iWeaponInventoryList = new ArrayList<Weapon>();
	private List<IEquipment> iEquipmentInventoryList = new ArrayList<IEquipment>();

	public List<Weapon> getiWeaponInventoryList() {
		return iWeaponInventoryList;
	}

	public void setiWeaponInventoryList(List<Weapon> iWeaponInventoryList) {
		this.iWeaponInventoryList = iWeaponInventoryList;
	}
	
	public List<IEquipment> getiEquipmentInventoryList() {
		return iEquipmentInventoryList;
	}

	public void setiEquipmentInventoryList(List<IEquipment> iEquipmentInventoryList) {
		this.iEquipmentInventoryList = iEquipmentInventoryList;
	}

	private int maxObjectsInventory() {
		setMaxInventorySize(getMaxClothsSize() + getMaxShieldsSize() + getMaxWeaponsSize() + getMaxObjectsSize());

		return getMaxInventorySize();
	}
		
	public List<?> getCompleteInventory() {
		return completeInventory;
	}

	public void setCompleteInventory(List<?> completeInventory) {
		this.completeInventory = completeInventory;
	}

	private void allObjectsInventory() {
		
		/*
		 * TODO gestion de l'inventaire au complet
		 * ajout des différentes list
		 */
//		completeInventory.add((Collection<?>) getiEquipmentInventoryList());
//		completeInventory.addAll(getiWeaponInventoryList());
//		
//		
//		setCompleteInventory(completeInventory);
	}

	public void putEquipmentInInventory(IEquipment iEquipment) {
		
		maxObjectsInventory();

		/*
		 * TODO gerer l'inventaire plein
		 */
		if(completeInventory.size() == getMaxInventorySize()) {
			System.out.println("Your inventory is full");
			System.out.println("Your need to throw some stuff");
		}
		
		if(getiEquipmentInventoryList().size() == getMaxShieldsSize()) {
			System.out.println("your shield inventory is full");
		} else if(getiEquipmentInventoryList().size() == getMaxClothsSize()) {
			System.out.println("your Cloth inventory is full");
		} else if(getiEquipmentInventoryList().size() == getMaxObjectsSize()) {
			System.out.println("your object inventory is full");
		} else {
			if(iEquipment instanceof Weapon) {
				iWeaponInventoryList.addAll((Collection<? extends Weapon>) iEquipment);
				setiWeaponInventoryList(iWeaponInventoryList);
			}
			
		}
		
		
		
		/*
		 * TODO pb parametre faut mettre IEquipment pour recevoir n'importe quoi =>
		 * transformer le IWeapon en IEquipment
		 */
		
	}

	public void putWeaponInInventory(Weapon iWeapon) {
		
		if(isMax) {
			checkIfMax(iWeaponInventoryList);
		} else {
			iWeaponInventoryList.add(iWeapon);
			setiWeaponInventoryList(iWeaponInventoryList);
		}

//		if(getiWeaponInventoryList().size() == getMaxWeaponsSize()) {
//			
//			/*
//			 * TODO need to throw
//			 * TODO throw method
//			 * TODO parcourir list => et choisir quoi jeter
//			 * TODO list size -1
//			 * et repasser dans if size = get max size
//			 */
//			
//			
//		}  else {
//			
//		}
	}

	public void checkInventory() {

		System.out.println("What do you want to check ?");
		System.out.println("1. Weapons");
		System.out.println("2. Shields");
		System.out.println("3. Cloths");
		System.out.println("4. Objects");
		System.out.println("5. Get out");

		int choice = SyntaxsText.sc.nextInt();

		switch (choice) {
		case 1:
			tab(getiWeaponInventoryList());
			break;
		case 2:
		case 3:
			tab(getiEquipmentInventoryList());
			break;
		case 4:
			tab(getiWeaponInventoryList());
			break;
		case 5:
			quitElement.getOut(SyntaxsText.sc);
			break;
		default:
			checkInventory();
			break;
		}

	}

	private boolean objectIsEquip(IEquipment iEquipment) {
		/*
		 * rajouter dans l'objet un flag true false get flag object
		 */
		return true;
	}

	private void tab(List<?> list) {
	
		for (int i = 0; i < list.size(); i++) {
			String objectType = list.get(i).getClass().getSimpleName();
			String objectName = "";
			
			if (list.get(i) instanceof Weapon) {
				Weapon new_name = (Weapon) list.get(i);
				objectName = new_name.getName();
				
			} else if(list.get(i) instanceof IEquipment) {
				IEquipment new_name = (IEquipment) list.get(i);
				objectName = new_name.getName();
			}
			
			/*
			 * TODO change affichage => mettre Weapons  :
			 * 								- Axe : black cleaver
			 */
			
			System.out.println((i + 1) + ConstantCommunEnum.ONEPOINTS.getValue() + objectType
					+ ConstantCommunEnum.TWOPOINTS.getValue() + objectName);
		}
	}

	private boolean checkIfMax(List<?> list) {

		if(list instanceof Weapon) {
			if(getiWeaponInventoryList().size() == getMaxWeaponsSize()) {
				System.out.println("Your weapon inventory is full");
				System.out.println("You need to throw weapon");
			} else {
				isMax = false;
			}
		} else {
			System.err.println("NOT work");
		}
		
		/*
		 * 
		 * slection du max selon le type de list recu check si correspond à tel ou tel
		 * enum? check list size si size > max => return true
		 * 
		 * 
		 */

		return isMax;
	}

	/*
	 * TODO method putInInventory(prend un objet en parametre check if inventory max
	 * => si max garder element ou jeter? => si garder jeter un objet dans la liste
	 * montrer la liste par onglets if onglet 1 getList if cest un weapon => check
	 * if list size => max if not max => put element dans la list
	 * 
	 * Method checkInventory
	 * 
	 * Method onglet
	 * 
	 * 
	 */

	/*
	 * TODO list inventaire arme size max => getMaxWeapon TODO liste inventaire
	 * shield TODO liste inventaire equipment (vetements / armures) size max cloth
	 * TODO liste inventaire object size max obje
	 * 
	 * 
	 */

}
