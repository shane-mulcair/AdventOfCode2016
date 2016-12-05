package com.adventofcode.day1to5;

import java.util.List;

import com.adventofcode.utilities.FileAccess;

public class Day3a {

	public static void main(String[] args) {
		FileAccess fa=new FileAccess();
		List<String> lines=fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day3input.txt");
		int countValid=0;
		for(String s:lines){
			countValid+=isValid(s.trim().split("\\s+"))?1:0;
		}
		System.out.println(countValid);
	}
	
	private static boolean isValid(String[] args){
		int x=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		int z=Integer.parseInt(args[2]);
		int sumXY=x+y;
		int sumXZ=x+z;
		int sumYZ=y+z;
		if(sumXY>z&&sumXZ>y&&sumYZ>x){
		return true;
		}
		else{
			return false;
		}
	}

}
