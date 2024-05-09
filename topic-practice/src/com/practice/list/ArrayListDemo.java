package com.practice.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		list.remove(3);
	}

}
