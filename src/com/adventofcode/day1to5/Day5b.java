package com.adventofcode.day1to5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * Sample input- "abc" gives "05ace8e3"
 *  "ugkcyxxp" gives "f2c730e5"
 * 
 * @author mulcas4
 *
 */
public class Day5b {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String doorID = "ugkcyxxp";
		char[] output = new char[8];
		for (int j = 0; j < 8; j++) {
			output[j] = 'g';
		}
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String hashed = getHash(doorID + i);
			if (hashed.startsWith("00000")) {
				char temp=hashed.charAt(5);
				if ( temp>= '0' && temp < '8') {
					int k=Character.getNumericValue(temp);
					if (output[k] == 'g') {
						output[k] = hashed.charAt(6);
					}
				}
				boolean found = false;
				for (char c : output) {
					if (c == 'g') {
						found = true;
					}
				}
				if (!found) {
					for (char c : output) {
						System.out.print(c);
					}
					break;
				}
			}
		}
	}

	

	private static String getHash(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(input.getBytes());
		StringBuilder sb = new StringBuilder();
		for (byte b : digest) {
			String hex = Integer.toHexString(0xFF & b);
			if (hex.length() == 1) {
				sb.append("0");
			}
			sb.append(hex);
		}
		return sb.toString();
	}

}
