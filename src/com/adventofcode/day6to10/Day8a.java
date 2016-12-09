package com.adventofcode.day6to10;

import java.util.List;

import com.adventofcode.utilities.FileAccess;

public class Day8a {
	static int[][] display;
	public static void main(String[] args) {
		FileAccess fa=new FileAccess();
		List<String> instructions=fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day8input.txt");
		display=new int[6][50];
		for(String s:instructions){
			if(!s.isEmpty()){
			handleInstruction(s);
			}
		}
		printDisplay();
	}

	private static void printDisplay() {
		for(int i=0;i<6;i++){
			for(int j=0;j<50;j++){
				if(display[i][j]==8){
				System.out.print(display[i][j]);
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void handleInstruction(String s) {
		String values=s.replaceAll("[^0-9]+", " ");
		String[] ab=values.trim().split(" ");
		int first=Integer.parseInt(ab[0]);
		int second=Integer.parseInt(ab[1]);
		if(s.contains("rect")){
			rect(first,second);
		}
		else if(s.contains("rotate row")){
			rotateRow(first,second);
		}
		else if(s.contains("rotate column")){
			rotateColumn(first,second);
		}
	}
	
	private static void rect(int a,int b){
		for(int i=0;i<b;i++){
			for(int j=0;j<a;j++){
				display[i][j]=8;
			}
		}
	}
	private static void rotateRow(int row,int amount){
		int[] rowVals=new int[50];
		for(int i=49;i>=0;i--){
			if(display[row][i]==8){
				if(i+amount<50){
					rowVals[i+amount]=8;
				}
				else{
					int j=(i+amount)-50;
					rowVals[j]=8;
				}
			}
		}
		for(int l=0;l<50;l++){
			display[row][l]=rowVals[l];
		}
	}
	private static void rotateColumn(int column, int amount){
		int[] colVals=new int[6];
		for(int i=5;i>=0;i--){
			if(display[i][column]==8){
				if(i+amount<5){
					colVals[i+amount]=8;
				}
				else{
					int j=((i+amount)%6);
					colVals[j]=8;
				}
			}
		}
		for(int k=0;k<6;k++){
			display[k][column]=colVals[k];
		}
	}

}
