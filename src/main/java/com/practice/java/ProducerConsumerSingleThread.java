package com.practice.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerConsumerSingleThread implements Event {

	// TODO Write Test Case

	private Map<String, List<Listener>> items = new HashMap<String, List<Listener>>();

	@Override
	public void register(String source, Listener listener) {
		List<Listener> listeners = items.get(source);
		if (listener == null) {
			listeners = new ArrayList<Listener>();
			items.put(source, listeners);
		}
		listeners.add(listener);		
	}

	@Override
	public void deregister(String source, Listener listener) {
		List<Listener> list = items.get(source);
		if (list != null) {
			list.remove(listener);
			if (list.isEmpty()) {
				items.remove(source);
			}
		}
	}

	@Override
	public void notifyAllItems(String source) {
		List<Listener> list = items.get(source);
		for (Listener listener : list) {
			listener.notifyMe();
		}
	}

}

interface Event {
	void register(String source, Listener listener);

	void deregister(String source, Listener listener);

	void notifyAllItems(String source);
}

interface Listener {
	void notifyMe();
}

class ListenerImpl implements Listener {
	String str;

	public ListenerImpl(String str) {
		this.str = str;
	}

	@Override
	public void notifyMe() {
		System.out.println(str);
	}
}