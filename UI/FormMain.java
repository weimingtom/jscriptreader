/**
 * @(#)FormMain.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/15
 *
 *
 * 程序的主窗体 将在Program类中被实例化
 * 主要容纳MyMenu LeftPanel RightPanel等功能
 *
 *
 */
 
package UI;

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


public class FormMain extends JFrame
{
	// 声明控件
	MyMenu myMenu;// 我的菜单栏
	GraphPanel graphPanel;// 左侧面板
	ScriptPanel scriptPanel;// 右侧面板
    
	public FormMain()
	{
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 初始化所有模块
		myMenu = new MyMenu();
		graphPanel = new GraphPanel();
		scriptPanel = new ScriptPanel();
		
		// 设置主框架的布局
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(1,2));
		this.setJMenuBar(myMenu);

		c.add(graphPanel);
		c.add(scriptPanel);

		setSize(700,500);
		setTitle("JScriptReader");
		setLocation(200,150);
		setVisible(true);
	}
}






