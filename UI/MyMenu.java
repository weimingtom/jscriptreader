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
	JMenuItem editMenuItem;
	JMenuItem exitMenuItem;
	JMenuItem colorMenuItem;
	JMenuItem fontMenuItem;
	JMenuItem aboutMenuItem;
	
	public MyMenu(FormMain parent)
	{
		myParent = parent;
		// 实例化事件
		fileMenu = new JMenu("文件");
		ctrlMenu = new JMenu("设置");
		helpMenu = new JMenu("帮助");
		reloadMenuItem = new JMenuItem("重载脚本");
		closeMenuItem = new JMenuItem("关闭脚本");			
		editMenuItem = new JMenuItem("编辑脚本");
		exitMenuItem = new JMenuItem("退出");
		colorMenuItem = new JMenuItem("设置文字颜色");
		fontMenuItem = new JMenuItem("设置文字字体");
		aboutMenuItem = new JMenuItem("关于...");			
									
		reloadMenuItem.addActionListener(new MyMenuActionListener());
		closeMenuItem.addActionListener(new MyMenuActionListener());
		exitMenuItem.addActionListener(new MyMenuActionListener());
		editMenuItem.addActionListener(new MyMenuActionListener());
		colorMenuItem.addActionListener(new MyMenuActionListener());
		fontMenuItem.addActionListener(new MyMenuActionListener());
		aboutMenuItem.addActionListener(new MyMenuActionListener());
											
		fileMenu.add(reloadMenuItem);
		fileMenu.add(closeMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(editMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		ctrlMenu.add(colorMenuItem);
		ctrlMenu.add(fontMenuItem);
		//ctrlMenu.addSeparator();
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
				myParent.scriptPanel.clearScript();
				myParent.scriptPanel.PrintScript();
			}
			if((JMenuItem)e.getSource() == closeMenuItem)
			{
				myParent.scriptPanel.scriptText.setText("");
			}
			if((JMenuItem)e.getSource() == editMenuItem)
			{
				FormEditScript frmES = new FormEditScript();
				frmES.setVisible(true);
			}
			if((JMenuItem)e.getSource() == aboutMenuItem)
			{
				FormAbout frmAbout = new FormAbout();
				frmAbout.setVisible(true);
			}
			if((JMenuItem)e.getSource() == colorMenuItem)
			{
				setGrapicTextColor();
			}
			if((JMenuItem)e.getSource() == fontMenuItem)
			{
				setGraphicTextFont();
			}
			if((JMenuItem)e.getSource() == exitMenuItem)
			{
				System.exit(0);
			}
		} 
	}
	
	private void MessageBox(String text, String title)
	{
		JOptionPane.showConfirmDialog(null,text,title,JOptionPane.CLOSED_OPTION);
	}
	
	private void setGrapicTextColor()
	{
		JColorChooser chooser = new JColorChooser();
		Color newColor;
		newColor = chooser.showDialog(null, "设置文字颜色", myParent.graphPanel.getColor());
		myParent.graphPanel.setColor(newColor);
	}
	
	private void setGraphicTextFont()
	{
		Font font = myParent.graphPanel.getFont();   
		font = NwFontChooserS.showDialog(null,"设置文字字体",font);
		myParent.graphPanel.setFont(font);
	}
}