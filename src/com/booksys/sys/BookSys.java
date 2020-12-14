/** 
* @File BookSys.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����9:51:01 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.sys;

import com.booksys.io.IOStream;
import com.booksys.storage.LinkedList;

public class BookSys {
	static LinkedList boo = new LinkedList();
	static LinkedList rea = new LinkedList();
	static LinkedList bor = new LinkedList();
	
	public static void initData() {	
		IOStream.bookReader(boo);
		IOStream.readerReader(rea);
		IOStream.borrowReader(bor);
		loginPage();
	}
	
	public static void loginPage() {
		System.out.println("██╗     ██╗██████╗ ██████╗  █████╗ ██████╗ ██╗   ██╗██████╗");
		System.out.println("██║     ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝╚════██╗");
		System.out.println("██║     ██║██████╔╝██████╔╝███████║██████╔╝ ╚████╔╝   ▄███╔╝");
		System.out.println("██║     ██║██╔══██╗██╔══██╗██╔══██║██╔══██╗  ╚██╔╝    ▀▀══╝ ");
		System.out.println("███████╗██║██████╔╝██║  ██║██║  ██║██║  ██║   ██║     ██╗   ");
		System.out.println("╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝     ╚═╝   ");
		System.out.println("=============================================================");
		System.out.println("欢迎使用图书管理系统，Version 0.8.1");
	}
	
	public static void main(String[] args) {
		initData();
	}
	
	
}
