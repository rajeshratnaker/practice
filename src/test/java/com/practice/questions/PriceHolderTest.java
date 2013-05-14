package com.practice.questions;
import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.practice.questions.PriceHolder;


public class PriceHolderTest {
	
	PriceHolder priceHolder = new PriceHolder();

	@Before
	public void init() {
		priceHolder.putPrice(NUMBER.ZERO.toString(), NUMBERS[0]);
		priceHolder.putPrice(NUMBER.ONE.toString(), NUMBERS[1]);
	}

	@Test
	public void simplePutGetTest() {
		BigDecimal price = priceHolder.getPrice(NUMBER.ZERO.toString());
		Assert.assertEquals(price, NUMBERS[0]);
	}

	@Test
	public void waitForNextValueTest() {
		BigDecimal expected = null;
		changePriceInSeparateThread();
		try {
			expected = priceHolder.waitForNextPrice(NUMBER.ONE.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("Received: " + expected + " is " + priceHolder.getPrice(NUMBER.ONE.toString()));
		Assert.assertEquals(expected, NUMBERS[2]);

	}

	private void changePriceInSeparateThread() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					priceHolder.putPrice(NUMBER.ONE.toString(), NUMBERS[2]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println("Looking for price change for " + NUMBER.ONE.toString() + ":"
				+ priceHolder.getPrice(NUMBER.ONE.toString()));

		thread.start();
	}

	final static BigDecimal[] NUMBERS = { 
			new BigDecimal(0.0), new BigDecimal(1.0), new BigDecimal(2.0),
			new BigDecimal(3.0), new BigDecimal(4.0), new BigDecimal(5.0) };
	enum NUMBER {
		ZERO, ONE, TWO, THREE, FOUR, FIVE
	}
}
