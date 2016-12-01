package com.adventofcode.day1to5;

import com.adventofcode.utilities.FileAccess;

public class Day1a {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		String input = fa.readSingleLineFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day1a.txt");
		int currDirectionX = 0;
		int currDirectionY = 1;
		int currPositionX = 0;
		int currPositionY = 0;
		String[] directions = input.split(",");
		for (String s : directions) {
			s = s.trim();
			if (currDirectionX == 0 && currDirectionY == 1) {
				currDirectionY = 0;
				if (s.startsWith("R")) {
					currDirectionX = 1;

				} else {
					currDirectionX = -1;
				}
			} else if (currDirectionX == 1 && currDirectionY == 0) {
				currDirectionX = 0;
				if (s.startsWith("R")) {
					currDirectionY = -1;
				} else {
					currDirectionY = 1;
				}
			} else if (currDirectionX == 0 && currDirectionY == -1) {
				currDirectionY = 0;
				if (s.startsWith("R")) {
					currDirectionX = -1;
				} else {
					currDirectionX = 1;
				}
			} else {
				currDirectionX = 0;
				if (s.startsWith("R")) {
					currDirectionY = 1;
				} else {
					currDirectionY = -1;
				}
			}
			currPositionX+=(currDirectionX*Integer.parseInt(s.substring(1)));
			currPositionY+=(currDirectionY*Integer.parseInt(s.substring(1)));
		}
		System.out.println("Current Position: "+currPositionX+" "+ currPositionY);
		
	}

}
