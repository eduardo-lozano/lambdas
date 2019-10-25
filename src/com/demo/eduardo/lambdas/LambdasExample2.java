package com.demo.eduardo.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class LambdasExample2 {

	public static void main(String[] args) {
		
		// Create the array we'll test with
		List<Person> people = Arrays.asList(
				new Person("Daneel", "Olivaw", 2000),
				new Person("Hari", "Seldon", 90),
				new Person("Han", "Pritcher", 53),
				new Person("Golan", "Trevize", 45),
				new Person("Janov", "Pelorat", 60),
				new Person("Bayta", "Darell", 31)
				);

		System.out.println("Print all people, using a method reference and predefined functional interfaces:");
		// The third parameter here is a 'method reference': System.out is the name of the 'out'
		// object, which contains a method called println. You use a double colon to separate the
		// object from the method. The String parameter passed into the println method is inferred
		// by the compiler in a way that's not entirely clear to me, yet.
		performConditionally(people, p -> true, System.out::println);

	}
	
	// The parameters Predicate<> and Consumer<> are predefined functional interfaces, you can
	// find them in the package java.util.function
	// No need to create even one functional interface yourself; almost any imaginable functional
	// interface you might need, is already there. If we create new functional interfaces around
	// here is just to learn the concept.
	public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person person: people) {
			if(predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}
}