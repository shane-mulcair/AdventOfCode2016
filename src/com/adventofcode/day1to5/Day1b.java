package com.adventofcode.day1to5;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.utilities.FileAccess;
import com.adventofcode.utilities.Pair;

public class Day1b {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		String input = fa.readSingleLineFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day1a.txt");
		int currDirectionX = 0;
		int currDirectionY = 1;
		int currPositionX = 0;
		int currPositionY = 0;
		List<Pair> positions = new ArrayList<Pair>();
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
			int movementX = currDirectionX * Integer.parseInt(s.substring(1));
			int movementY = currDirectionY * Integer.parseInt(s.substring(1));
			getPositionsVisitedTwice(currPositionX, currPositionY, positions, movementX, movementY);
			currPositionX += movementX;
			currPositionY += movementY;
		}
	}

	private static void getPositionsVisitedTwice(int currPositionX, int currPositionY, List<Pair> positions,
			int movementX, int movementY) {
		if (movementX != 0) {
			for (int i = 1; i < Math.abs(movementX); i++) {
				Pair p;
				if (movementX > 0) {
					p = new Pair(currPositionX + i, currPositionY);
				} else {
					p = new Pair(currPositionX - i, currPositionY);
				}
				if (positions.contains(p)) {
					System.out.println("Overlap at: " + p.getX() + "," + p.getY());
				} else {
					positions.add(p);
				}
			}
		} else if (movementY != 0) {
			for (int i = 1; i < Math.abs(movementY); i++) {
				Pair p;
				if (movementY > 0) {
					p = new Pair(currPositionX, currPositionY + i);
				} else {
					p = new Pair(currPositionX, currPositionY - i);
				}
				if (positions.contains(p)) {
					System.out.println("Overlap at: " + p.getX() + "," + p.getY());
				} else {
					positions.add(p);
				}
			}
		}
	}

}
