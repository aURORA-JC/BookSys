/** 
* @File IOStream.java
* @Author Aurora_JC
* @Time 2020年12月14日 下午3:54:49 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.booksys.book.Book;
import com.booksys.reader.Reader;
import com.booksys.storage.LinkedList;
import com.booksys.storage.Node;
import com.booksys.utils.Utils;

public class IOStream {
	private static Document doc;
	
	public static void bookReader(LinkedList l) {
		try {
			doc = getDocument("Books.xml");
			Element root = doc.getRootElement();
			List<Element> elements = root.elements("book");
			for (Element el : elements) {
				String no = el.elementText("no");
				String name = el.elementText("name");
				String author = el.elementText("author");
				int inshop = Integer.parseInt(el.elementText("inshop"));
				int total = Integer.parseInt(el.elementText("total"));
				l.addNode(new Node(new Book(no, name, author, inshop, total)));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：书本信息读取完毕");
	}
	
	public static void readerReader(LinkedList l) {
		try {
			doc = getDocument("Readers.xml");
			Element root = doc.getRootElement();
			List<Element> elements = root.elements("reader");
			for (Element el : elements) {
				int id = Integer.parseInt(el.elementText("id"));
				String passwd = el.elementText("passwd");
				int level = Integer.parseInt(el.elementText("level"));
				l.addNode(new Node(new Reader(id, passwd, level)));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：读者信息读取完毕");
	}
	
	public static void borrowReader(LinkedList l) {
		try {
			doc = getDocument("Borrow.xml");
			Element root = doc.getRootElement();
			List<Element> elements = root.elements("ticket");
			for (Element el : elements) {
				String no = el.elementText("no");
				int id = Integer.parseInt(el.elementText("id"));
				l.addNode(new Node(no, id));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：借书记录读取完毕");
	}
	
	public static void bookAdder(Book b) {
		doc = getDocument("Books.xml");
		Element root = doc.getRootElement();
		Element book = root.addElement("book");
		
		Element no = book.addElement("no");
		no.addText(b.getBookNo());
		Element name = book.addElement("name");
		name.addText(b.getBookName());
		Element author = book.addElement("author");
		author.addText(b.getBookAuthor());
		Element inshop = book.addElement("inshop");
		inshop.addText(String.valueOf(b.getBookInShopNum()));
		Element total = book.addElement("total");
		total.addText(String.valueOf(b.getBookNum()));
		
		xmlSaver("Books.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：书本信息添加完毕");
	}
	
	public static void readerAdder(Reader r) {
		doc = getDocument("Readers.xml");
		Element root = doc.getRootElement();
		Element reader = root.addElement("reader");
		
		Element no = reader.addElement("id");
		no.addText(String.valueOf(r.getReaderId()));
		Element passwd = reader.addElement("passwd");
		passwd.addText(r.getReaderPasswd());
		Element level = reader.addElement("level");
		level.addText(String.valueOf(r.getReaderLevel()));
		
		xmlSaver("Readers.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：读者信息添加完毕");
	}
	
	public static void borrowAdder(Reader r, Book b) {
		doc = getDocument("Borrow.xml");
		Element root = doc.getRootElement();
		Element ticket = root.addElement("ticket");
		
		Element no = ticket.addElement("no");
		no.addText(b.getBookNo());
		Element id = ticket.addElement("id");
		id.addText(String.valueOf(r.getReaderId()));
		
		xmlSaver("Borrow.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：借书记录添加完毕");
	}
	
	public static void bookDeleter(Book b) {
		doc = getDocument("Books.xml");
		Element root = doc.getRootElement();
		List<Element> elements = root.elements("book");
		for (Element el : elements) {
			String no = el.elementText("no");
			if (no.equals(b.getBookNo())) {
				el.getParent().remove(el);
				break;
			}
		}
		
		xmlSaver("Books.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：书本信息删除完毕");
	}
	
	public static void readerDeleter(Reader r) {
		doc = getDocument("Readers.xml");
		Element root = doc.getRootElement();
		List<Element> elements = root.elements("reader");
		for (Element el : elements) {
			int id = Integer.parseInt(el.elementText("id"));
			if (id == r.getReaderId()) {
				el.getParent().remove(el);
				break;
			}
		}
		
		xmlSaver("Readers.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：读者信息删除完毕");
	}
	
	public static void borrowDeleter(Reader r, Book b) {
		doc = getDocument("Borrow.xml");
		Element root = doc.getRootElement();
		List<Element> elements = root.elements("ticket");
		for (Element el : elements) {
			int id = Integer.parseInt(el.elementText("id"));
			String no = el.elementText("no");
			if (id == r.getReaderId() && no.equals(b.getBookNo())) {
				el.getParent().remove(el);
				break;
			}
		}
		
		xmlSaver("Borrows.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：借书记录删除完毕");
	}
	
	public static void bookUpdater(Book b) {
		doc = getDocument("Books.xml");
		Element root = doc.getRootElement();
		List<Element> elements = root.elements("book");
		for (Element el : elements) {
			String no = el.elementText("no");
			List<Element> chels = el.elements();
			if (no.equals(b.getBookNo())) {
				for (Element chel : chels) {
					if (chel.getName().equals("inshop")) {
						chel.setText(String.valueOf(b.getBookInShopNum()));
					}
					if (chel.getName().equals("total")) {
						chel.setText(String.valueOf(b.getBookNum()));
					}
				}
				break;
			}
		}
		
		xmlSaver("Books.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：书本信息更新完毕");
	}
	
	public static void readerUpdate(Reader r) {
		doc = getDocument("Readers.xml");
		Element root = doc.getRootElement();
		List<Element> elements = root.elements("reader");
		for (Element el : elements) {
			int id = Integer.parseInt(el.elementText("id"));
			List<Element> chels = el.elements();
			if (id == r.getReaderId()) {
				for (Element chel : chels) {
					if (chel.getName().equals("passwd")) {
						chel.setText(r.getReaderPasswd());
					}
					if (chel.getName().equals("level")) {
						chel.setText(String.valueOf(r.getReaderLevel()));
					}
				}
				break;
			}
		}
		
		xmlSaver("Readers.xml");
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：读者信息更新完毕");
	}
	
	public static Document getDocument(String path) {
		Document doc = null;
		try {
			SAXReader sr = new SAXReader();
			File file = new File(path);
			doc = sr.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：Document对象读取完毕");
		return doc;
	}
	
	public static void xmlSaver(String path) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(new FileWriter(path), format);
			writer.write(doc);
			System.out.println(" - " + Utils.getCurrentTime("time") + " | IO服务：文件写入完毕");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
