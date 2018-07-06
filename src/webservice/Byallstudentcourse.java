package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallstudentcourse {
	public String coursename;
	public String courseteacheraccount;
	public static List<Byallstudentcourse> listGroup(String params) {
		List<Byallstudentcourse> Group = new ArrayList<Byallstudentcourse>();				
			String strJson=webservice.rundata("allstudentcourse",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byallstudentcourse obj=new Byallstudentcourse();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursename=info.getString("coursename");
					obj.courseteacheraccount=info.getString("courseteacheraccount");
					Group.add(obj);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		return Group;
	}

}
