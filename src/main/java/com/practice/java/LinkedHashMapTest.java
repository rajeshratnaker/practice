package com.practice.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class LinkedHashMapTest {
	public static void main(String[] args) {
		printValues("LinkedHashMap:", new LinkedHashMap<Integer, String>());
		printValues("TreeMap:", new TreeMap<Integer, String>());
	}

	public static void printValues(String label, Map<Integer, String> m) {
		System.out.println(label);
		m.put(1, "ONE");
		m.put(2, "TWO");
		m.put(4, "FOUR");
		System.out.println("\t" + m);
		m.put(2, "two");
		System.out.println("\t" + m);
		m.put(3, "THREE");
		System.out.println("\t" + m);
	}

}
