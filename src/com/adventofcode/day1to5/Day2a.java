package com.adventofcode.day1to5;

import java.util.List;

import com.adventofcode.utilities.FileAccess;
import com.adventofcode.utilities.Pair;

public class Day2a {

	private static int[][]keypad=new int[3][3];
	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> inputs=fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day2input.txt");
		keypadSetup();
		int startX=1;
		int startY=1;
		Pair currPos=new Pair(startX,startY);
		for(String s:inputs){
			currPos=getNextButton(currPos.getX(),currPos.getY(),s.toCharArray());
		}
	}
	
	private static void keypadSetup() {
		keypad[0][0]=1;
		keypad[0][1]=2;
		keypad[0][2]=3;
		keypad[1][0]=4;
		keypad[1][1]=5;
		keypad[1][2]=6;
		keypad[2][0]=7;
		keypad[2][1]=8;
		keypad[2][2]=9;
	}
	
	private static Pair getNextButton(int startX,int startY,char[] input){
		for(char c:input){
			if(c=='U'){
				if(startX>0){
					startX--;
				}
			}
			else if(c=='D'){
				if(startX<2){
					startX++;
				}
			}
			else if(c=='L'){
				if(startY>0){
					startY--;
				}
			}
			else if(c=='R'){
				if(startY<2){
					startY++;
				}
			}
		}
		System.out.println("Code: "+keypad[startX][startY]);
		return new Pair(startX,startY);
	}
}
