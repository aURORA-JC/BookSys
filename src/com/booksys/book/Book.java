/** 
* @File Book.java
* @Author Aurora_JC
* @Time 2020年12月14日 上午9:41:18 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.book; 

public class Book {
	private String bookNo;
	private String bookName;
	private String bookAuthor;
	private int bookInShopNum;
	private int bookNum;

	public Book(String _bookNo, String _bookName, String _bookAuthor, int _bookInShopNum, int _bookNum) {
		bookNo = _bookNo;
		bookName = _bookName;
		bookAuthor = _bookAuthor;
		bookInShopNum = _bookInShopNum;
		bookNum = _bookNum;
	}
	
	public String getBookNo() {
		return bookNo;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public int getBookInShopNum() {
		return bookInShopNum;
	}
	
	public int getBookNum() {
		return bookNum;
	}
};
