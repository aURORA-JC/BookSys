/** 
* @File Operation.java
* @Author Aurora_JC
* @Time 2020年12月15日 上午11:40:12 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.operation;

import java.util.Vector;

import com.booksys.book.Book;
import com.booksys.data.Data;
import com.booksys.io.IOStream;
import com.booksys.reader.Reader;
import com.booksys.storage.LinkedList;
import com.booksys.storage.Node;
import com.booksys.utils.Utils;

public class Operation {
	public static void getBookData(LinkedList l) {
		Node tmp = l.getHeadNode();
		while(tmp != null) {
			Book book = tmp.getBookData();
			Vector<String> b = new Vector<String>();
			b.add(book.getBookNo());
			b.add(book.getBookName());
			b.add(book.getBookAuthor());
			b.add(String.valueOf(book.getBookInShopNum()));
			b.add(String.valueOf(book.getBookNum()));
			Data.bookData.add(b);
			tmp = tmp.getNextNode();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 前端服务：书本信息载入完毕");
	}
	
	public static void getReaderDate(LinkedList l) {
		Node tmp = l.getHeadNode();
		while(tmp != null) {
			Reader reader = tmp.getReaderData();
			Vector<String> r = new Vector<String>();
			r.add(String.valueOf(reader.getReaderId()));
			r.add(reader.getReaderPasswd());
			if (reader.getReaderLevel() == 1) {
				r.add("读者");
			} else {
				r.add("管理员");
			}
			Data.readerData.add(r);
			tmp = tmp.getNextNode();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 前端服务：读者信息载入完毕");
	}
	
	public static void getBorrowData(LinkedList l) {
		Node tmp = l.getHeadNode();
		while (tmp != null) {
			Vector<String> b = new Vector<String>();
			b.add(tmp.getBookNo());
			b.add(String.valueOf(tmp.getReaderNo()));
			Data.borrowData.add(b);
			tmp = tmp.getNextNode();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 前端服务：借阅信息载入完毕");
	}
	
	public static void borrowBook(LinkedList borl, LinkedList bool, LinkedList real, String s, int id) {
		Book book = bool.searchNode(s).getBookData();
		Reader reader = real.searchNode(id).getReaderData(); 
		borl.addNode(new Node(book.getBookNo(), reader.getReaderId()));
		book.setBookInShopNum(book.getBookInShopNum() - 1);
		IOStream.borrowAdder(reader, book);
		IOStream.bookUpdater(book);
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 库存管理：借阅完毕");
	}
	
	public static void returnBook(LinkedList borl, LinkedList bool, LinkedList real, String s, int id) {
		borl.deleteNode(borl.searchNodeIndex(s, id));
		Book book = bool.searchNode(s).getBookData();
		book.setBookInShopNum(book.getBookInShopNum() + 1);
		IOStream.borrowDeleter(real.searchNode(id).getReaderData(), bool.searchNode(s).getBookData());
		IOStream.bookUpdater(book);
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 库存管理：还书完毕");
	}
	
	public static void addBook(LinkedList l, Book b) {
		if (l.searchNodeIndex(b.getBookNo()) == -1) {
			l.addNode(new Node(b));
			IOStream.bookAdder(b);
		} else {
			Book book = l.searchNode(b.getBookNo()).getBookData();
			book.setBookInShopNum(book.getBookInShopNum() + b.getBookInShopNum());
			book.setBookNum(book.getBookNum() + b.getBookNum());
			IOStream.bookUpdater(book);
		}
		Data.bookData.clear();
		getBookData(l);
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 库存管理：添加完毕");
	}
	
	public static boolean createReader(LinkedList l, int id, String pass) {
		if (l.searchNode(id) == null) {
			Reader reader = new Reader(id, Utils.recodePasswd(pass), 1);
			l.addNode(new Node(reader));
			IOStream.readerAdder(reader);
			System.out.println(" - " + Utils.getCurrentTime("time") + " | 用户服务：读者创建成功");
			return true;
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 用户服务：用户名已存在");
		return false;
	}
}
