/**
 * @(#)StoryReader2.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/19
 *
 * 服务 —— 脚本读取
 *
 */
 
package Service;

import Domain.*;
import java.io.*;
import java.util.*;

public class StoryReader2
{
	public String CurrentDir = System.getProperty("user.dir",".");

    /// 获得全部的故事
    /// 返回故事对象
    public Story2 GetWholeStory()
    {
  	    Story2 story = new Story2();
  		try
    	{
			FileReader reader = new FileReader(CurrentDir + "\\DATA\\AVGS\\story.avgs");
		    BufferedReader br = new BufferedReader(reader);
	        String tempStr;
	        int index = 1;
	        while ((tempStr = br.readLine()) != null)
	        {
	            Line newLine = new Line();
	            newLine.setIndex(index);
	            newLine.setText(tempStr);
	            story.getContent().add(newLine);
	            index++;
	        }
	        story.setLineNumber(index - 1);
    	}
    	catch (Exception ex)
    	{
    		return null;
    	}
        return story;
    }

}

