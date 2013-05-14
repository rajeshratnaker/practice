package com.practice.java;

import java.util.ArrayList;
import java.util.List;

public class GenericPractice {
	public static void main(String[] args) {

		List<Integer> list = callMe();
		List<String> list1 = callMe();
		list.add(1);
		list1.add("1");

		System.out.println(list);
		System.out.println(list1);
	}

	static <T> List<T> callMe() {
		ArrayList<T> arrayList = new ArrayList<T>();
		return arrayList;
		
	}


	public static List common(List list1, List list2) {
		List<?> list = new ArrayList<Object>();
		for (Object item1 : list1) {
			if (list.contains(item1)) {
				// list.add(item1); //Error as unbounded wildcard is being used
			}
		}

		return list;

	}

	static <T> void fun(List<? extends T> list) {
		for (T t : list) {

		}
	}
}
