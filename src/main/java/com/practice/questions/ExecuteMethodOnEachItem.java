package com.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteMethodOnEachItem {
	public static <T> List<T> map(Task<T> task, List<T> list) {
		List<T> outputList = new ArrayList<T>();
		for (T t : list) {
			outputList.add(task.execute(t));
		}

		return outputList;
	}

	public static void main(String[] args) {
		List<Integer> inputList = Arrays.asList(new Integer[] { 1, 2, 3 });
		PlusOne plusOne = new PlusOne();
		List<Integer> outputList = map(plusOne, inputList);
		System.out.println("Input:" + inputList);
		System.out.println("Input:" + outputList);
	}
}

class PlusOne implements Task<Integer> {

	@Override
	public Integer execute(Integer item) {
		return item + 1;
	}

}

interface Task<T> {
	T execute(T item);
}
