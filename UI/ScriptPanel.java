/**
 * @(#)ScriptPanel.java
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


class ScriptPanel extends JPanel
{
	// 1、声明事件、控件
	ActionListener RigntPanelActions;

	JScrollPane scrollPane;
	JTextArea scriptText;

	public ScriptPanel()
	{
		this.setLayout(new GridLayout(1,1));		
		
		scriptText = new JTextArea();
		scrollPane = new JScrollPane(scriptText);
		scriptText.setLineWrap(true);
		
		this.add(scrollPane);
	}
}