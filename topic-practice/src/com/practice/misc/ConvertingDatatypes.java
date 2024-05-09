package com.practice.misc;

import java.util.ArrayList;
import java.util.List;

public class ConvertingDatatypes {

	public static void main(String[] args) {

		// convert from string to int
//		String s = "69";
//		int i = 0;
//		i = Integer.parseInt(s);
//		System.out.println("Converting String to Int: " + i);		

		// convert from int to string
//		String s = "69";
//		int i = 0;
//		s = String.valueOf(i);
//		System.out.println("Converting Int to String: " + s);

		// convert from Integer[] to list
//		Integer[] arr = {1,2,3,4,5};
//		List<Integer> l = Arrays.asList(arr);
//		System.out.println(l.toString());

		// convert from list to Integer[]
		// METHOD 1.
//		Integer[] arr = new Integer[4];
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		arr = (Integer[]) list.toArray(new Integer[4]);
//		for(int i : arr) {
//			System.out.println(i);
//		}
		// METHOD 2.
//		Integer[] arr = new Integer[4];
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		for(int i = 0; i < list.size(); i++) {
//			arr[i] = list.get(i);
//		}
//		for(int i : arr) {
//			System.out.println(i);
//		}

		// convert from char to string
//		String s = "";
//		char c = 'a';
//		s = String.valueOf(c);
//		System.out.println(s);

		// convert from string to char
//		String s = "a";
//		char c = 'c';
//		c = s.charAt(0);
//		System.out.println(c);

		// convert from char to int
//		int i = 0;
//		char c = 'a';
//		i = (int) c;
//		System.out.println(i);

		// convert from int to char
//		char c = 'a';
//		int i = 98;
//		c = (char) i;
//		System.out.println(c);

		List<List<Integer>> list = new ArrayList<>();

	}

}
