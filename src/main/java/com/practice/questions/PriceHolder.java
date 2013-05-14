package com.practice.questions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class PriceHolder {

	// ConcurrentHashMap is thread safe without synchronizing the whole map.
	// Reads can happen very fast while write is done with a lock.
	final private Map<String, BigDecimal> liveUpdates = new HashMap<String, BigDecimal>();
	final private Map<String, BigDecimal> sinceLastGetCalled = new HashMap<String, BigDecimal>();
	final private Map<String, List<CountDownLatch>> countDownLatchMap = new HashMap<String, List<CountDownLatch>>();
	final private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	final private WriteLock writeLock = lock.writeLock();
	final private ReadLock readLock = lock.readLock();

	public PriceHolder() {
		// TODO Write this bit
	}

	/** Called when a price ‘p’ is received for an entity ‘e’ */
	public void putPrice(String e, BigDecimal p) {
		writeLock.lock();
		liveUpdates.put(e, p);
		if (countDownLatchMap.containsKey(e)) {
			List<CountDownLatch> list = countDownLatchMap.get(e);
			for (CountDownLatch latch : list) {
				latch.countDown();
			}
			countDownLatchMap.remove(e);
		}
		writeLock.unlock();

	}

	/** Called to get the latest price for entity ‘e’ */
	public BigDecimal getPrice(String e) {
		readLock.lock();
		BigDecimal bigDecimal = liveUpdates.get(e);
		sinceLastGetCalled.put(e, bigDecimal);
		readLock.unlock();
		return bigDecimal;
	}

	/**
	 * Called to determine if the price for entity ‘e’ has changed since the
	 * last call to getPrice(e).
	 */
	public boolean hasPriceChanged(String e) {
		readLock.lock();
		BigDecimal lastGetObject = sinceLastGetCalled.get(e);
		BigDecimal liveObject = liveUpdates.get(e);
		readLock.unlock();
		if (lastGetObject != null && !lastGetObject.equals(liveObject)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the next price for entity ‘e’. If the price has changed since the
	 * last call to getPrice() or waitForNextPrice(), it returns immediately
	 * that price. Otherwise it blocks until the next price change for entity
	 * ‘e’.
	 */
	public BigDecimal waitForNextPrice(String e) throws InterruptedException {
		BigDecimal changed = null;
		readLock.lock();
		boolean hasPriceChanged = hasPriceChanged(e);
		if (hasPriceChanged == true) {
			changed = getPrice(e);
			readLock.unlock();
		} else {
			CountDownLatch countDownLatch = new CountDownLatch(1);
			if (countDownLatchMap.containsKey(e)) {
				countDownLatchMap.get(e).add(countDownLatch);
				} else {
					List<CountDownLatch> arrayList = new ArrayList<CountDownLatch>();
					arrayList.add(countDownLatch);
				countDownLatchMap.put(e, arrayList);
			}
			readLock.unlock();
			countDownLatch.await();
			changed = getPrice(e);
		}
		return changed;
	}

	public static void main(String[] args) {

	}
}

