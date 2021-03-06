package com.booksys.ui;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksys.data.Data;
import com.booksys.io.IOStream;
import com.booksys.utils.Utils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {
	private static final long serialVersionUID = 2889395007416391620L;
	private JPanel contentPane;
	private JTable bookTable;
	private JTable readerTable;
	private JTable borrowTable;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IOStream.bookReader(Data.bookList);
					IOStream.borrowReader(Data.borrowList);
					Data.initData("admin");
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReaderFrame.class.getResource("/com/booksys/ui/image/library.ico")));
		setResizable(false);
		setLocation(new Point(100, 200));
		setTitle("管理页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(608, 437);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 602, 23);
		contentPane.add(menuBar);
		
		JMenu sysMenu = new JMenu("功能");
		menuBar.add(sysMenu);
		
		JMenuItem exitItem = new JMenuItem("退出系统");
		exitItem.setIcon(null);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(" - " + Utils.getCurrentTime("time") + " | 主服务：退出");
				System.exit(0);
			}
		});
		
		JMenuItem logOutItem = new JMenuItem("注销登录");
		logOutItem.setIcon(null);
		logOutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JOptionPane.showMessageDialog(null, "注销成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				Data.cleanData();
				System.out.println(" - " + Utils.getCurrentTime("time") + " | 认证服务：角色注销完毕");
				LoginFrame.init();
			}
		});
		sysMenu.add(logOutItem);
		sysMenu.add(exitItem);
		
		JMenu helpMenu = new JMenu("帮助");
		menuBar.add(helpMenu);
		
		JMenuItem aboutItem = new JMenuItem("关于");
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutDialog().init();
			}
		});
		aboutItem.setIcon(null);
		helpMenu.add(aboutItem);
		
		JScrollPane bookScrollPane = new JScrollPane();
		bookScrollPane.setBounds(0, 49, 602, 164);
		contentPane.add(bookScrollPane);
		
		bookTable = new JTable(Data.bookData, Data.bookTitle);
		bookTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookTable.getTableHeader().setReorderingAllowed(false);
		bookTable.setEnabled(false);
		bookScrollPane.setViewportView(bookTable);
		
		JScrollPane readerScrollPane = new JScrollPane();
		readerScrollPane.setBounds(0, 218, 371, 190);
		contentPane.add(readerScrollPane);
		
		readerTable = new JTable(Data.readerData, Data.readerTitle);
		readerTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		readerTable.getTableHeader().setReorderingAllowed(false);
		readerTable.setEnabled(false);
		readerScrollPane.setViewportView(readerTable);
		
		JScrollPane borrowScrollPane = new JScrollPane();
		borrowScrollPane.setBounds(375, 218, 227, 190);
		contentPane.add(borrowScrollPane);
		
		borrowTable = new JTable(Data.borrowData, Data.borrowTitle);
		borrowTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		borrowTable.getTableHeader().setReorderingAllowed(false);
		borrowTable.setEnabled(false);
		borrowScrollPane.setViewportView(borrowTable);
		
		JButton addBookBtn = new JButton("添加书目");
		addBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookDialog.init();
				bookTable.updateUI();
			}
		});
		addBookBtn.setBounds(0, 24, 93, 23);
		contentPane.add(addBookBtn);
		
		JButton flashBtn = new JButton("刷新数据");
		flashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTable.updateUI();
			}
		});
		flashBtn.setBounds(499, 24, 93, 23);
		contentPane.add(flashBtn);
	}
}
