package com.bridgelabz.Programs;

public class PrimeNumber2DArray {

	public static void main(String[] args) {
		int primeNumber[][] = new int[10][100];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <= 100; j++) {
				int num = i * 100 + j;
				if (isprime(num)) {
					primeNumber[i][j] = num;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (primeNumber[i][j] != 0)
					System.out.print(primeNumber[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isprime(int num) {

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;

	}

}
