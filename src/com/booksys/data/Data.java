/** 
* @File Data.java
* @Author Aurora_JC
* @Time 2020年12月15日 下午12:35:55 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.data;

import java.util.Vector;

import com.booksys.operation.Operation;
import com.booksys.storage.LinkedList;

public class Data {
	public static LinkedList bookList = new LinkedList();
	public static LinkedList readerList = new LinkedList();
	public static LinkedList borrowList = new LinkedList();
	
	public static Vector<Vector<String>> bookData = new Vector<Vector<String>>();
	public static Vector<Vector<String>> readerData = new Vector<Vector<String>>();
	public static Vector<Vector<String>> borrowData = new Vector<Vector<String>>();
	
	public static Vector<String> bookTitle = new Vector<String>();
	public static Vector<String> readerTitle = new Vector<String>();
	public static Vector<String> borrowTitle = new Vector<String>();
	
	public static void initDataTitle() {
		bookTitle.add("书号");
		bookTitle.add("书名");
		bookTitle.add("作者");
		bookTitle.add("现存量");
		bookTitle.add("库存量");
		
		readerTitle.add("读者ID");
		readerTitle.add("密码");
		readerTitle.add("级别");
		
		borrowTitle.add("读者ID");
		borrowTitle.add("借阅书号");
		
		Operation.getBookData(bookList);
		Operation.getReaderDate(readerList);
		Operation.getBorrowData(borrowList);
	}
}