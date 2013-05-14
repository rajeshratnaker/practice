package com.practice.java;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		final Exchanger<Integer> e = new Exchanger<Integer>();
		new Thread(new Runnable() {


			@Override
			public void run() {
				try {
					Integer i = 1;
					while (true) {
						i = e.exchange(i);
						System.out.println("Thread A has value: " + i);
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}).start();
		new Thread(new Runnable() {



			@Override
			public void run() {
				try {
					Integer i = 2;
					while (true) {
						i = e.exchange(i);
						System.out.println("Thread B has value: " + i);
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

}