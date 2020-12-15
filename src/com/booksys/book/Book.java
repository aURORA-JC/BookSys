/** 
* @File Book.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����9:41:18 
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

	public Book(String _bookNo, String _bookName, String _bookAuthor, int _bookNum) {
		this.bookNo = _bookNo;
		this.bookName = _bookName;
		this.bookAuthor = _bookAuthor;
		this.bookNum = _bookNum;
		this.bookInShopNum = this.bookNum;
	}
	
	public Book(String _bookNo, String _bookName, String _bookAuthor, int _bookInShopNum, int _bookNum) {
		this.bookNo = _bookNo;
		this.bookName = _bookName;
		this.bookAuthor = _bookAuthor;
		this.bookInShopNum = _bookInShopNum;
		this.bookNum = _bookNum;
	}
	
	public String getBookNo() {
		return this.bookNo;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	
	public String getBookAuthor() {
		return this.bookAuthor;
	}
	
	public int getBookInShopNum() {
		return this.bookInShopNum;
	}
	
	public int getBookNum() {
		return this.bookNum;
	}
	
	public void setBookInShopNum(int _num) {
		this.bookInShopNum = _num;
	}
	
	public void setBookNum(int _num) {
		this.bookNum = _num;
	}
	
	public boolean equals(Book b) {
		if (b.getBookNo() == this.bookNo && b.getBookName() == this.bookName) {
			return true;
		} else {
			return false;
		}
	}
};
