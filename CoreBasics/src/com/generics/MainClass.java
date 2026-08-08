package com.generics;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Inside generics");

		int i = 9;

		System.out.println(i);

		List<String> arrList = Arrays.asList("Alok", "prabin", "deepak");

		if (arrList.contains("Alok")) {
			System.out.println("it has contains alok string");
		}
	}

	static String firstOfFirst(List<String>... strings) {
		List<Integer> ints = Collections.singletonList(42);
		Object[] objects = strings;
	
		objects[0] = ints; // Heap pollution

		return strings[0].get(0); // ClassCastException
	}
}
