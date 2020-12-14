/** 
* @File BookSys.java
* @Author Aurora_JC
* @Time 2020年12月14日 上午9:51:01 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.sys;

import com.booksys.book.Book;
import com.booksys.utils.Utils;

public class BookSys {
	public static void main(String[] args) {
		System.out.println(Utils.isBookNum("ISBN 978-7-115-37950-4"));
		Book b = new Book("ISBN 978-7-115-37950-4", "数据结构C语言版", "严蔚敏等", 0, 0);
		System.out.println(Utils.recodePassword("123"));
		System.out.println(b.getBookName() + b.getBookNo() + b.getBookAuthor() + b.getBookNum() + b.getBookInShopNum());
	}
	
	
}
