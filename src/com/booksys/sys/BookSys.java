/** 
* @File BookSys.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����9:51:01 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.sys;

import java.awt.EventQueue;

import com.booksys.io.IOStream;
import com.booksys.storage.LinkedList;
import com.booksys.ui.LoginFrame;
import com.booksys.utils.Utils;

public class BookSys {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
