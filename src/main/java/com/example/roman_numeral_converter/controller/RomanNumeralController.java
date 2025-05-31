
package com.example.roman_numeral_converter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roman_numeral_converter.service.RomanNumeralService;

@RestController
@RequestMapping("/api")
public class RomanNumeralController {

	@Autowired
	private RomanNumeralService romanNumeralService;

	@PostMapping("/toRoman")
	public Map<String, String> convertToRoman(@RequestBody Map<String, Integer> request) {
		int number = request.get("number");
		String roman = romanNumeralService.toRoman(number);
		Map<String, String> response = new HashMap<>();
		response.put("roman", roman);
		return response;
	}

	@PostMapping("/toNumber")
	public Map<String, Integer> convertToNumber(@RequestBody Map<String, String> request) {
		String roman = request.get("roman");
		int number = romanNumeralService.toNumber(roman);
		Map<String, Integer> response = new HashMap<>();
		response.put("number", number);
		return response;
	}
}
