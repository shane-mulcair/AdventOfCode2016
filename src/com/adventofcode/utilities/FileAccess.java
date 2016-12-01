package com.adventofcode.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {

	public List<String> readLinesFromFile(String fileName) {
		List<String> lines = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can't find that file: " + fileName);
		} catch (IOException e) {
			System.out.println("Something happened in accessing the file");
			e.printStackTrace();
		}
		return lines;
	}
	
	public String readSingleLineFromFile(String fileName) {
		String line = "";
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			line = "";
			line=br.readLine();
			br.close();
			fr.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can't find that file: " + fileName);
		} catch (IOException e) {
			System.out.println("Something happened in accessing the file");
			e.printStackTrace();
		}
		return line;
	}

	public void writeToFile(String filename, String content) {

		try {
			PrintWriter writer=new PrintWriter(filename);
			if (!content.isEmpty() && !content.equals(null)) {
				writer.append(content);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to find the file, or open it");
			e.printStackTrace();
		}
	}

	public void writeToFile(String filename, List<String> content) {

		try {
			Path file = Paths.get(filename);
			if (!content.isEmpty() && !content.equals(null)) {
				Files.write(file, content, Charset.forName("UTF-8"));
			}
		} catch (IOException e) {
			System.out.println("Failed to find the file, or open it");
			e.printStackTrace();
		}
	}
}
