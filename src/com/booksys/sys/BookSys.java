/** 
* @File BookSys.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����9:51:01 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.sys;

import com.booksys.book.Book;

public class BookSys {
	public static void main(String[] args) {
		Book b = new Book(null, null, null, 0, 0);
		System.out.println(b.getBookName() + b.getBookNo() + b.getBookAuthor() + b.getBookNum() + b.getBookInShopNum());
	}

}
