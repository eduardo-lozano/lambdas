package com.demo.eduardo.lambdas;

public class PersonConditionLastNameBeginsWithR implements PersonConditionInterface {

	@Override
	public boolean test(Person p) {
		// Tests if the last name of this person begins with letter R.
		return p.getLastName().startsWith("R");
	}

}
