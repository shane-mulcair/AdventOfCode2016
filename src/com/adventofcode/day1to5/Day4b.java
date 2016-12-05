package com.adventofcode.day1to5;

import java.util.List;

import com.adventofcode.utilities.FileAccess;
/**
 * 
 * Slightly cheating here- I'm not checking to see if the room is valid, so I'm getting ALL of the encrypted strings
 * @author mulcas4
 *
 */
public class Day4b {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> lines = fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day4input.txt");
		for (String s : lines) {
			if(getDecrypted(removeHyphens(s.substring(0, s.length() - 11)), getSectorID(s)).contains("north")){
			System.out.println(getSectorID(s));
			}
		}
	}

	private static int getSectorID(String input) {
		int sID = Integer.parseInt(input.substring(input.length() - 10, input.length() - 7));
		return sID;
	}

	private static String removeHyphens(String input) {
		return input.replaceAll("-", "");
	}

	private static String getDecrypted(String input, int secID){
		StringBuilder sb=new StringBuilder();
		for(char c:input.toCharArray()){
			char newchar=(char)(c+(secID%26));
			if(newchar>'z'){
				newchar=(char)(newchar-26);
			}
			sb.append(newchar);
		}
		return sb.toString();
	}
}
