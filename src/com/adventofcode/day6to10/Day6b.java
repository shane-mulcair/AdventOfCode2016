package com.adventofcode.day6to10;

import java.util.HashMap;
import java.util.List;

import com.adventofcode.utilities.FileAccess;

public class Day6b {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> inputs = fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day6input.txt");
		String sizer = inputs.get(0);
		for (int i = 0; i < sizer.length(); i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			char current = 0;
			for (String s : inputs) {
				char c = s.charAt(i);
				if (map.get(c) == null) {
					map.put(c, 1);
				} else {
					int val = map.get(c);
					map.put(c, val + 1);
				}
			}
			int min=Integer.MAX_VALUE;
			
			for(Character ch:map.keySet()){
				if(map.get(ch)<min){
					min=map.get(ch);
					current=ch;
				}
			}
			System.out.print(current);
		}
	}
}
