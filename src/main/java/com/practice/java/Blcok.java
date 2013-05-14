package com.practice.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Blcok {
	public static void main(String[] args) throws Exception {
			int co=0;
		while (co < 100000) {
			co++;
				Thread.sleep(100);
		}

		BlockingQueue<String> blockingQueue = new BlockingQueue<String>() {

			@Override
			public String remove() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String poll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String element() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String peek() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends String> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean add(String e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean offer(String e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void put(String e) throws InterruptedException {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean offer(String e, long timeout, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String take() throws InterruptedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String poll(long timeout, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int remainingCapacity() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int drainTo(Collection<? super String> c) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int drainTo(Collection<? super String> c, int maxElements) {
				// TODO Auto-generated method stub
				return 0;
			}

		};
	}
}
