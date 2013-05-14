package com.practice.java;

import java.io.Serializable;

public class Singleton implements Serializable {
	// volatile here means, do not perform optimisation to reorder read/write.
	// Perform read/write from memory always. Usually its done to protect
	// synchronisation issues which occurs due to JIT optimises code for
	// performance on better multi-processor env
	private static volatile Singleton instance = null;
	private static int co = 0;

	private Singleton() {
		co++;
	}

	/**
	 * Code using Reflection API to invoke the private constructor, which can be
	 * dealt with by throwing an exception from the constructor, in case it is
	 * called more than one time.
	 * 
	 * Double checking locking
	 **/
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	@Override
	public String toString() {
		return "Instance:" + co;
	}

	// This method is called immediately after an object of this class is deserialized.
	// This method returns the singleton instance.
	// If the Singleton class is loaded by 2 different class loaders we'll have 2 different classes, one for each class loader. 
	protected Object readResolve() {
		return getInstance();
	}
}