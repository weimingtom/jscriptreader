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

import Domain.*;
import Service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;




public class FormMain extends JFrame
{
	// 声明控件
	MyMenu myMenu;// 我的菜单栏
	GraphPanel graphPanel;// 图形面板
	ScriptPanel scriptPanel;// 脚本面板
	InfoPanel infoPanel;// 信息面板
	
	JButton btnStart;
	
	public FormMain()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 初始化所有模块
		myMenu = new MyMenu();
		graphPanel = new GraphPanel();
		scriptPanel = new ScriptPanel();
		infoPanel = new InfoPanel();
		btnStart = new JButton("开始执行");
				

		// 设置主框架的布局
		setJMenuBar(myMenu);// 菜单
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		graphPanel.setBounds(12,12,480,360);
		this.add(graphPanel);
		infoPanel.setBounds(12,378,480,150);
		this.add(infoPanel);
		scriptPanel.setBounds(500,12,250,456);
		this.add(scriptPanel);
		btnStart.setBounds(500,474,250,23);
		this.add(btnStart);

		// 添加事件监听
		btnStart.addActionListener(new GloblePanelActions());
		
		setSize(770,570);
		setTitle("JScriptReader");
		setLocation(200,150);
		setVisible(true);
	}
	
    class GloblePanelActions implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if((JButton)e.getSource() == btnStart)
			{
				graphPanel.setBg("\\DATA\\SCENE\\0000.jpg");
			}
		} 
	}
	
	void initResource()
	{
		//载入脚本上的一切
	}
	
	void mainLoop()
	{
		//游戏主循环
	}
	
	
		

}








