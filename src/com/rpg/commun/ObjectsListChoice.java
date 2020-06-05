
package com.rpg.commun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.rpg.armory.Weapon;
import com.rpg.classesManipulation.ConstantClassEnum;
import com.rpg.textSyntaxes.ConstantCommunEnum;
import com.rpg.textSyntaxes.ConstantCommunNumberEnum;

public class ObjectsListChoice {

	/*
	 * TODO revoir la localisation de la classe + le nom
	 */

	/**
	 * Recupération d'un enum pour le transformer en array
	 */

	public List<String> enumValuesStringArrayWithGetValue(Class<?> enumType) {

		List<String> enumArrayNotGetValue = new ArrayList<String>();
		/*
		 * TODO revoir les noms des variables et organisation de la méthode + revoir la
		 * localisation de la méthode
		 */

		Object[] objects = enumType.getEnumConstants();

		for (Object obj : objects) {
			/*
			 * + TODO si clzz.getDeclaredMetho(getValue) == null
			 */
			Class<?> clzz = obj.getClass();
			Method method = null;
			try {
				method = clzz.getDeclaredMethod("getValue");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			String val = null;
			try {
				val = (String) method.invoke(obj);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			enumArrayNotGetValue.add(val);
		}

		return enumArrayNotGetValue;
	}

	public List<String> enumArrayNotGetValue(Class<?> enumType) {

		List<String> enumArrayNotGetValue = new ArrayList<String>();

		Object[] objects = enumType.getEnumConstants();

		for (Object obj : objects) {
			enumArrayNotGetValue.add(obj.toString());
		}

		return enumArrayNotGetValue;
	}

	/**
	 * 
	 * @param weapons
	 * 
	 *            list of weapon for the class
	 */
	public void weaponListChoice(List<Weapon> weapons) {
		System.out.println(ConstantClassEnum.CHOICEWEAPONQUESTION.getValue());

		List<String> numberEnum = this.enumValuesStringArrayWithGetValue(ConstantCommunNumberEnum.class);

		for (int i = 0; i < numberEnum.size(); i++) {

			for (int j = 0; j < weapons.size(); j++) {
				if (i == j) {
					System.out.println(numberEnum.get(i) + weapons.get(j).getClass().getSimpleName()
							+ ConstantCommunEnum.TWOPOINTS.getValue() + weapons.get(j).getName());
				}
			}
		}
	}

}