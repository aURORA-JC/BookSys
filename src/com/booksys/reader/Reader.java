/** 
* @File Reader.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����10:33:57 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.reader; 

public class Reader {
	private long readerId;
	private String readerPasswd;
	private int readerLevel;
	
	public Reader(long _readerId, String _readerPasswd, int _readerLevel) {
		this.readerId = _readerId;
		this.readerPasswd = _readerPasswd;
		this.readerLevel = _readerLevel;
	}
	
	public long getReaderId() {
		return this.readerId;
	}
	
	public String getReaderPasswd() {
		return this.readerPasswd;
	}
	
	public int getReaderLevel() {
		return this.readerLevel;
	}
	
	public void setReaderPasswd(String _newPasswd) {
		this.readerPasswd = _newPasswd;
	}
	
	public void setReaderLevel(int _newLevel) {
		this.readerLevel = _newLevel;
	}
}
