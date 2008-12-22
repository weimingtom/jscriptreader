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
	public String CurrentDir = System.getProperty("user.dir",".");
	public String ResPathBg = CurrentDir + "\\DATA\\IMG\\background.jpg";
	public String ResPathCt = CurrentDir + "\\DATA\\IMG\\actor.png";
	public String ResPathFm = CurrentDir + "\\DATA\\IMG\\frame.png";
	public String Sentense1 = "程序初始化完毕！";
	public String Sentense2 = "按开始执行运行脚本！";
	public Color textColor = Color.black;
	public Font textFont = new Font("黑体",Font.PLAIN,16);
	
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
      	g.drawImage(imageBg, 0, 0, 480, 360, null);   
      	g.drawImage(imageCt, 0, 0, 210, 360, null);   
      	g.drawImage(imageFm, 105, 180, 375, 180, null);
      	g.setFont(textFont);
      	g.setColor(textColor);
      	g.drawString(Sentense1, 170, 250);
      	g.drawString(Sentense2, 170, 270);
  	}
  	
  	public void setBg(String path) 
  	{
  		ResPathBg = path;
        iconBg = new ImageIcon(ResPathBg);
  		this.repaint();
  	}
  	
  	public void setCt(String path) 
  	{
  		ResPathCt = path;
        iconCt = new ImageIcon(ResPathCt);
        this.repaint();
  	}
  	
  	public void setSent1(String sen)
  	{
  		Sentense1 = sen;
  		this.repaint();
  	}
  	
  	public void setSent2(String sen)
  	{
  		Sentense2 = sen;
  		this.repaint();
  	}
  	
  	public void setColor(Color fromColor)
  	{
  		textColor = fromColor;
  		this.repaint();
  	}
  	
  	public Color getColor()
  	{
  		return textColor;
  	}
  	
  	public void setFont(Font fromFont)
  	{
  		textFont = fromFont;
  		this.repaint();
  	}

  	
}