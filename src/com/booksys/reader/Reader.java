/** 
* @File Reader.java
* @Author Aurora_JC
* @Time 2020年12月14日 上午10:33:57 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.reader; 

public class Reader {
	private int readerId;
	private String readerPasswd;
	private int readerLevel;
	
	public Reader(int _readerId, String _readerPasswd, int _readerLevel) {
		this.readerId = _readerId;
		this.readerPasswd = _readerPasswd;
		this.readerLevel = _readerLevel;
	}
	
	public int getReaderId() {
		return this.readerId;
	}
	
	public String getReaderPasswd() {
		return this.readerPasswd;
	}
	
	public int getReaderLevel() {
		return this.readerLevel;
	}
	
	public boolean borrowBook() {
		return false;
	}
	
	public boolean returnBook() {
		return false;
	}
	
	public void viewAll() {
		
	}
}
