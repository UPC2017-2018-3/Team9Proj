package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallmark {
	
    public String coursename;
    public String mark;		
	public static List<Byallmark> listGroup(String params) {
		List<Byallmark> Group = new ArrayList<Byallmark>();
			
			String strJson=webservice.rundata("allmymark",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byallmark obj=new Byallmark();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursename=info.getString("coursename");
					obj.mark=info.getString("mark");
					
					//obj.count=String.valueOf(arrJson.length());
					Group.add(obj);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		return Group;
	}

}
