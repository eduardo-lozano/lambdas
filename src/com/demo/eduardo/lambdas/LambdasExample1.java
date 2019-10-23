package com.demo.eduardo.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdasExample1 {

	public static void main(String[] args) {
		
		// Create the array we'll test with
		List<Person> people = Arrays.asList(
				new Person("Peter", "Parker", 15),
				new Person("Reed", "Richards", 45),
				new Person("Jhonny", "Storm", 28),
				new Person("Franklin", "Richards", 10),
				new Person("Susan", "Storm", 39),
				new Person("Ben", "Grimm", 45)
				);
		
		// Print the sorted list using Java 7
		System.out.println("Print full people list using Java 7, just to show the status before");
		printAllWithJava7(people);
		
		// Sort list by last name using Java 7
		// The sort method receives the List and and customized implementation of Comparator interface
		System.out.println("Sorting the list by last name using Java 7");
		Collections.sort(people, new PersonLastNameComparator());
		
		// Sort list by last name using Java 8
		// The sort() method receives the List and a lambda which takes two objects and
		// executes a one-line set of operations with those objects.
		// The type of the objects accepted by the lambda is inferred automatically by
		// the compiler (since the sort() method is currently receiving a List<Person>,
		// the compiler will realize that the objects o1 and o2 are Person).
		// The return type of the lambda will be inferred by the return type of the
		// one-line operation, in this case is an int returned by the .compareTo()
		// method (notice the one-line instructions are the exact same as the ones in
		// the method compare() of the class PersonLastNameComparator). Also, the input
		// objects (and the return type) of the lambda expression match the ones of the
		// Comparator interface, which is the second parameter accepted by the .sort()
		// method
		System.out.println("Sorting the list by last name using Java 8");
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		// Print the sorted list using Java 7
		System.out.println("Print full sorted people list using Java 7:");
		printAllWithJava7(people);
		
		// Print people whose last name begins with R, using Java 7:
		// To make a general case, we create an interface PersonConditionInterface
		// and an implementation of the same (inside of which we test for the
		// condition we want). If we want to test for a different condition, we
		// create another implementation class.
		System.out.println("Print sorted people list -whose last name begins with 'R'- with Java 7");
		printSome( people, new PersonConditionLastNameBeginsWithR());
		
		// Print people whose last name begins with R, using Java 8:
		// We use the same method printSome() that accepts a List and an 
		// interface PersonConditionInterface. In this case, instead of
		// implementing a new class like PersonConditionLastNameBeginsWithR(),
		// we input a lambda that accepts an object Person and returns a
		// boolean (just like the interface PersonConditionInterface).
		// The method that ultimately returns the boolean is .startsWith()
		System.out.println("Print sorted people list -whose last name begins with 'R'- with Java 8");
		printSome( people, p -> p.getLastName().startsWith("R"));
		
		// Print the sorted list using Java 8:
		// This is a specific case of the general printSome() function.
		// We use the same method printSome() that accepts a List and an 
		// interface PersonConditionInterface. In this case, instead of
		// implementing a new class to test the condition we want,
		// we input a lambda that accepts an object Person and returns a
		// boolean (just like the interface PersonConditionInterface).
		// For this specific case, the boolean returned by the lambda is
		// always true, so when the lambda is executed inside the method
		// printSome(), the method prints all elements of the List.
		System.out.println("Print full sorted people list using Java 8:");
		printSome(people, p -> true);
	}
	
	public static void printAllWithJava7(List<Person> people) {
		for(Person person: people) {
			System.out.println(person);
		}
	}

	public static void printSome(List<Person> people, PersonConditionInterface condition) {
		for(Person person: people) {
			if(condition.test(person)) {
				System.out.println(person);
			}
		}
	}
}
