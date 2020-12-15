package com.booksys.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksys.data.Data;
import com.booksys.io.IOStream;
import com.booksys.utils.Utils;

import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class ReaderFrame extends JFrame {
	private static final long serialVersionUID = 5203364471028691566L;
	private JPanel contentPane;
	private JTable bookTable;
	private JTable borrowTable;

	/**
	 * Launch the application.
	 * @return 
	 */
	public static void init(long l) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IOStream.bookReader(Data.bookList);
					IOStream.personBorrowReader(Data.borrowList, l);
					Data.initData("");
					ReaderFrame frame = new ReaderFrame(l);
					frame.setVisible(true);
					System.out.println(" - " + Utils.getCurrentTime("time") + " | 前端服务：读者界面初始化完成");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReaderFrame(long l) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReaderFrame.class.getResource("/com/booksys/ui/image/library.ico")));
		setResizable(false);
		setLocation(new Point(100, 200));
		setTitle("读者页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(608, 437);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton borrowBtn = new JButton("借阅书籍");
		borrowBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowDialog.init(l);
				bookTable.updateUI();
				borrowTable.updateUI();
			}
		});
		borrowBtn.setBounds(0, 24, 93, 23);
		contentPane.add(borrowBtn);
		
		JButton returnBtn = new JButton("还书");
		returnBtn.setBounds(0, 258, 93, 23);
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnDialog.init(l);
				bookTable.updateUI();
				borrowTable.updateUI();
			}
		});
		contentPane.add(returnBtn);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 602, 23);
		menuBar.setToolTipText("设置");
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
		exitItem.setSelectedIcon(null);
		sysMenu.add(exitItem);
		
		JMenu helpMenu = new JMenu("帮助");
		menuBar.add(helpMenu);
		
		JMenuItem aboutItem = new JMenuItem("关于");
		aboutItem.setIconTextGap(0);
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutDialog().init();
			}
		});
		aboutItem.setIcon(null);
		helpMenu.add(aboutItem);
		
		JScrollPane bookScrollPane = new JScrollPane();
		bookScrollPane.setName("123");
		bookScrollPane.setBounds(0, 49, 602, 207);
		contentPane.add(bookScrollPane);
		
		bookTable = new JTable(Data.bookData, Data.bookTitle);
		bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookTable.getTableHeader().setReorderingAllowed(false);
		bookTable.setEnabled(false);
		bookScrollPane.setViewportView(bookTable);
		
		JScrollPane borrowScrollPane = new JScrollPane();
		borrowScrollPane.setBounds(0, 282, 602, 126);
		contentPane.add(borrowScrollPane);
		
		borrowTable = new JTable(Data.borrowData, Data.borrowTitle);
		borrowTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		borrowTable.getTableHeader().setReorderingAllowed(false);
		borrowTable.setEnabled(false);
		borrowScrollPane.setViewportView(borrowTable);
		
		JButton flashBtn = new JButton("刷新数据");
		flashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTable.updateUI();
				borrowTable.updateUI();
			}
		});
		flashBtn.setBounds(499, 24, 93, 23);
		contentPane.add(flashBtn);
	}
}
