package com.adventofcode.day1to5;

import java.util.List;

import com.adventofcode.utilities.FileAccess;
import com.adventofcode.utilities.Pair;


/**
 * New keypad:
 *      1
  	  2 3 4
	5 6 7 8 9
  	  A B C
    	D
 * 
 * @author mulcas4
 * Answer: 659AD
 */
public class Day2b {

	private static int[][]keypad=new int[5][5];
	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> inputs=fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day2input.txt");
		keypadSetup();
		int startX=2;
		int startY=0;
		Pair currPos=new Pair(startX,startY);
		for(String s:inputs){
			currPos=getNextButton(currPos.getX(),currPos.getY(),s.toCharArray());
		}
	}
	
	private static void keypadSetup() {
		keypad[0][0]=-1;
		keypad[1][0]=-1;
		keypad[2][0]=5;
		keypad[3][0]=-1;
		keypad[4][0]=-1;
		keypad[0][1]=-1;
		keypad[1][1]=2;
		keypad[2][1]=6;
		keypad[3][1]=10;
		keypad[4][1]=-1;
		keypad[0][2]=1;
		keypad[1][2]=3;
		keypad[2][2]=7;
		keypad[3][2]=11;
		keypad[4][2]=13;
		keypad[0][3]=-1;
		keypad[1][3]=4;
		keypad[2][3]=8;
		keypad[3][3]=12;
		keypad[4][3]=-1;
		keypad[0][4]=-1;
		keypad[1][4]=-1;
		keypad[2][4]=9;
		keypad[3][4]=-1;
		keypad[4][4]=-1;
	}
	
	private static Pair getNextButton(int startX,int startY,char[] input){
		for(char c:input){
			if(c=='U'){
				if(startX>0&&(keypad[startX-1][startY]!=-1)){
					startX--;
				}
			}
			else if(c=='D'){
				if(startX<4&&(keypad[startX+1][startY]!=-1)){
					startX++;
				}
			}
			else if(c=='L'){
				if(startY>0&&(keypad[startX][startY-1]!=-1)){
					startY--;
				}
			}
			else if(c=='R'){
				if(startY<4&&(keypad[startX][startY+1]!=-1)){
					startY++;
				}
			}
		}
		System.out.println("Code: "+keypad[startX][startY]);
		return new Pair(startX,startY);
	}
}
