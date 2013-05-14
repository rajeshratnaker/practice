package com.practice.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Scrubble {
	public static void main(String[] args) {
		double parseDouble = Double.parseDouble("NaN");
		System.out.println(parseDouble);

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");

		System.out.println(dateFormatter.format(new Date()));
		long time = System.currentTimeMillis();
		System.out.println(time);
		System.out.println(new Date(1362745304196l));
		
		final Test t = new Test();
		Runnable runnable = new Runnable(){@Override
			public void run() {
				System.out.println(t.getOne());

			}
		};

		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();

	}

}

class Test {

	String one = null;
	Object lock = new Object();

	public String getOne() {
		if (one == null) {
			synchronized (lock) {
				if (one == null) {
					one = "ONE";
				}
			}
		}

		return one;
	}
}
