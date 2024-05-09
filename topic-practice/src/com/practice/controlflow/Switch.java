package com.practice.controlflow;

public class Switch {

	public static void main(String[] args) {

//		int i = 1;
//
//		switch (i) {
//		case 0: case 1:
//			System.out.println("0");
//		case 2:
//			System.out.println("2");		
//		case 3:
//			System.out.println("3");
//			break;
//		default:
//			System.out.println("default");
//
//		}

		String s = null;

		// A nullpointerexception will be thrown because you
		// tried to access what is stored in s but s is null
		switch (s) {
		case "hello!":
			System.out.println("OMG!");
		}
	}
}