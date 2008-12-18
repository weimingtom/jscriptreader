package Service;

import java.io.*;
import java.util.*;
import Domain.*;

public class AvgsReader
{
	public String CurrentDir = System.getProperty("user.dir",".");

    public LinkedList GetAllScene ()
    {
        LinkedList sceneList = new LinkedList();
		FileReader reader = new FileReader(CurrentDir + "\\DATA\\AVGS\\story.avgs");
	    BufferedReader br = new BufferedReader(reader);
        String tempStr = br.readLine();
        if (tempStr != "<File SCENE>")
            return null;
        while((tempStr = br.readLine()) != null)
        {
            Scene scene = new Scene();
            byte[] tBytes = tempStr.getBytes();
            //[场景名称][场景称号]
            String name = "";
            String id = "";
            String path;
            int i;
            for (i = 1; tBytes[i] != ']'; i++)
                name += tBytes[i];
            for (i+=2; tBytes[i] != ']'; i++)
                id += tBytes[i];
            path = CurrentDir + "\\DATA\\SCENE\\" + id + ".bmp";

            scene.setName(name);
            scene.setID(id);
            scene.setPath(path);
            sceneList.add(scene);
        }
    
        br.close();
	    reader.close();

        return sceneList;
    }
    
    													////////////////////////// 改到这里 //////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private LinkedList GetAllFace (String ActorID)
    {
        LinkedList faceList = new LinkedList();
        String dir = currentDir + "\\DATA\\ACTOR\\" + ActorID + "\\face.avgs";
		FileReader reader = new FileReader(dir);
	    BufferedReader br = new BufferedReader(reader);
        String tempStr = br.readLine();
        if (tempStr != "<File FACE "+ActorID+">")
            return null;
        while ((tempStr = br.readLine()) != null)
        {
            Face face = new Face();
            //[表情名称][表情编号]
            String name = "";
            String id = "";
            String path;
            int i;
            for (i = 1; tempStr[i] != ']'; i++)
                name += tempStr[i];
            for (i += 2; tempStr[i] != ']'; i++)
                id += tempStr[i];
            path = currentDir + "\\DATA\\ACTOR\\" + ActorID + "\\" + id;

            face.setName(name);
            face.setID(id);
            face.setPath(path);
            faceList.add(face);
        }
        return faceList;
    }

    public LinkedList GetAllActor ()
    {
        LinkedList actorList = new LinkedList();
		FileReader reader = new FileReader(currentDir + "\\DATA\\AVGS\\actor.avgs");
	    BufferedReader br = new BufferedReader(reader);
        String tempStr = br.readLine();
        if (tempStr != "<File ACTOR>")
            return null;
        while ((tempStr = br.readLine()) != null)
        {
            Actor actor = new Actor();
            //[人物名字][人物编号]
            String name = "";
            String id = "";
            String path;
            int i;
            for (i = 1; tempStr[i] != ']'; i++)
                name += tempStr[i];
            for (i += 2; tempStr[i] != ']'; i++)
                id += tempStr[i];
            path = currentDir + "\\DATA\\ACTOR\\" + id + "\\default.png";

            actor.setName(name);
            actor.setID(id);
            actor.setPath(path);
            actor.setFaceList(GetAllFace(id));
            actorList.add(actor);
        }
        return actorList;
    }

    public Scene GetSceneById(String ID)
    {
        LinkedList SceneList = GetAllScene();
        Scene scene = SceneList.getFirst();
       	while((scene = scene.next()) != null) 
       	{
       		String tempID = scene.getID();
       		if(tempID == ID)
       			return scene;
       	}
        return null;
    }

    public Actor GetActorById(String ID)
    {
        LinkedList ActorList = GetAllActor();
        Actor actor = ActorList.getFirst();
       	while((actor = actor.next()) != null) 
       	{
       		String tempID = scene.getID();
       		if(tempID == ID)
       			return actor;
       	}
        return null;
    }
}
