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
import com.booksys.utils.Utils;

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
	
	public static void initData(String s) {
		bookTitle.add("书号");
		bookTitle.add("书名");
		bookTitle.add("作者");
		bookTitle.add("现存量");
		bookTitle.add("库存量");
			
		readerTitle.add("读者ID");
		readerTitle.add("密码");
		readerTitle.add("级别");
			
		borrowTitle.add("借阅书号");
		borrowTitle.add("读者ID");
			
		Operation.getBookData(bookList);
		Operation.getReaderDate(readerList);
		Operation.getBorrowData(borrowList);
		
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 数据服务：数据载入完毕");
	}
	
	public static void cleanData() {
		bookList.destroyList();
		readerList.destroyList();
		borrowList.destroyList();
		
		bookData.clear();
		readerData.clear();
		borrowData.clear();
		
		bookTitle.clear();
		readerTitle.clear();
		borrowTitle.clear();
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 数据服务：数据销毁完毕");
	}
}
