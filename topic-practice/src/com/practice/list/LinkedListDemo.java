package com.practice.list;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<String>();

		list.add("A");
		list.add("B");
		list.addLast("C");
		list.addFirst("D");
		list.add(2, "E");
		
		System.out.println(list);
	}

}
