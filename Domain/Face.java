/**
 * @(#)Face.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/18
 *
 * 领域模型 —— 角色表情
 *
 */

package Domain;

import java.util.*;

public class Face
{
	private String _ID;
	/// 表情ID
	public String getID() 
	{ 
		return _ID; 
	}
	public void setID(String ID)
	{ 
		_ID = ID; 
	}

	private String _Name;
	/// 表情名字
	public String getName() 
	{ 
		return _Name; 
	}
	public void setName(String Name)
	{ 
		_Name = Name; 
	}

	private String _Path;
	/// 表情路径
	public String getPath() 
	{ 
		return _Path; 
	}
	public void setPath(String Path)
	{ 
		_Path = Path; 
	}
}

