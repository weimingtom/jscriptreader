/**
 * @(#)Story2.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/18
 *
 * 领域模型 —— 剧本（单行集合）
 *
 */

package Domain;

import java.util.*;

public class Story2
{
	private LinkedList<Line> _Content = new LinkedList<Line>();
	/// 全部脚本信息
	public LinkedList<Line> getContent() 
	{ 
		return _Content; 
	}
	public void setContent(LinkedList<Line> Content)
	{ 
		_Content = Content; 
	}

	private long _LineNumber;;
	/// 脚本总行数
	public long getLineNumber() 
	{ 
		return _LineNumber; 
	}
	public void setLineNumber(long LineNumber)
	{ 
		_LineNumber = LineNumber; 
	}

	/// 根据索引获得语句
	public String GetTextByIndex (long index)
	{
		Line tempLine = (Line)_Content.get((int)index);
		String tempString = tempLine.getText();
		return null;
	}
}

