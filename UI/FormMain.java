/**
 * @(#)FormMain.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/15
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FormMain extends JFrame
{
	//声明
	MyMenu myMenu;//我的菜单栏
	RightPanel rightPanel;//右侧面板
	
	public FormMain()
	{
		// 初始化所有模块
		myMenu = new MyMenu();
		rightPanel = new RightPanel();
		
		// 设置主框架的布局
		Container c = this.getContentPane();
		this.setJMenuBar(myMenu);

		c.add(rightPanel,BorderLayout.EAST);

		// 窗口事件
		this.addWindowListener(new WindowAdapter()
		{
			public void WindowClosing(WindowEvent e)
			{   
			    // 释放资源，退出程序
				dispose();
				System.exit(0);
			}
		});
		
		setSize(700,500);
		setTitle("JScriptReader");
		setLocation(200,150);
		setVisible(true);
	}
}

////////////////////////////////////////////////////////////////////////////
/**
 * 菜单栏封装类
 *              
 */
class MyMenu extends JMenuBar
{
	// 1、声明事件、控件
	ActionListener MyMenuActions;
	
	JMenu fileMenu;
	JMenu helpMenu;
	JMenuItem reloadMenuItem;
	JMenuItem closeMenuItem;
	JMenuItem exitMenuItem;
	JMenuItem aboutMenuItem;
	
	
	public MyMenu()
	{
		// 2、实例化事件
		fileMenu = new JMenu("文件");
		helpMenu = new JMenu("帮助");
		reloadMenuItem = new JMenuItem("重载脚本",KeyEvent.VK_E);
		closeMenuItem = new JMenuItem("关闭脚本",KeyEvent.VK_A);			
		exitMenuItem = new JMenuItem("退出",KeyEvent.VK_E);
		aboutMenuItem = new JMenuItem("关于...",KeyEvent.VK_A);			
											
		fileMenu.add(reloadMenuItem);
		fileMenu.add(closeMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		helpMenu.add(aboutMenuItem);
		this.add(fileMenu);	
		this.add(helpMenu);
	

	
		// 3、实例化事件
		MyMenuActions = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if((JMenuItem)e.getSource() == reloadMenuItem)
				{
					JOptionPane.showConfirmDialog(null,"Pressed Reload","title",JOptionPane.YES_OPTION);
				}
				if((JMenuItem)e.getSource() == closeMenuItem)
				{
					JOptionPane.showConfirmDialog(null,"Pressed Close","title",JOptionPane.YES_OPTION);
				}
				if((JMenuItem)e.getSource() == aboutMenuItem)
				{
					JOptionPane.showConfirmDialog(null,"Pressed About","title",JOptionPane.YES_OPTION);
				}
				if((JMenuItem)e.getSource() == exitMenuItem)
				{
					//dispose();
					System.exit(0);
				}
			} 
		};
		
		// 4、添加控件的事件监听
		reloadMenuItem.addActionListener(MyMenuActions);
		closeMenuItem.addActionListener(MyMenuActions);
		aboutMenuItem.addActionListener(MyMenuActions);
		exitMenuItem.addActionListener(MyMenuActions);
		
	}
}



////////////////////////////////////////////////////////////////////////////
/**
 * 右边模块
 *
 * 脚本显示窗口
 */
class RightPanel extends JPanel
{
	public RightPanel()
	{
		
	}
}
