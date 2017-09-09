package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class PalindromeChecker {
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.print("Enter a string to check for palindrome: ");
		String stringToCheck = utility.inputString();
		MyDeque<Character> myDeque = new MyDeque<Character>();
		System.out.println();
		if (myDeque.checkPalindrome(stringToCheck)) {
			System.out.println("Given string is a palindrome");
		} else {
			System.out.println("Given string is not a palindrome...");
		}
	}
}
