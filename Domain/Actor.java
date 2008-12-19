/**
 * @(#)Actor.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/18
 *
 * 领域模型 —— 角色
 *
 */

package Domain;

import java.util.*;

public class Actor
{
	private String _ID;
	/// 角色ID
	public String getID() 
	{ 
		return _ID; 
	}
	public void setID(String ID)
	{ 
		_ID = ID; 
	}

	private String _Name;
	/// 角色名字
	public String getName() 
	{ 
		return _Name; 
	}
	public void setName(String Name)
	{ 
		_Name = Name; 
	}
	
	private String _Path;
	/// 角色路径
	public String getPath() 
	{ 
		return _Path; 
	}
	public void setPath(String Path)
	{ 
		_Path = Path; 
	}

	private LinkedList<Face> _FaceList = new LinkedList<Face>();
	/// 角色表情集合
	public LinkedList<Face> getFaceList() 
	{ 
		return _FaceList; 
	}
	public void setFaceList(LinkedList<Face> FaceList)
	{ 
		_FaceList = FaceList; 
	}
}

