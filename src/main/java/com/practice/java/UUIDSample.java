package com.practice.java;

import java.util.Date;
import java.util.UUID;

public class UUIDSample {
	public static void main(String[] args) {
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID);

		long currentTimeMillis = System.currentTimeMillis();
		String timeStr = new Long(currentTimeMillis).toString();
		UUID fromStringUUID = UUID.fromString(timeStr);

		long timestamp = fromStringUUID.timestamp();
		Date date = new Date(timestamp);
		System.out.println(fromStringUUID + ":" + date);
	}

}
