package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class DayOfWeek {

	public static void main(String[] args) {
		Utility u = new Utility();
		System.out.println("Enter the month :");
		double month = u.inputDouble();
		System.out.println("Enter the day :");
		double day = u.inputDouble();
		System.out.println("Enter the year :");
		double year = u.inputDouble();
		System.out.println("Day of week is :");
		System.out.println(u.dayOfWeek(month, day, year));
	}
}
