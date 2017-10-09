package com.bridgelabz.Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author OmPrajapati
 *
 */
public class UnOrderedList {

	public static void main(String[] args) {
		
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		String[] strings;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("/home/bridgelabz/Public/file/unordered.txt");
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("\\.", "");
				strings = line.split(" ");
				for (String s : strings) {
					myLinkedList.add(s);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		myLinkedList.list();
		Scanner scanner = new Scanner(System.in);
		System.out.println("  ");
		System.out.print("Enter a word to search :");
		String search = scanner.next();
		scanner.close();
		int pos;

		if ((pos = myLinkedList.index(search)) == -1) {
			System.out.println("This word is not in the file.\nAdding it to the list.");
			myLinkedList.add(search);
		} else {
			System.out.println("Word is at " + pos + ". Removing it from list.");
			myLinkedList.remove(search);
		}
		try {
			int size = myLinkedList.size();
			PrintWriter printWriter = new PrintWriter("/home/bridgelabz/Public/file/unordered.txt");
			for (int i = 0; i < size; i++) {
				String st = myLinkedList.pop(0);
				printWriter.write(st + " ");
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
