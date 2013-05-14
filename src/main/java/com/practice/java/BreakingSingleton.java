package com.practice.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakingSingleton {
	public static void main(String[] args) {

		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		try {

			Class clazz = Class.forName("com.practice.java.Singleton");
			Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
			declaredConstructors[0].setAccessible(true);

			// 1st instance
			Singleton newInstance = (Singleton) declaredConstructors[0].newInstance();

			// 2nd instance
			Singleton newInstance3 = (Singleton) declaredConstructors[0].newInstance();

			// Calling default constructor will fail
			Singleton newInstance2 = (Singleton) clazz.newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// Made 3 successful instances
		System.out.println(instance2);

	}
}

