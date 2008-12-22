/**
 * @(#)FormAbout.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/22
 *
 *
 * 程序的关于窗体
 * 被主窗体调用，继承自JDialog
 * 显示关于信息！
 *
 */
 
package UI;

import Domain.*;
import Service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.lang.*;



public class FormAbout extends JDialog
{
	private String aboutStr = 	
		"JScriptReader\n\n" + 
		"Produced by 王徐阳\n\n" +
		"本程序是基于AVGmaker中调试工具ScriptReader改写的，\n" +
		"原版本已修正到1.5版，并完善了诸多功能。\n" +
		"本程序在其基础上对界面、功能都有一定的修改、简化，\n" +
		"但足以达到多平台调试脚本的作用。\n\n" +
		"本程序已经开源，欢迎使用者访问、交流：\n" +
		"http://code.google.com/p/jscriptreader/\n" +
		"同时，dotnet版AVGreader也已经开源，\n" + 
		"http://code.google.com/p/avgreader/\n" +
		"也欢迎关注我的其他开源项目。";
		
		
	JButton btnOk;
	JScrollPane scrollPane;
	JTextArea textAbout;
	JLabel eImage;
	ImageIcon iImage;
		
	public FormAbout()
	{
		this.setLayout(null);
		
		// 实例化控件
		textAbout = new JTextArea();
		textAbout.setLineWrap(true);
		textAbout.setEditable(false);
		textAbout.setText(aboutStr);
		scrollPane = new JScrollPane(textAbout);
		btnOk = new JButton("确定");
		iImage = new ImageIcon(System.getProperty("user.dir",".") + "\\DATA\\IMG\\logo.jpg");
		eImage = new JLabel(iImage);
		
		// 添加控件
		scrollPane.setBounds(12,12,340,283);
		this.add(scrollPane);
		btnOk.setBounds(358,261,160,34);
		this.add(btnOk);
		eImage.setBounds(358,12,160,80);
		this.add(eImage);
		
		// 添加事件
		btnOk.addActionListener(new FormAboutActionListener());
	
		setSize(538,340);
		setResizable(false);
		setTitle("关于JScriptReader");
		setLocation(200,150);
	}

	private void closeDialog()
	{
		this.dispose();
	}
	
    class FormAboutActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if((JButton)e.getSource() == btnOk)
			{
				closeDialog();
			}
		} 
	}
}
