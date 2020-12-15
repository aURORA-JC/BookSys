/** 
* @File ReturnDialog.java
* @Author Aurora_JC
* @Time 2020年12月16日 上午12:24:51 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksys.book.Book;
import com.booksys.data.Data;
import com.booksys.operation.Operation;

public class ReturnDialog extends JDialog {
	private static final long serialVersionUID = 5805277036201255114L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void init(long l) {
		try {
			ReturnDialog dialog = new ReturnDialog(l);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReturnDialog(long l) {
		setTitle("书本归还");
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox<String> bookBox = new JComboBox<String>();
		for (int i = 0; i < Data.borrowData.size(); i ++) {
			Vector<String> info = Data.borrowData.get(i);
			Book book = Data.bookList.searchNode(info.get(0)).getBookData();
			bookBox.addItem(book.getBookName() + " - " + book.getBookAuthor() + " - " + book.getBookNo());
		}
		
		bookBox.setBounds(40, 30, 348, 23);
		contentPanel.add(bookBox);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] name = bookBox.getSelectedItem().toString().split(" - ");
						Operation.returnBook(Data.borrowList, Data.bookList, Data.readerList, name[2], l);
						JOptionPane.showMessageDialog(null, "还书成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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
		}
	}

}
