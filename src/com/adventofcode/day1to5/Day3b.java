package com.adventofcode.day1to5;

import java.util.List;

import com.adventofcode.utilities.FileAccess;
/**
 * Puzzle changed- the columns are now the triangles, not the rows
 * @author mulcas4
 *
 */
public class Day3b {

	public static void main(String[] args) {
		int[] sides=getTriangleSides();
		int counter=0;
		for(int i=0;i<sides.length;i+=3){
			counter+=isValid(sides[i],sides[i+1],sides[i+2])?1:0;
		}
		System.out.println(counter);
	}

	private static int[] getTriangleSides() {
		FileAccess fa=new FileAccess();
		List<String> lines=fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day3input.txt");
		int[] values=new int[lines.size()*3];
		int pointer=0;
		for(String s:lines){
			String[] rowValues=s.trim().split("\\s+");
			values[pointer]=Integer.parseInt(rowValues[0]);
			values[pointer+lines.size()]=Integer.parseInt(rowValues[1]);
			values[pointer+lines.size()*2]=Integer.parseInt(rowValues[2]);
			pointer++;
		}
		return values;
	}
	private static boolean isValid(int x,int y, int z){
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
