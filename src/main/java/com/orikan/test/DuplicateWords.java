package com.orikan.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class DuplicateWords {

	public static void main(String[] args) {
		String sentence = "Java programming platform language is and Java is also a platform Java platform java";

		System.out.println("Max and Min Duplicate words in the string are:");
		findDuplicateWords(sentence);
	}

	public static void findDuplicateWords(String str) {
		String[] words = str.split(" ");
		Map<String, Integer> wordCountMap = new HashMap<>();

		for (String word : words) {
			String wordLowerCase = word.toLowerCase();
			wordCountMap.put(wordLowerCase, wordCountMap.getOrDefault(wordLowerCase, 0) + 1);
		}
		int maxValueInMap = Collections.max(wordCountMap.values()); // This will return max value in the HashMap

		int minValueInMap = Collections.min(wordCountMap.values());

		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			if (entry.getValue() == maxValueInMap) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
			} else if (entry.getValue() == 2) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
			}
		}
		
		System.out.println("Duplicate words in the string are:"); 
		
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
			}
		}

	}

	/*
	 * Generex generex = new Generex("[A_Za-z0-9]"); String reg = "[A_Za-z0-9]";
	 */
	// System.out.println(reg);
}
