package com.adventofcode.day11to15;

import java.util.List;

import com.adventofcode.utilities.FileAccess;
/**
 * 
 * Literally the only difference is that register c now starts at 1, not 0
 * Answer: 9227647
 * @author mulcas4
 *
 */
public class Day12b {

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		List<String> inputs = fa.readLinesFromFile("C:\\tools\\workspace\\AdventOfCode2016\\bin\\Day12input.txt");
		int[] register = new int[4];
		register[2]=1;
		for (int i = 0; i < inputs.size(); i++) {
			String instr = inputs.get(i);
			String[] splits = instr.split(" ");
			if (instr.startsWith("cpy")) {
				if (splits[1].equals("a") || splits[1].equals("b") || splits[1].equals("c") || splits[1].equals("d")) {
					char reg1 = splits[1].charAt(0);
					char reg2 = splits[2].charAt(0);
					register[((int) reg2) - 97] = register[((int) reg1) - 97];
				} else {
					int val = Integer.parseInt(splits[1]);
					char reg = splits[2].charAt(0);
					register[((int) reg) - 97] = val;
				}
			} else if (instr.startsWith("inc")) {
				char reg = splits[1].charAt(0);
				register[((int) reg) - 97] += 1;
			} else if (instr.startsWith("dec")) {
				char reg = splits[1].charAt(0);
				register[((int) reg) - 97] -= 1;
			} else if (instr.startsWith("jnz")) {
				try {
					int x = Integer.parseInt(splits[1]);
					if (x != 0)
						i += Integer.parseInt(splits[2]) - 1;
				} catch (Exception e) {
					int x = register[((int) splits[1].charAt(0)) - 97];
					if (x != 0)
						i += Integer.parseInt(splits[2]) - 1;
				}
			}
		}
		System.out.println(register[0]);
	}
}
