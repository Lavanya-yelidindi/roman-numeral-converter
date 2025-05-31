
package com.example.roman_numeral_converter.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RomanNumeralService {

    private static final LinkedHashMap<String, Integer> romanToIntMap = new LinkedHashMap<>();
    private static final LinkedHashMap<Integer, String> intToRomanMap = new LinkedHashMap<>();
    private static final String VALID_ROMAN_REGEX =
            "^M{0,1}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    static {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");

        for (Map.Entry<Integer, String> entry : intToRomanMap.entrySet()) {
            romanToIntMap.put(entry.getValue(), entry.getKey());
        }
    }

    public String toRoman(int number) {
        if (number <= 0 || number > 1000) {
        	throw new IllegalArgumentException("Number must be between 1 and 1000");
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : intToRomanMap.entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return result.toString();
    }

    public int toNumber(String romanNum) {
    	String roman = romanNum.toUpperCase();
    	if (roman == null || !roman.toUpperCase().matches(VALID_ROMAN_REGEX)) {
            throw new IllegalArgumentException("Invalid Roman numeral format: " + roman);
        }
        int i = 0, result = 0;
        while (i < roman.length()) {
            if (i + 1 < roman.length() && romanToIntMap.containsKey(roman.substring(i, i + 2))) {
                result += romanToIntMap.get(roman.substring(i, i + 2));
                i += 2;
            } else {
                result += romanToIntMap.get(roman.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }
}
