/** 
* @File AboutDialog.java
* @Author Aurora_JC
* @Time 2020年12月15日 下午9:20:06 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutDialog extends JDialog {
	private static final long serialVersionUID = 8194645317548388000L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public void init() {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setResizable(false);
		setTitle("关于");
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel logoLabel = new JLabel("");
			logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			logoLabel.setIcon(new ImageIcon(AboutDialog.class.getResource("/com/booksys/ui/image/library.png")));
			logoLabel.setBounds(26, 25, 64, 64);
			contentPanel.add(logoLabel);
		}
		{
			JLabel nameLabel = new JLabel("Book Sys is Library?");
			nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
			nameLabel.setBounds(105, 30, 254, 25);
			contentPanel.add(nameLabel);
		}
		{
			JLabel copyrightLabel = new JLabel("版权所有 (C) 2020 aURORA_JC & LionHeart & VV");
			copyrightLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			copyrightLabel.setBounds(105, 60, 319, 29);
			contentPanel.add(copyrightLabel);
		}
		{
			JLabel thanksLabel = new JLabel("XML 解析组件基于 <dom4j> 封装");
			thanksLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
			thanksLabel.setBounds(105, 90, 254, 15);
			contentPanel.add(thanksLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("确认");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
