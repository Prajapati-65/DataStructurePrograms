package com.bridgelabz.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.FileSystemNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.Programs.Account;

/**
 * @author OmPrajapati
 *
 */
public class Utility {

	Scanner scanner = new Scanner(System.in);
	BufferedReader br;

	/**
	 * constructor to initialize bufferedReader
	 */
	public Utility() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * take input word
	 */
	public String inputString() {
		try {
			return br.readLine();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return "";
	}

	/**
	 * Take Integer Input
	 *
	 */
	public int inputInteger() {
		try {
			try {
				return Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return 0;
	}

	/**
	 * Take Double Input
	 */
	public double inputDouble() {
		try {
			try {
				return Double.parseDouble(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return 0.0;
	}

	/**
	 * create a method to sort a string array
	 * 
	 */
	public String[] sortArrayString(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length - 1; j++) {
				if (strings[j].compareTo(strings[j + 1]) > 0) {
					String temp = strings[j];
					strings[j] = strings[j + 1];
					strings[j + 1] = temp;
				}
			}
		}
		return strings;
	}

	/**
	 * Binary Search for integer
	 */
	public int binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (key < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Binary Search for String
	 */

	public int binarySearchString(String[] names, String key) {
		int first = 0;
		int last = names.length;
		while (first < last) {
			int mid = (first + last) / 2;
			if (key.compareTo(names[mid]) < 0) {
				last = mid;
			} else if (key.compareTo(names[mid]) > 0) {
				first = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * m - month of the year d - day of the month y - year day of the week
	 */
	public int dayOfWeek(double M, double D, double Y) {
		double y0 = Y - ((14 - M) / 12);
		double x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		double m0 = M + 12 * ((14 - M) / 12) - 2;
		double d0 = (D + x + (31 * m0 / 12)) % 7;
		return (int) d0;
	}

	/**
	 * 
	 * @param create
	 *            a function of factorial number
	 * 
	 */
	public int fact(int number) {

		if (number > 1) {
			return (number * fact(number - 1));
		}
		return 1;
	}
	
	public  boolean isPrime(int num) {

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;

	}

	/**
	 * @param create
	 *            a function of catalan number Cn=2n!/(n+1)!n!;
	 * 
	 */
	public void catalanNumber(int n) {
		int Cn = fact(2 * n) / (fact(n + 1) * fact(n));
		System.out.println("Number Of Binary Search Tree : " + Cn);
	}

	/**
	 * 
	 * monthly payment from given P, Y & R values
	 */
	public int monthlyPayment(double P, double Y, double R) {
		double r = R / (12 * 100);
		double n = -1 * 12 * Y;
		double payment = (P * r) / (1 - Math.pow((1 + r), n));
		return (int) payment;
	}

	/**
	 * @param month
	 *            month number of the year
	 * @param year
	 *            fills array of month
	 */
	int[][] daysArray;
	int maxDays, maxWeeks;

	public void fillArray(int month, int year) {
		String yearAndMonth = month < 10 ? "0" + String.valueOf(month) + " " + String.valueOf(year)
				: String.valueOf(month) + String.valueOf(year);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
		try {
			Date date = simpleDateFormat.parse("01 " + yearAndMonth);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			maxWeeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
			daysArray = new int[maxWeeks][maxDays];

			for (int day = 1; day <= maxDays; day++) {
				String dayNumString = day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);
				date = simpleDateFormat.parse(dayNumString + " " + yearAndMonth);
				cal.setTime(date);
				int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
				int dayNum = cal.get(Calendar.DAY_OF_WEEK);
				daysArray[weekNum - 1][dayNum - 1] = day;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * prints array
	 */
	public void print() {
		for (int week = 0; week < maxWeeks; week++) {
			for (int day = 0; day < 7; day++) {
				if (daysArray[week][day] != 0) {
					System.out.print(daysArray[week][day] + "\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	/**
	 * 
	 */
	Queue queue = new LinkedList<>();

	public void deposit() {
		int balance = 0;
		System.out.println("Enter the account number:");
		long accountno = scanner.nextLong();
		System.out.println("Enter the name of account holder:");
		String name = scanner.next();
		System.out.println("Enter the amount to Deposited:");
		int deposit = scanner.nextInt();
		Account account = new Account(accountno, name, deposit);
		queue.add(account);
		balance = balance + deposit;
		System.out.println(balance);
	}

	/**
	 * 
	 */
	public void withdraw() {
		System.out.println("Enter the account number:");
		long accountno = scanner.nextLong();
		System.out.println("Enter the name of account holder:");
		String name = scanner.next();
		System.out.println("Enter the amount to Withdraw:");
		int withdraw = scanner.nextInt();
		Account account = new Account(accountno, name, withdraw);
		queue.add(account);
		int balance = 0;
		if (balance < withdraw) {
			System.out.println("Balance is Low");
		} else {
			balance = balance - withdraw;
		}
	}

	/**
	 * 
	 */
	public void removeFromQueue() {
		if (queue.isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			queue.remove();
		}
	}

	/**
	 * @param input month
	 * @param input day
	 * @param input year
	 * @return integer
	 */
	public int day(int month, int day, int year) {
		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31 * m) / 12) % 7;
		return d;
	}

	/**
	 * @param input year
	 * @return boolean
	 */
	public boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0))
			return true;
		if (year % 400 == 0)
			return true;
		return false;
	}
}
