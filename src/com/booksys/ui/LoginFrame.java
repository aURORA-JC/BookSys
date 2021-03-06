/** 
* @File LoginFrame.java
* @Author Aurora_JC
* @Time 2020年12月14日 下午10:30:11 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.booksys.data.Data;
import com.booksys.io.IOStream;
import com.booksys.utils.Utils;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = -4020831753619395032L;
	private JTextField usrNameField;
	private JPasswordField passwdField;

	public static void init() { 
		System.out.println("██╗     ██╗██████╗ ██████╗  █████╗ ██████╗ ██╗   ██╗██████╗");
		System.out.println("██║     ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝╚════██╗");
		System.out.println("██║     ██║██████╔╝██████╔╝███████║██████╔╝ ╚████╔╝   ▄███╔╝");
		System.out.println("██║     ██║██╔══██╗██╔══██╗██╔══██║██╔══██╗  ╚██╔╝    ▀▀══╝ ");
		System.out.println("███████╗██║██████╔╝██║  ██║██║  ██║██║  ██║   ██║     ██╗   ");
		System.out.println("╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝     ╚═╝   ");
		System.out.println("=============================================================");
		System.out.println("欢迎使用图书管理系统，Version 0.8.1 | " + Utils.getCurrentTime(""));
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
	
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		this.setIconImage(new ImageIcon(LoginFrame.class.getResource("/com/booksys/ui/image/library.ico")).getImage());
		getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("图书管理系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(475, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 475, 300);
		getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		usrNameField = new JTextField();
		usrNameField.setBounds(140, 115, 225, 30);
		loginPanel.add(usrNameField);
		usrNameField.setColumns(10);
		
		passwdField = new JPasswordField();
		passwdField.setBounds(140, 165, 225, 30);
		loginPanel.add(passwdField);
		passwdField.setColumns(10);
		
		JButton loginBtn = new JButton("登录");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = Long.parseLong(usrNameField.getText());
				String pass = String.valueOf(passwdField.getPassword());
				switch(Utils.authentication(id, pass, Data.readerList)) {
					case 1: {
						dispose();
						ReaderFrame.init(id);
					}break;
					case 0: {
						dispose();
						AdminFrame.init();
					}break;
					case -1: {
						JOptionPane.showMessageDialog(null, "用户名或密码错误！", "认证失败", JOptionPane.ERROR_MESSAGE);
					}break;
				}
			}
		});
		loginBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		loginBtn.setBounds(90, 215, 127, 25);
		loginPanel.add(loginBtn);
		
		JLabel usrLabel = new JLabel("用户名");
		usrLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		usrLabel.setBounds(75, 120, 45, 15);
		loginPanel.add(usrLabel);
		
		JLabel passwdLabel = new JLabel("密码");
		passwdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		passwdLabel.setBounds(82, 173, 30, 14);
		loginPanel.add(passwdLabel);
		
		JLabel sysLogo = new JLabel("");
		sysLogo.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/booksys/ui/image/logo.png")));
		sysLogo.setBounds(72, 25, 300, 55);
		loginPanel.add(sysLogo);
		
		JButton regBtn = new JButton("注册");
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisteDialog().init();
				dispose();
			}
		});
		regBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		regBtn.setBounds(235, 215, 127, 25);
		loginPanel.add(regBtn);
		
		IOStream.readerReader(Data.readerList);
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 前端服务：登录界面初始化完成");
	}
}
