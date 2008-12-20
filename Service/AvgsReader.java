/**
 * @(#)AvgsReader.java
 *
 *
 * @author Arthur 
 * @version 1.00 2008/12/19
 *
 * 服务 —— 资源索引avgs读取
 *
 */
 
package Service;

import Domain.*;

import java.io.*;
import java.util.*;

public class AvgsReader
{
	public String CurrentDir = System.getProperty("user.dir",".");

    public LinkedList<Scene> GetAllScene ()
    {
        LinkedList<Scene> sceneList = new LinkedList<Scene>();
        try
        {
			FileReader reader = new FileReader(CurrentDir + "\\DATA\\AVGS\\scene.avgs");
		    BufferedReader br = new BufferedReader(reader);
	        String tempStr = br.readLine();
	        if (!(tempStr.equals("<File SCENE>")))
	            return null;
	        while((tempStr = br.readLine()) != null)
	        {
	            Scene scene = new Scene();
	            char[] tBytes = tempStr.toCharArray();
	            //[场景名称][场景称号]
	            String name = "";
	            String id = "";
	            String path;
	            int i;
	            for (i = 1; tBytes[i] != ']'; i++)
	                name += tBytes[i];
	            for (i+=2; tBytes[i] != ']'; i++)
	                id += tBytes[i];
	            path = CurrentDir + "\\DATA\\SCENE\\" + id + ".jpg";
	
	            scene.setName(name);
	            scene.setID(id);
	            scene.setPath(path);
	            sceneList.add(scene);
	        }
	    
	        br.close();
		    reader.close();
	    }
        catch(Exception ex)
        {
        	return null;
        };

        return sceneList;
    }
    
    private LinkedList<Face> GetAllFace (String ActorID)
    {
        LinkedList<Face> faceList = new LinkedList<Face>();
        try
        {
	        String dir = CurrentDir + "\\DATA\\ACTOR\\" + ActorID + "\\face.avgs";
			FileReader reader = new FileReader(dir);
		    BufferedReader br = new BufferedReader(reader);
	        String tempStr = br.readLine();
	        if (!(tempStr.equals("<File FACE "+ActorID+">")))
	            return null;
	        while ((tempStr = br.readLine()) != null)
	        {
	            Face face = new Face();
	            char[] tBytes = tempStr.toCharArray();
	            //[表情名称][表情编号]
	            String name = "";
	            String id = "";
	            String path;
	            int i;
	            for (i = 1; tBytes[i] != ']'; i++)
	                name += tBytes[i];
	            for (i += 2; tBytes[i] != ']'; i++)
	                id += tBytes[i];
	            path = CurrentDir + "\\DATA\\ACTOR\\" + ActorID + "\\" + id;
	
	            face.setName(name);
	            face.setID(id);
	            face.setPath(path);
	            faceList.add(face);
	        }
        }
        catch(Exception ex)
        {
        	return null;
        };
        
        return faceList;
    }

    public LinkedList<Actor> GetAllActor ()
    {
        LinkedList<Actor> actorList = new LinkedList<Actor>();
        try
        {
			FileReader reader = new FileReader(CurrentDir + "\\DATA\\AVGS\\actor.avgs");
		    BufferedReader br = new BufferedReader(reader);
	        String tempStr = br.readLine();
	        if (!(tempStr.equals("<File ACTOR>")))
	            return null;
	        while ((tempStr = br.readLine()) != null)
	        {
	            Actor actor = new Actor();
	            char[] tBytes = tempStr.toCharArray();
	            //[人物名字][人物编号]
	            String name = "";
	            String id = "";
	            String path;
	            int i;
	            for (i = 1; tBytes[i] != ']'; i++)
	                name += tBytes[i];
	            for (i += 2; tBytes[i] != ']'; i++)
	                id += tBytes[i];
	            path = CurrentDir + "\\DATA\\ACTOR\\" + id + "\\default.png";
	
	            actor.setName(name);
	            actor.setID(id);
	            actor.setPath(path);
	            actor.setFaceList(this.GetAllFace(id));
	            actorList.add(actor);
	        }
        }
        catch(Exception ex)
        {
        	return null;
        };
        
        return actorList;
    }

    public Scene GetSceneById(String ID)
    {
        LinkedList<Scene> SceneList = GetAllScene();
        Iterator iter = SceneList.iterator();
  		while(iter.hasNext())
		{
	       	Scene scene = (Scene)iter.next();
       		String tempID = scene.getID();
       		if(tempID.equals(ID))
       			return scene;
	    }
        return null;
    }

    public Actor GetActorById(String ID)
    {
        LinkedList<Actor> ActorList = GetAllActor();
        Iterator iter = ActorList.iterator();
       	while(iter.hasNext()) 
       	{
       		Actor actor = (Actor)iter.next();
       		String tempID = actor.getID();
       		if(tempID.equals(ID))
       			return actor;
       	}
        return null;
    }
    
    
}
