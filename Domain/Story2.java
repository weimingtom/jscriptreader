/**
 * @(#)Actor.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/18
 *
 * ����ģ�� ���� �籾�����м��ϣ�
 *
 */

package Domain;
import java.util.*;

public class Story2
{
	private LinkedList _Content = new LinkedList();
	/// ȫ���ű���Ϣ
	public LinkedList getContent() 
	{ 
		return _Content; 
	}
	public void setContent(LinkedList Content)
	{ 
		_Content = Content; 
	}

	private long _LineNumber;;
	/// �ű�������
	public long getLineNumber() 
	{ 
		return _LineNumber; 
	}
	public void setLineNumber(long LineNumber)
	{ 
		_LineNumber = LineNumber; 
	}

	/// ��������������
	public String GetTextByIndex (long index)
	{
		String tempString = (String)_Content.get((int)index);
		return null;
	}
}
