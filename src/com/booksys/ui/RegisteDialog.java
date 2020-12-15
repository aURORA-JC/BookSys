package com.booksys.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.booksys.data.Data;
import com.booksys.operation.Operation;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RegisteDialog extends JDialog {
	private static final long serialVersionUID = 4113403116028133164L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JPasswordField passwdField;
	private JPasswordField rePasswdField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public void init() {
		try {
			RegisteDialog dialog = new RegisteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisteDialog() {
		setResizable(false);
		setTitle("读者注册");
		setBounds(100, 100, 250, 250);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			idField = new JTextField();
			idField.setBounds(85, 30, 140, 30);
			contentPanel.add(idField);
			idField.setColumns(10);
		}
		
		passwdField = new JPasswordField();
		passwdField.setBounds(85, 70, 140, 30);
		contentPanel.add(passwdField);
		
		rePasswdField = new JPasswordField();
		rePasswdField.setBounds(85, 110, 140, 30);
		contentPanel.add(rePasswdField);
		{
			lblNewLabel = new JLabel("手机号");
			lblNewLabel.setBounds(10, 37, 55, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("密码");
			lblNewLabel_1.setBounds(10, 77, 55, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("重复输入");
			lblNewLabel_2.setBounds(10, 117, 55, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JButton okButton = new JButton("注册");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							long id = Long.parseLong(idField.getText());
							String passwd = String.valueOf(passwdField.getPassword());
							String repasswd = String.valueOf(rePasswdField.getPassword());
							if (passwd.equals(repasswd) && id >= 10000000000l && id <= 19999999999l) {
								if (Operation.createReader(Data.readerList, id, passwd)) {
									JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
									ReaderFrame.init(id);
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "手机号已存在！", "添加失败", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "录入信息非法！", "添加失败", JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
