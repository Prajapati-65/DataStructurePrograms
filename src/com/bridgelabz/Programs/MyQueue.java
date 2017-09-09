package com.bridgelabz.Programs;

/**
 * @author OmPrajapati
 *
 * @param <Genric Type>
 */
public class MyQueue<T> {

	MyLinkedList<T> myLinkedList;
	
	/**
	 * Constructor
	 */
	public MyQueue(){
		myLinkedList = new MyLinkedList<T>();
	}
	
	/**
	 * @param data - element to be enqueued
	 * adds element a the end of the list
	 */
	public void enqueue(T data){
		myLinkedList.add(data);
	}
	
	/**
	 * removes top element in the list
	 * @returns removed element
	 */
	public T dequeue(){
		return myLinkedList.pop(0);
	}
	
	/**
	 * @returns true if list is empty else returns false
	 */
	public boolean isEmpty(){
		return myLinkedList.isEmpty();
	}
	
	/**
	 * @returns size of the list
	 */
	public int size(){
		return myLinkedList.size();
	}
}
