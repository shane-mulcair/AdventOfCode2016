package com.adventofcode.day1to5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * Sample input- "abc" gives "18f47a30"
 * @author mulcas4
 *
 */
public class Day5a {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String doorID="ugkcyxxp";
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			String hashed=getHash(doorID+i);
			if(hashed.startsWith("00000")){
				sb.append(hashed.charAt(5));
				if(sb.length()==8){
					System.out.println(sb);
					break;
				}
			}
		}
		
	}
	private static String getHash(String input) throws NoSuchAlgorithmException{
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] digest=md.digest(input.getBytes());
		StringBuilder sb=new StringBuilder();
		for(byte b:digest){
			String hex=Integer.toHexString(0xFF &b);
			if(hex.length()==1){
				sb.append("0");
			}
			sb.append(hex);
		}
		return sb.toString();
	}

}
