package com.practice.anonymousinnerclasses;

public class AnonymousInnerClasses {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.makeNoise();

		Animal bigfoot = new Animal() {

			@Override
			public void makeNoise() {
				System.out.println("kasljfdl;kasjdklf;jas;df");
			}
		};
		bigfoot.makeNoise();

		Runnable runnable = () -> System.out.println("I'm an anonymous runnable");

		runnable.run();
	}
}