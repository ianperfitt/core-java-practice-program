package com.practice.unittesting;

public class SimpleCalculator {

	public int add(int numberA, int numberB) {
		if (numberA < 0 || numberB < 0) {
			throw new IllegalArgumentException();
		}
		return numberA + numberB;
	}

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		
		System.out.println(s1 == s2);
	}
}