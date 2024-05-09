package com.practice.abstractclasses;

public class Cat implements AnimalStuff {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.poop();
	}

	@Override
	public void poop() {
		System.out.println("pbllpblpblhbp");

	}

}
