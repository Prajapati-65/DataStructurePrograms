package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class Calendar {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.print("Enter month : ");
		int month = utility.inputInteger();
		System.out.print("Enter year : ");
		int year = utility.inputInteger();

		String[] months = new String[] { "", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };

		int[] days = new int[]{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2 && utility.isLeapYear(year))
		{
			days[month] = 29;
		}
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		int d = utility.day(month, 1, year);
		for (int i = 0; i < d; i++)
			System.out.print("   ");
		for (int i = 1; i <= days[month]; i++) {
			System.out.printf("%2d ", i);
			if (((i + d) % 7 == 0) || (i == days[month]))
				System.out.println();
		}

	}
}
