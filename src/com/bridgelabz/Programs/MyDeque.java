package com.bridgelabz.Programs;

/**
 * @author OmPrajapati
 *
 * @param <Genric Type>
 */
public class MyDeque<T> {

	MyLinkedList<T> myLinkedList;

	public MyDeque() {
		myLinkedList = new MyLinkedList<T>();
	}

	public void addFront(T data) {
		myLinkedList.insert(0, data);
	}

	public void addRear(T data) {
		myLinkedList.add(data);
	}

	public T removeFront() {
		return myLinkedList.pop(0);
	}

	public T removeRear() {
		return myLinkedList.pop();
	}

	public boolean isEmpty() {
		return myLinkedList.isEmpty();
	}

	public int size() {
		return myLinkedList.size();
	}

	public boolean checkPalindrome(String stringToCheck) {
		MyDeque<Character> myDeque = new MyDeque<Character>();
		char[] stringCharacterArray = stringToCheck.toCharArray();
		for (char character : stringCharacterArray) {
			myDeque.addFront(character);
		}

		for (char character : stringCharacterArray) {
			if (character != myDeque.removeFront()) {
				return false;
			}
		}
		return true;
	}
}
