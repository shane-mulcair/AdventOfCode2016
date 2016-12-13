package com.adventofcode.day6to10;

import com.adventofcode.utilities.FileAccess;

/**
 * 
 * Expected answer = 150914
 * 
 * @author mulcas4
 *
 */
public class Day9a {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		String input = fa.readSingleLineFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day9input.txt");
		long filelen = 0l;
		filelen = decompress(input, filelen);
		System.out.println(filelen);
	}

	private static long decompress(String input, long filelen) {
		int len = 0;
		int reps = 0;
		boolean foundMarker = false;
		String temp = "";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {
				foundMarker = true;
			}
			if (foundMarker && c != '(') {
				if (c != ')') {
					temp += c;
				} else {
					foundMarker = false;
				}
			}
			if (!foundMarker && temp.length() > 0) {
				String[] vals = temp.split("x");
				len = Integer.parseInt(vals[0]);
				reps = Integer.parseInt(vals[1]);

				for (int j = 0; j < reps; j++) {
					filelen += len;
				}
				i += len;
				temp = "";
			}
		}
		return filelen;
	}

}
