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
import java.lang.*;



public class FormMain extends JFrame
{
	// 声明控件
	MyMenu myMenu;// 我的菜单栏
	GraphPanel graphPanel;// 图形面板
	ScriptPanel scriptPanel;// 脚本面板
	InfoPanel infoPanel;// 信息面板
	JButton btnStart;
	JButton btnStep;
	JButton btnReset;
	
	public FormMain()
	{
		initializeCompoment();
		initStory();
	}
	
    class GloblePanelActions implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if((JButton)e.getSource() == btnStart)
			{
				btnStep.setEnabled(false);
				mainLoop();
			}
			if((JButton)e.getSource() == btnStep)
			{
				btnStart.setEnabled(false);
				QueryScript();
			}
			if((JButton)e.getSource() == btnReset)
			{
				btnStart.setEnabled(true);
				btnStep.setEnabled(true);
				initStory();
				String CurrentDir = System.getProperty("user.dir",".");
				graphPanel.setBg(CurrentDir + "\\DATA\\IMG\\background.jpg");
				graphPanel.setCt(CurrentDir + "\\DATA\\IMG\\actor.png");
				graphPanel.setSent1("程序初始化完毕！");
				graphPanel.setSent2("按开始执行运行脚本！");
			}
		} 
	}
	
	private void initializeCompoment()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 初始化所有模块
		myMenu = new MyMenu(this);
		graphPanel = new GraphPanel();
		scriptPanel = new ScriptPanel();
		infoPanel = new InfoPanel();
		btnStart = new JButton("开始执行");
		btnStep = new JButton("单步执行");
		btnReset = new JButton("重置");
				

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
		btnStart.setBounds(500,474,88,23);
		this.add(btnStart);
		btnStep.setBounds(594,474,88,23);
		this.add(btnStep);
		btnReset.setBounds(688,474,62,23);
		this.add(btnReset);

		// 添加事件监听
		btnStart.addActionListener(new GloblePanelActions());
		btnStep.addActionListener(new GloblePanelActions());
		btnReset.addActionListener(new GloblePanelActions());
		
		setSize(770,570);
		setTitle("JScriptReader");
		setLocation(200,150);
		setResizable(false);
		setVisible(true);
	}
	
	/***
	 * 以下为功能逻辑部分
	 */
	Story2 story = new Story2();
	AvgsReader avgsReader = new AvgsReader();
	StoryReader2 storyReader = new StoryReader2();
	MyEnum.RunStatement nowStatus = MyEnum.RunStatement.RUNNING;
    long nowIndex = 1;
    boolean isStroyInitialized = false;
    int sentFlag = 1;
	
	void initStory()
	{
		//载入故事脚本
		story = storyReader.GetWholeStory();
		nowStatus = MyEnum.RunStatement.RUNNING;
		nowIndex = 1;
	}
	
	void mainLoop()
	{
		//游戏主循环
		while(nowIndex <= story.getLineNumber())
        {
            if (nowStatus == MyEnum.RunStatement.RUNNING || nowStatus == MyEnum.RunStatement.PAGE)
            {            
                //抽取并分发脚本
                QueryScript();
                this.repaint(1000);
            }
            if (nowStatus == MyEnum.RunStatement.END)
            {
                break;
            }
        }
	}
	
	private void QueryScript ()
    {
        String cmd = story.GetTextByIndex(nowIndex);
        //tbScriptCmd.Text = cmd; // 窗体：显示当前指令
        //HighLightTesting(cmd); // 窗体：高亮脚本追踪方法
 
        char[] bCmd = cmd.toCharArray();

        if (cmd.equals("<PAGE>"))
        {
            nowStatus = MyEnum.RunStatement.PAGE;
            HandlePage();
        }
        else if (cmd.equals("<BR>"))
        {
            HandleBR();
        }
        else if (cmd.equals("<END>"))
        {
            nowStatus = MyEnum.RunStatement.END;
            HandleEnd();
            return;
        }
        else if (bCmd[0] == '<' && bCmd[cmd.length() - 1] == '>')
        {
            nowStatus = MyEnum.RunStatement.RUNNING;
            int i;
            String detailCMD = "";
            String id = "";
            for (i = 1; bCmd[i] != ' '; i++)
                detailCMD += bCmd[i];
            for (i++; bCmd[i] != '>'; i++)
                id += bCmd[i];
			
			String strScene = "SCENE";
			String strActor = "ACTOR";
			String strFace = "FACE";
            if(detailCMD.equals(strScene))
            	ShowScene(id);
            else if(detailCMD.equals(strActor))
                ShowActor(id);
            else if(detailCMD.equals(strFace))
                ShowFace(id);
            else{};
        }
        else if (bCmd[0] != '<')
        {
            nowStatus = MyEnum.RunStatement.RUNNING;
            ShowText(cmd);
        }

        //指向下一行
        nowIndex++;
        //ShowIndex(); // 窗体：显示当前索引号
    }
	
    private void ShowText(String sen)
    {
    	switch(sentFlag)
    	{
        	case 1 : 
        	{
        		graphPanel.setSent1(sen);
        		graphPanel.setSent2("");
        		infoPanel.txtWd.setText(sen); // 窗体：显示当前语句1
        		break;
        	}
        	case 2 :
        	{
        		graphPanel.setSent2(sen);
        		infoPanel.txtWd.setText(infoPanel.txtWd.getText() + "\n" + sen); // 窗体：显示当前语句1
        		break;
        	}
    	}
    }

    private void ShowScene(String id)
    {
        Scene scene = avgsReader.GetSceneById(id);
        graphPanel.setBg(scene.getPath());
        infoPanel.txtBg.setText(scene.getName() + "[" + scene.getID() + "]"); // 窗体：显示场景名称
        /*
        try
        {
        	Thread.currentThread().sleep(1000); // 延时1秒
        }
        catch(InterruptedException ex){};
        */
    }

    private void ShowActor(String id)
    {
        Actor actor = avgsReader.GetActorById(id);
        graphPanel.setCt(actor.getPath());
        infoPanel.txtCt.setText(actor.getName() + "[" + actor.getID() + "]"); // 窗体：显示当前角色
    }

    private void ShowFace(String id)
    {
		return;
    }

    private void HandlePage ()
    {
    	/*
        try
        {
        	Thread.currentThread().sleep(1000); // 延时850豪秒
        }
        catch(InterruptedException ex){};
        */
        infoPanel.txtWd.setText("");  // 窗体：换页清空控件
		graphPanel.setSent1("");
		graphPanel.setSent2("");
        sentFlag = 1;
    }

    private void HandleBR ()
    {
        //tbInfoWORD.Text += "\n"; // 窗体：换行，控件加入换行符
		sentFlag = 2;
    }

    private void HandleEnd ()
    {
		JOptionPane.showConfirmDialog(null,"脚本执行完毕！","JScriptReader",JOptionPane.CANCEL_OPTION);
        isStroyInitialized = false;
    }
    
}








