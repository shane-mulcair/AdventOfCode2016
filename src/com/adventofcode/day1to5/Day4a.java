package com.adventofcode.day1to5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.adventofcode.utilities.FileAccess;

public class Day4a {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> lines = fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day4input.txt");
		int counter = 0;
		for (String s : lines) {
			counter += isRoom(s) ? getSectorID(s) : 0;
		}
		System.out.println(counter);
	}

	private static boolean isRoom(String line) {
		String checksum = getChecksum(line);
		char[] encrypted = removeHyphens(line.substring(0, line.length() - 11)).toCharArray();
		Arrays.sort(encrypted);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : encrypted) {
			Integer val = map.get(new Character(c));
			if (val != null) {
				map.put(c, val + 1);
			} else {
				map.put(c, 1);
			}
		}
		return isValidCheckSum(map, checksum);
	}

	private static boolean isValidCheckSum(HashMap<Character, Integer> map, String checksum) {
		for (int i = 0; i < checksum.length(); i++) {
			char currChar = checksum.toCharArray()[i];
			if (!map.containsKey(currChar) && map.size() >= checksum.length()) {
				return false;
			}
			if (i > 0) {
				Character prev = checksum.toCharArray()[i - 1];
				if (map.get(prev) < map.get(currChar)) {
					return false;
				} else if (map.get(prev)==map.get(currChar)){
				if(prev.compareTo(currChar) > 0) {
					return false;
				}
				}
			}
		}
		return true;
	}

	private static String getChecksum(String input) {
		String cs = input.substring(input.length() - 6, input.length() - 1);
		return cs;
	}

	private static int getSectorID(String input) {
		int sID = Integer.parseInt(input.substring(input.length() - 10, input.length() - 7));
		System.out.println(sID);
		return sID;
	}

	private static String removeHyphens(String input) {
		return input.replaceAll("-", "");
	}

}
