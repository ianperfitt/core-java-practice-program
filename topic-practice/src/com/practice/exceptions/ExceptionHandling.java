package com.practice.exceptions;

public class ExceptionHandling {

	public static void main(String[] args) {

		try {
			int myInt = Integer.parseInt("1");
			System.out.println("After parsing pants.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("Hey dude, you can't make an int out of that. Stop trying to make it happen.");
		} finally {
			System.out.println("in the finally block");
		}
		System.out.println("End here");
	}

}
