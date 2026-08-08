package com.generics;

import java.util.*;

public class NewClass {

	public static void main(String[] args) {
		
		
		int[] arr = new int[5];
		ArrayList<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world");
	
		
		System.out.println("print New class");
		
		Object o = list.get(1);

		System.out.println(o);

		Box box=new Box();
		box.setValue(1);
		
		Box<Integer> box2 = new Box<>();
		
		
		int i= 	(int) box.getValue();
		
		int i2= 	(int) box2.getValue();
		
		System.out.println(i);
		System.out.println(i2);
		
	}

}
