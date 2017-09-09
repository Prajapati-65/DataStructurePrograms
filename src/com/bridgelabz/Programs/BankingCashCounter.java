package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;
/**
 * @author OmPrajapati
 *
 */
public class BankingCashCounter {

	public static void main(String[] args) {
		Utility utility = new Utility();
		while (true) {
			System.out.println("Press 1 Deposit");
			System.out.println("Press 2 Withdraw");
			System.out.println("Press 3 Remove");
			System.out.println("Press 4 Exit");
			System.out.println("-------------------");
			System.out.println("Enter your choice");
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				utility.deposit();
				break;
			case 2:
				utility.withdraw();
				break;
			case 3:
				utility.removeFromQueue();
				break;
			case 4:
				System.exit(0);
			}
		}
	}

}
