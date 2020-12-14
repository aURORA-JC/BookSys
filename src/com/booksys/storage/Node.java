/** 
* @File Node.java
* @Author Aurora_JC
* @Time 2020年12月14日 上午11:00:25 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.storage; 

public class Node {
	private String bookNo;
	private int readerNo;
	private Node next;
	
	public Node(String _bookNo, int _readerNo) {
		this.bookNo = _bookNo;
		this.readerNo = _readerNo;
	}
}
