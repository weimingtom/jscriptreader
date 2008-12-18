/**
 * @(#)Actor.java
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
	private LinkedList _Content = new LinkedList();
	/// 全部脚本信息
	public LinkedList getContent() 
	{ 
		return _Content; 
	}
	public void setContent(LinkedList Content)
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
		String tempString = (String)_Content.get((int)index);
		return null;
	}
}

