/**
 * @(#)FormEditScript.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/22
 *
 *
 * 程序的脚本编辑窗体
 * 被主窗体调用，继承自JDialog
 * 用来编辑脚本内容。
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



public class FormEditScript extends JDialog
{
	ScriptPanel scriptPanel;
	JPanel panelBtn;
	JButton btnOk;
	JButton btnCancel;
		
	public FormEditScript()
	{
		// 实例化对象
		scriptPanel = new ScriptPanel(22);//传入任意int则为这个构造
		panelBtn = new JPanel();
		btnOk = new JButton("保存修改");
		btnCancel = new JButton("关闭并放弃修改");
		
		// 布局
		this.setLayout(new BorderLayout());
		panelBtn.add(btnOk);
		panelBtn.add(btnCancel);
		this.add(panelBtn, BorderLayout.SOUTH);
		this.add(scriptPanel, BorderLayout.CENTER);
		
		// 添加监听
		btnOk.addActionListener(new FormEditScriptActionListener());
		btnCancel.addActionListener(new FormEditScriptActionListener());
		
		setSize(420,500);
		setTitle("脚本编辑器");
		setLocation(200,150);
	}
	
	private void closeDialog()
	{
		this.dispose();
	}
	
    class FormEditScriptActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if((JButton)e.getSource() == btnOk)
			{
				scriptPanel.saveScript();
				JOptionPane.showConfirmDialog(null,"脚本编辑成功！\n请关闭本窗口后重载脚本。","脚本编辑器 提示",JOptionPane.CLOSED_OPTION);
			}
			if((JButton)e.getSource() == btnCancel)
			{
				closeDialog();
			}
		} 
	}


}