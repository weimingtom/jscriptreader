/**
 * @(#)MyMenu.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/17
 *
 *
 * 左边模块 
 * 图形显示窗口 和 对象监视窗口
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


class LeftPanel extends JPanel
{
	// 1、声明事件、控件
	ActionListener LeftPanelActions;

	public LeftPanel()
	{
		this.setLayout(new GridLayout(2,1));		
	}
}