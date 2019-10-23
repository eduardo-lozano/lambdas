package com.demo.eduardo.lambdas;

import java.util.Comparator;
import com.demo.eduardo.lambdas.Person;

public class PersonLastNameComparator implements Comparator<Person> {

	public int compare(Person o1, Person o2) {
		// Compare last names
		return o1.getLastName().compareTo(o2.getLastName());
	}
}
