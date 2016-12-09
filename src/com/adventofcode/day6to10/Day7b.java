package com.adventofcode.day6to10;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.utilities.FileAccess;

public class Day7b {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> inputs = fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day7input.txt");
		int counter = 0;
		for (String i : inputs) {
			counter += isValidIP(i) ? 1 : 0;
		}
		System.out.println(counter);
	}

	private static boolean isValidIP(String input) {
		List<String> abbas = getOutsideParts(input);
		List<String> hypers = getHypernetParts(input);
		boolean isValid = false;
		for (String s : abbas) {
			if (hasABA(s,hypers)) {
				isValid = true;
			}
		}
		return isValid;
	}

	private static boolean hasABA(String input, List<String> hypers) {
		for (int i = 1; i < input.length() - 1; i++) {
			if (input.charAt(i - 1) == input.charAt(i + 1) && input.charAt(i) != input.charAt(i - 1)) {
				String bab=input.charAt(i)+""+input.charAt(i-1)+""+input.charAt(i);
				for(String s:hypers){
					if(s.contains(bab)){
					return true;
					}
				}
			}
		}
		return false;
	}
	

	private static List<String> getOutsideParts(String input) {
		List<String> parts = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean foundBracket = false;
		for (char c : input.toCharArray()) {
			if (c == '[') {
				foundBracket = true;
				parts.add(sb.toString());
				sb = new StringBuilder();
			} else if (c == ']') {
				foundBracket = false;
			} else if (!foundBracket) {
				sb.append(c);
			}
		}
		parts.add(sb.toString());
		return parts;
	}

	private static List<String> getHypernetParts(String input) {
		List<String> hypers = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean foundBracket = false;
		for (char c : input.toCharArray()) {
			if (c == '[') {
				foundBracket = true;
			} else if (c == ']') {
				hypers.add(sb.toString());
				sb = new StringBuilder();
				foundBracket = false;
			} else if (foundBracket) {
				sb.append(c);
			}
		}
		return hypers;
	}
}
