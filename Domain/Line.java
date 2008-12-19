/**
 * @(#)Line.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/18
 *
 * 领域模型 —— 单行
 *
 */

package Domain;

import java.util.*;

public class Line
{
	private long _Index;
	/// 索引号（行号）
	public long getIndex() 
	{ 
		return _Index; 
	}
	public void setIndex(long Index)
	{ 
		_Index = Index; 
	}

	private String _Text = null;
	/// 单行内容
	public String getText() 
	{ 
		return _Text; 
	}
	public void setText(String Text)
	{ 
		_Text = Text; 
	}
}
