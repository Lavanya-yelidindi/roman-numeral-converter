package com.example.roman_numeral_converter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.roman_numeral_converter.service.RomanNumeralService;

@SpringBootTest
class RomanNumeralConverterApplicationTests {

	private final RomanNumeralService service = new RomanNumeralService();

	@Test
	public void testToRoman_validInputs() {
		assertEquals("I", service.toRoman(1));
		assertEquals("IV", service.toRoman(4));
		assertEquals("IX", service.toRoman(9));
		assertEquals("X", service.toRoman(10));
		assertEquals("XL", service.toRoman(40));
		assertEquals("XC", service.toRoman(90));
		assertEquals("CD", service.toRoman(400));
		assertEquals("CM", service.toRoman(900));
		assertEquals("M", service.toRoman(1000));
		assertEquals("XCIX", service.toRoman(99));
		assertEquals("DCCVII", service.toRoman(707));
	}

	@Test
	public void testToRoman_invalidInputs() {
		assertThrows(IllegalArgumentException.class, () -> service.toRoman(0));
		assertThrows(IllegalArgumentException.class, () -> service.toRoman(-5));
		assertThrows(IllegalArgumentException.class, () -> service.toRoman(1001));
	}

	@Test
	public void testToNumber_validInputs() {
		assertEquals(1, service.toNumber("I"));
		assertEquals(4, service.toNumber("IV"));
		assertEquals(9, service.toNumber("IX"));
		assertEquals(40, service.toNumber("XL"));
		assertEquals(90, service.toNumber("XC"));
		assertEquals(400, service.toNumber("CD"));
		assertEquals(900, service.toNumber("CM"));
		assertEquals(1000, service.toNumber("M"));
		assertEquals(58, service.toNumber("LVIII")); // L = 50, V = 5, III = 3
		assertEquals(199, service.toNumber("CXCIX")); // 100 + 90 + 9
	}

	@Test
	public void testToNumber_caseInsensitive() {
		assertEquals(42, service.toNumber("xlii"));
		assertEquals(78, service.toNumber("lxxviii"));
	}

	@Test
	public void testToNumber_incorrectRoman() {
		assertDoesNotThrow(() -> service.toNumber("IIII")); // this implementation doesn't validate
		assertDoesNotThrow(() -> service.toNumber("VV"));
	}
}
