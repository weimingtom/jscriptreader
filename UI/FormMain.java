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
	//ActionListener GloblePanelActions;

	// 声明控件
	MyMenu myMenu;// 我的菜单栏
	JPanel leftPanel;// 左侧面板
	JPanel rightPanel;// 右侧面板
	GraphPanel graphPanel;// 图形面板
	ScriptPanel scriptPanel;// 脚本面板
	InfoPanel infoPanel;// 信息面板
	
	public FormMain()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 初始化所有模块
		myMenu = new MyMenu();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		graphPanel = new GraphPanel();
		scriptPanel = new ScriptPanel();
		infoPanel = new InfoPanel();
				
		// 设置主框架的布局
		setJMenuBar(myMenu);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1,2,10,0));
		contentPane.add(leftPanel);
		contentPane.add(rightPanel);
		leftPanel.setLayout(new GridLayout(2,1,0,10));
		leftPanel.add(graphPanel);
		leftPanel.add(infoPanel);
		rightPanel.setLayout(new GridLayout(1,1,0,0));
		rightPanel.add(scriptPanel);

		infoPanel.jb.addActionListener(new GloblePanelActions());

		setSize(960,800);
		setTitle("JScriptReader");
		setLocation(200,150);
		setVisible(true);
	}
	
    class GloblePanelActions implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if((JButton)e.getSource() == infoPanel.jb)
			{
				JOptionPane.showConfirmDialog(null,"Pressed About","title",JOptionPane.YES_OPTION);
				
			}
		} 
	
	}
		

}








