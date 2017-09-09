package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class BalancedParentheses {
	
	public static void main(String[] args) {
		MyStack<Character> parenthesesSatck = new MyStack<Character>();
		Utility utility = new Utility();
		System.out.print("Enter equation to check: ");
		String equation = utility.inputString();
		char[] equationCharcaterArray = equation.toCharArray();

		for (char character : equationCharcaterArray) {
			if (character == '(') {
				parenthesesSatck.push(character);
			} else if (character == ')') {
				parenthesesSatck.pop();
			}
		}
		System.out.println(" ");
		if (parenthesesSatck.isEmpty()) {
			System.out.println("Equation is balanced.");
		} else {
			System.out.println("Enquation is not balanced.");
		}
	}
}
