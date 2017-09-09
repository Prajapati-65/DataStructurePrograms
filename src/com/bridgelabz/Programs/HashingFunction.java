package com.bridgelabz.Programs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class HashingFunction {

	public static void main(String[] args) throws IOException {
		Utility utility = new Utility();
		Scanner scanfile = new Scanner(new File("/home/bridgeit/Public/file/hashingfuntion.txt"));
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (scanfile.hasNext()) {
			list.add(scanfile.nextInt());
		}
		System.out.println(list);
		HashMap<Integer, LinkedList<Integer>> map1 = new HashMap<Integer, LinkedList<Integer>>();
		for (Integer integer : list) {
			System.out.println(integer);
			int slotNo = integer % 11;
			System.out.println("Slot" + slotNo);
			LinkedList<Integer> numberList = map1.get(slotNo);
			if (numberList == null) {
				numberList = new LinkedList<Integer>();
				map1.put(slotNo, numberList);
			}
			numberList.add(integer);
		}
		System.out.println(map1);
		System.out.println("Enter Number you want to search or delete");
		int num = utility.inputInteger();
		int SlotNumber = num % 11;
		map1.get(SlotNumber);

		LinkedList<Integer> numberList1 = map1.get(SlotNumber);
		System.out.println(numberList1);
		if (numberList1.contains(num)) {
			System.out.println("Number is present");
		} else {
			numberList1.add(num);
		}
		System.out.println(map1);
	}
}