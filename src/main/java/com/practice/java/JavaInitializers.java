package com.practice.java;

public class JavaInitializers {

	public static void main(String[] args) {
		System.out.println("Target->");
		Target.callStatic();
		Target target = new Target();
		target.callNonStatic();

		System.out.println("Target2->");
		Target2 target2 = new Target2();
		target2.callNonStatic();
		// Target2.callStatic();

		System.out.println("2nd instance Target2->");
		Target2 target3 = new Target2();
		target2.callNonStatic();
		// Target2.callStatic();
	}
}


class Target {
	{
		System.out.println("instance load init 1");
	}

	static {
		System.out.println("static init 2");
	}

	public static void callStatic() {
		System.out.println("static method 3");
	}

	public void callNonStatic() {
		System.out.println("non static method 4");
	}
}

class Target2 {
	{
		System.out.println("class load init 1");
	}

	static {
		System.out.println("static init 2");
	}

	public static void callStatic() {
		System.out.println("static method 3");
	}

	public void callNonStatic() {
		System.out.println("non static method 4");
	}
}