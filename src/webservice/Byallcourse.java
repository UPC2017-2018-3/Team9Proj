package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallcourse {
	
	public String coursename;
	public String coursetime;
	public String courseteachername;
	public String courseteacheraccount;


	
	public static List<Byallcourse> listGroup(String params) {
		List<Byallcourse> Group = new ArrayList<Byallcourse>();
			
			String strJson=webservice.rundata("allcourse",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byallcourse obj=new Byallcourse();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursename=info.getString("coursename");
					obj.coursetime=info.getString("coursetime");
					obj.courseteachername=info.getString("courseteachername");
					obj.courseteacheraccount=info.getString("courseteacheraccount");
					
					
					
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
