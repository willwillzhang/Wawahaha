package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Test {

	final String haha = "aaa";

	// pass the "point value" to argument that is the pass by value in Java
	public static void changeReference(List<Integer> reference) {
		/*
		 * List<Integer> a = reference; a.add(1111); a.add(2222);
		 * 
		 * reference = new ArrayList<Integer>(); reference.add(6666);
		 * reference.forEach(e->System.out.println(e));
		 */
		/*
		 * TreeMap<String, String> map = new TreeMap<String, String>();
		 * map.put("zhang", "dong"); map.put("wang", "dong"); map.put("huahua",
		 * "aa");
		 * 
		 * map.forEach((k,v)->System.out.println("key is " + k +" value is "
		 * +v));
		 * 
		 * final ArrayList<Integer> tt = new ArrayList<Integer>(); tt.add(111);
		 */
	}

	public static void main(String[] args) {

		/*
		 * for(int i=0;i<10;){ int a =i++; i=a; System.out.println(i); }
		 */

		System.out.println((5 / 3) * 100.0);

		/*
		 * List<Integer> test = new ArrayList<Integer>(); test.add(11);
		 * test.add(12); test.add(14);
		 * 
		 * System.out.println(Integer.compare(3,2));
		 * 
		 * changeReference(test);
		 * 
		 * test.forEach(e -> System.out.println(e));
		 * 
		 * PriorityQueue<Integer> jj = new PriorityQueue<Integer>();
		 */

		/*
		 * List<Integer> testaa = new ArrayList<Integer>(); testaa = test;
		 * testaa.add(11000);
		 * 
		 * test.forEach(e -> System.out.println(e));
		 */

		/*
		 * List<List<Integer>> result = new ArrayList<List<Integer>>();
		 * result.add(new ArrayList<Integer>(test));
		 * 
		 * test.add(55);
		 * 
		 * 
		 * result.forEach(e -> { System.out.println(e); });
		 * 
		 * 
		 * final StringBuilder str = new StringBuilder("zhangdong");
		 * 
		 * List<Integer> transformedList = test.stream().map(e ->
		 * e.intValue()+11).collect(Collectors.toList());
		 * 
		 * List<Integer> aa = test.stream().map(e->{ str.append("dong"); return
		 * e.intValue() +11; }).collect(Collectors.toList());
		 * 
		 * System.out.println(str);
		 * 
		 * //transformedList.sort();
		 * 
		 * transformedList.forEach(e -> { System.out.println(e); });
		 * 
		 * Arrays.stream(new int[] {1, 2, 3}) .map(n -> 2 * n + 1) .average()
		 * .ifPresent(System.out::println);
		 * 
		 * int[][] two = new int[9][10]; System.out.println(two.length + "   " +
		 * two[0].length);
		 */

		/*
		 * Person obama = new Person("Barack Obama", 53); Person bush2 = new
		 * Person("George Bush", 68); Person clinton = new Person("Bill Clinton"
		 * , 90); Person bush1 = new Person("George HW Bush", 90);
		 * 
		 * Person[] personArray = new Person[] {obama, bush2, clinton, bush1};
		 * List<Person> personList = Arrays.asList(personArray);
		 * 
		 * //Find Oldest Person final Comparator<Person> comp = (p1, p2) ->
		 * Integer.compare( p1.getAge(), p2.getAge()); Person oldest =
		 * personList.stream() .max(comp) .get();
		 * System.out.println(oldest.getName());
		 * 
		 * //Find Youngest Person // -This time instead create the Comparator as
		 * the argument to the min() method Person youngest =
		 * personList.stream() .min((p1, p2) -> Integer.compare(p1.getAge(),
		 * p2.getAge())) .get();
		 */
	}
}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
