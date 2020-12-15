package com.booksys.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksys.book.Book;
import com.booksys.data.Data;
import com.booksys.operation.Operation;
import com.booksys.utils.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddBookDialog extends JDialog {
	private static final long serialVersionUID = -4672813069265232137L;
	private final JPanel contentPanel = new JPanel();
	private JTextField noField;
	private JTextField nameField;
	private JTextField authorField;
	private JTextField numField;
	private JLabel noLabel;
	private JLabel nameLabel;
	private JLabel authorLabel;
	private JLabel numLabel;

	/**
	 * Launch the application.
	 */
	public void init() {
		try {
			AddBookDialog dialog = new AddBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddBookDialog() {
		setTitle("添加书目信息");
		setResizable(false);
		setBounds(100, 100, 210, 250);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		noField = new JTextField();
		noField.setBounds(50, 10, 140, 30);
		contentPanel.add(noField);
		noField.setColumns(25);
		
		nameField = new JTextField();
		nameField.setBounds(50, 50, 140, 30);
		contentPanel.add(nameField);
		nameField.setColumns(25);
		
		authorField = new JTextField();
		authorField.setBounds(50, 90, 140, 30);
		contentPanel.add(authorField);
		authorField.setColumns(25);
		
		numField = new JTextField();
		numField.setBounds(50, 130, 140, 30);
		contentPanel.add(numField);
		numField.setColumns(25);
		
		noLabel = new JLabel("书号");
		noLabel.setBounds(10, 17, 54, 15);
		contentPanel.add(noLabel);
		
		nameLabel = new JLabel("书名");
		nameLabel.setBounds(10, 57, 54, 15);
		contentPanel.add(nameLabel);
		
		authorLabel = new JLabel("作者");
		authorLabel.setBounds(10, 97, 54, 15);
		contentPanel.add(authorLabel);
		
		numLabel = new JLabel("入库量");
		numLabel.setBounds(10, 137, 54, 15);
		contentPanel.add(numLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("提交");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String no = noField.getText();
						String name = nameField.getText();
						String author = authorField.getText();
						int num = Integer.parseInt(numField.getText());
						if(Utils.isBookNo(no) && num >= 0) {
							Operation.addBook(Data.bookList, new Book(no, name, author, num));
							JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "录入信息非法！", "添加失败", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
