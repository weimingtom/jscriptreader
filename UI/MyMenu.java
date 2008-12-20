/**
 * @(#)MyMenu.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/17
 *
 *
 * 菜单栏模块 
 * JMenuBar派生MyMenu，以及相关操作完成于此
 *
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



 
class MyMenu extends JMenuBar
{
	FormMain myParent;
	
	// 声明控件
	JMenu fileMenu;
	JMenu ctrlMenu;
	JMenu helpMenu;
	JMenuItem reloadMenuItem;
	JMenuItem closeMenuItem;
	JMenuItem exitMenuItem;
	JMenuItem editMenuItem;
	JMenuItem aboutMenuItem;
	
	public MyMenu(FormMain parent)
	{
		myParent = parent;
		// 实例化事件
		fileMenu = new JMenu("文件");
		ctrlMenu = new JMenu("脚本");
		helpMenu = new JMenu("帮助");
		reloadMenuItem = new JMenuItem("重载脚本");
		closeMenuItem = new JMenuItem("关闭脚本");			
		exitMenuItem = new JMenuItem("退出");
		editMenuItem = new JMenuItem("编辑脚本");
		aboutMenuItem = new JMenuItem("关于...");			
									
		reloadMenuItem.addActionListener(new MyMenuActionListener());
		closeMenuItem.addActionListener(new MyMenuActionListener());
		exitMenuItem.addActionListener(new MyMenuActionListener());
		editMenuItem.addActionListener(new MyMenuActionListener());
		aboutMenuItem.addActionListener(new MyMenuActionListener());
											
		fileMenu.add(reloadMenuItem);
		fileMenu.add(closeMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		ctrlMenu.add(editMenuItem);
		helpMenu.add(aboutMenuItem);
		this.add(fileMenu);	
		this.add(ctrlMenu);	
		this.add(helpMenu);
	}
	
	class MyMenuActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if((JMenuItem)e.getSource() == reloadMenuItem)
			{
				myParent.scriptPanel.PrintScript();
			}
			if((JMenuItem)e.getSource() == closeMenuItem)
			{
				myParent.scriptPanel.scriptText.setText("");
			}
			if((JMenuItem)e.getSource() == aboutMenuItem)
			{
				String aboutStr = 	
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
				JOptionPane.showConfirmDialog(null,aboutStr,"关于 JScriptReader",JOptionPane.CLOSED_OPTION);
			}
			if((JMenuItem)e.getSource() == editMenuItem)
			{
				JOptionPane.showConfirmDialog(null,"Pressed Edit\nThis function is till not available!","Sorry!!",JOptionPane.CLOSED_OPTION);
			}
			if((JMenuItem)e.getSource() == exitMenuItem)
			{
				//dispose();
				System.exit(0);
			}
		} 
	}
}