package com.practice.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("M/dd/Y HH:mm a");
		String myString = dateForm.format(thisDate);
		System.out.println(myString);
	}

}
