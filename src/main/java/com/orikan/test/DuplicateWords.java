package com.orikan.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DuplicateWords {

	public static void findDuplicateWords(String str) {
		String[] words = str.toLowerCase().split(" ");
		Map<String, Integer> wordCountMap = new HashMap<>();

		for (String word : words) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}
		int maxValueInMap = Collections.max(wordCountMap.values()); // This will return max value in the HashMap

		// int minValueInMap = Collections.min(wordCountMap.values());
		System.out.println("Max and Min Duplicate words in the string are:");
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

	public static void main(String[] args) {
		String sentence = "Java programming platform language platform is and Java platform is also a Java platform java";

		findDuplicateWords(sentence);
	}

	/*
	 * Generex generex = new Generex("[A_Za-z0-9]"); String reg = "[A_Za-z0-9]";
	 */
	// System.out.println(reg);
}
