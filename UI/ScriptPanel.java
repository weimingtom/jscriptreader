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

import Domain.*;
import Service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;



class ScriptPanel extends JPanel
{
	// 1、声明事件、控件
	ActionListener ScriptPanelActions;

	JScrollPane scrollPane;
	JTextArea scriptText;

	// 公有属性
	public String CurrentDir = System.getProperty("user.dir",".");

	public ScriptPanel()
	{
		//this.setLayout(new GridLayout(1,1));		
		this.setLayout(new BorderLayout());
		
		scriptText = new JTextArea();
		scrollPane = new JScrollPane(scriptText);
		scriptText.setLineWrap(true);
		scriptText.setEditable(false);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		PrintScript();
	}
	
	public ScriptPanel(int status)
	{
		this.setLayout(new BorderLayout());
		
		scriptText = new JTextArea();
		scrollPane = new JScrollPane(scriptText);
		scriptText.setLineWrap(true);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		PrintScript();
		saveScript();
	}

	
	public void PrintScript()
	{
		try
		{
		    FileReader reader = new FileReader(CurrentDir + "\\DATA\\AVGS\\story.avgs");
		    BufferedReader br = new BufferedReader(reader);
		    String s1 = null;
		    while((s1 = br.readLine()) != null)
		    {
		    	scriptText.setText(scriptText.getText() + s1 + "\n");   
		    }    
		    br.close();
		    reader.close();
		}
		catch (Exception ex)
		{		}
	}
	
	public void clearScript()
	{
		scriptText.setText(" ");
	}
	
	public void saveScript()
	{
		try
		{
		    FileWriter writer = new FileWriter(CurrentDir + "\\DATA\\AVGS\\story.avgs");
			PrintWriter out = new PrintWriter(writer); 
		    String s1 = scriptText.getText();
		    out.print(s1);
		    writer.close();
		}
		catch (Exception ex)
		{		}
	}
		
	/*
	public void ReadScript()
	{
		try
		{
		    FileReader reader = new FileReader("D:\\url.txt");
		    BufferedReader br = new BufferedReader(reader);
		    String s1 = null;
		    while((s1 = br.readLine()) != null)
		    {
		    	//System.out.println(s1);    
		    }    
		    br.close();
		    reader.close();
		}
		catch (Exception ex)
		{}
	}
	*/
}