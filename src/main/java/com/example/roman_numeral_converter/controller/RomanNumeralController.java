
package com.example.roman_numeral_converter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> convertToRoman(@RequestBody Map<String, Integer> request) {
		try {
			int number = request.get("number");
			String roman = romanNumeralService.toRoman(number);
			Map<String, String> response = new HashMap<>();
			response.put("roman", roman);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@PostMapping("/toNumber")
	public ResponseEntity<?> convertToNumber(@RequestBody Map<String, String> request) {
		try {
			String roman = request.get("roman");
			int number = romanNumeralService.toNumber(roman);
			Map<String, Integer> response = new HashMap<>();
			response.put("number", number);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
}
