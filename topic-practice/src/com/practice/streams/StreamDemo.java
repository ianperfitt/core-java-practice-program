package com.practice.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> numbersList = new ArrayList<>();
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);

		System.out.println(numbersList.stream().reduce(0, Integer::sum));
	}
}