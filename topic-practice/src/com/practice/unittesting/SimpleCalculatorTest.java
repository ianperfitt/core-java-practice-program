package com.practice.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

	@Test
	void twoPlusTwoShouldEqualFour() {
		var calculator = new SimpleCalculator();
		assertEquals(4, calculator.add(2, 2));
	}

	@Test
	void threePlusSevenShouldEqualTen() {
		var calculator = new SimpleCalculator();
		assertEquals(10, calculator.add(3, 7));
	}

	@Test
	void negativeOneShouldReturnIllegalArgumentException() {
		var calculator = new SimpleCalculator();
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.add(3, -1);
		});
	}
}