package com.adventofcode.day6to10;

import com.adventofcode.utilities.FileAccess;

public class Day9b {

	public static void main(String[] args) {
		FileAccess fa=new FileAccess();
		String input=fa.readSingleLineFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day9input.txt");
		StringBuilder sb=new StringBuilder();
		decompress(input, sb);
		System.out.println(sb.length());
	}

	private static void decompress(String input, StringBuilder sb) {
		int len=0;
		int reps=0;
		boolean foundMarker=false;
		String temp="";
		for(int i=0;i<input.length();i++){
			char c=input.charAt(i);
			if(c=='('){
				foundMarker=true;
			}
			if(foundMarker&&c!='('){
				if(c!=')'){
					temp+=c;
				}
				else{
					foundMarker=false;
				}
			}
			if(!foundMarker&&temp.length()>0){
				String[] vals=temp.split("x");
				len=Integer.parseInt(vals[0]);
				reps=Integer.parseInt(vals[1]);
				
				for(int j=0;j<reps;j++){
					sb.append(input.substring(i+1, i+len+1));
					
				}
				
				i+=len;
				temp="";
			}
		}
	}

}
