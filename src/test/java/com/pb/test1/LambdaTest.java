package com.pb.test1;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.pb.entity.Person;

public class LambdaTest {
	
	List<Person> persons = Arrays.asList(
		new Person("jay", 18),
		new Person("jony", 30),
		new Person("haha", 25),
		new Person("xixi", 33)
			);
	
	@Test
	public void test1() {
		persons.forEach((p) -> System.out.println(p));
		persons.stream()
			.filter((p) -> p.getAge() > 18).forEach(System.out::println);
	}
	

}
