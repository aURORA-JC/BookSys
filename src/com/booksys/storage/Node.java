/** 
* @File Node.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����11:00:25 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.storage;

import com.booksys.book.Book;
import com.booksys.reader.Reader;

public class Node {
	private String bookNo;
	private int readerNo;
	private Book bookData;
	private Reader readerData;
	private Node next;
	
	public Node(Book _bookData) {
		this.bookData = _bookData;
	}
	
	public Node(Reader _readerData) {
		this.readerData = _readerData;
	}
	
	public Node(String _bookNo, int _readerNo) {
		this.bookNo = _bookNo;
		this.readerNo = _readerNo;
	}

	public String getBookNo() {
		return this.bookNo;
	}
	
	public int getReaderNo() {
		return this.readerNo;
	}
	
	public Book getBookData() {
		return this.bookData;
	}
	
	public Reader getReaderData() {
		return readerData;
	}
	
	public Node getNextNode() {
		return this.next;
	}
	
	public void setBookNo(String _bNo) {
		this.bookNo = _bNo;
	}
	
	public void setReaderNo(int _rNo) {
		this.readerNo = _rNo;
	}
	
	public void setBookData(Book _bData) {
		this.bookData = _bData;
	}
	
	public void setReaderData(Reader readerData) {
		this.readerData = readerData;
	}
	
	public void setNextNode(Node _n) {
		this.next = _n;
	}
}
