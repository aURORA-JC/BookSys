/** 
* @File BookSys.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����9:51:01 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.sys;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.booksys.ui.LoginFrame;

public class BookSys {
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() { 
			public void run() { 
				try { 
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true); 
				} catch (Exception e) { 
					e.printStackTrace(); 
				}
			} 
		});
	}
}
