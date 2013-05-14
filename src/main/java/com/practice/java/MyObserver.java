package com.practice.java;

import java.util.HashSet;
import java.util.Set;

import com.practice.java.MyModel.Person;


public class MyObserver implements PropertyChangeListener {

	@Override
	public void notify(PropertyChangeListenerEvent event) {
		System.out.println("Event fired: " + event.property + ":" + event.oldValue + "->" + event.newValue);
	}

	public static void main(String[] args) {
		MyObserver observer = new MyObserver();
		System.out.println("Observer instantiated.");

		MyModel myModel = new MyModel();
		System.out.println("My Model instantiated with change.");

		myModel.addListener(observer);

		Person p1 = myModel.new Person("Rajesh", "Chaurasia");
		Person p2 = myModel.new Person("Rakesh Chaurasia", "Kumar");
		myModel.addPerson(p1);
		myModel.addPerson(p2);

		p1.setLastName("Kumar");
		p2.setLastName("Rakesh");
	}
}

class PropertyChangeListenerEvent{
	public String property;
	public String oldValue;
	public String newValue;
	public Object person;
	public PropertyChangeListenerEvent(Object person, String property, String oldValue, String newValue) {
		this.person = person;
		this.property = property;
		this.newValue = newValue;
		this.oldValue = oldValue;
	}
}

interface PropertyChangeListener {
	void notify(PropertyChangeListenerEvent event);
}


class MyModel {
	private Set<Person> persons = new HashSet<Person>();
	private Set<PropertyChangeListener> listeners = new HashSet<PropertyChangeListener>();
	
	public void addPerson(Person person) {
		persons.add(person);
	}

	public void addListener(PropertyChangeListener listner) {
		listeners.add(listner);
	}

	public void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener listner : listeners) {
			listner.notify(new PropertyChangeListenerEvent(object, property, oldValue, newValue));
		}
	}
	
	class Person {
		private String firstName;
		private String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public void setFirstName(String firstName) {
			String oldValue = this.firstName;
			this.firstName = firstName;
			notifyListeners(this, "firstName", oldValue, firstName);
		}

		public void setLastName(String lastName) {
			String oldValue = this.lastName;
			this.lastName = lastName;
			notifyListeners(this, "lastName", oldValue, lastName);
		}
	}
}