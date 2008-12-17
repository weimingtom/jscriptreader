/**
 * @(#)GraphPanel.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/17
 *
 *
 * 图形显示模块 
 * 利用paintComponent事件中的Graphic类绘制图形
 * 
 * 备注：不能画bmp
 */
 
package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;



class GraphPanel extends JPanel
{
	// 1、声明事件、控件
	//ActionListener LeftPanelActions;
	
	ImageIcon iconBg;
	ImageIcon iconCt;
	ImageIcon iconFm;
	Image imageBg;
	Image imageCt;
	Image imageFm;
	
	// 公有属性
	public String ResPathBg = "I:\\GoogleCode\\jscriptreader\\test.jpg";
	public String ResPathCt = "I:\\GoogleCode\\jscriptreader\\test.png";
	public String ResPathFm = "I:\\GoogleCode\\jscriptreader\\DATA\\IMG\\frame.png";
	
	public GraphPanel()
	{
		initResource();
	}
	
	public void initResource()
	{
        iconBg = new ImageIcon(ResPathBg);
        iconCt = new ImageIcon(ResPathCt);
        iconFm = new ImageIcon(ResPathFm);
	}
		
	public void paintComponent(Graphics g)   
  	{   
  		imageBg = iconBg.getImage();
  		imageCt = iconCt.getImage();
  		imageFm = iconFm.getImage();
      	g.drawImage(imageBg, 0, 0, null);   
      	g.drawImage(imageCt, 0, 0, null);   
      	g.drawImage(imageFm, 0, 0, null);   
  	}   
}