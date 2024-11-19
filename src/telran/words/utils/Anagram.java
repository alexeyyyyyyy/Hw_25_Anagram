package telran.words.utils;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static boolean isAnagram(String word, String part) {
		if (word == null || part == null || part.isEmpty()) {
			return false;
		}

		word = word.toLowerCase();
		part = part.toLowerCase();

		if (part.length() > word.length()) {
			return false;
		}

		Map<Character, Integer> wordCharCount = new HashMap<>();

		for (char c : word.toCharArray()) {
			wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
		}

		for (char c : part.toCharArray()) {
			if (!wordCharCount.containsKey(c) || wordCharCount.get(c) <= 0) {
				return false;
			}
			wordCharCount.put(c, wordCharCount.get(c) - 1);
		}

		return true;
	}
}
