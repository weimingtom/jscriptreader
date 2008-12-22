/**
 * @(#)InfoPanel.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/17
 *
 *
 * 脚本模块 
 * 脚本显示窗口
 *
 *
 */
 
package UI;

import Domain.*;
import Service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

	//ImageIcon iconBg;
	//ImageIcon iconCt;
	//ImageIcon iconFm;

class InfoPanel extends JPanel
{
	// 声明控件
	JLabel labelCt;
	JLabel labelBg;
	JLabel labelWd;
	JTextField txtCt;
	JTextField txtBg;
	JTextArea txtWd;
	JScrollPane scrollPane;
	
	public InfoPanel()
	{
		this.setLayout(null);
			
		// 实例化控件
		labelCt = new JLabel("当前人物：");
		labelBg = new JLabel("当前场景：");
		labelWd = new JLabel("当前语言：");
		txtCt = new JTextField();
		txtBg = new JTextField();
		txtWd = new JTextArea();
		scrollPane = new JScrollPane(txtWd);
		
		// 添加控件
		labelCt.setBounds(20,6,65,12);
		add(labelCt);
		txtCt.setBounds(91,3,363,21);
		add(txtCt);
		labelBg.setBounds(20,33,65,12);
		add(labelBg);
		txtBg.setBounds(91,30,363,21);
		add(txtBg);
		labelWd.setBounds(20,60,65,12);
		add(labelWd);
		scrollPane.setBounds(91,57,363,62);
		add(scrollPane);

	}
	
}
