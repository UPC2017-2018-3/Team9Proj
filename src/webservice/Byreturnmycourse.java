package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byreturnmycourse {
	public String courseteachername;
    public String coursepicture;	
    public String coursename;
    public String courseorganizationname;
    public String progress;
    public String courseteacheraccount;
	public static List<Byreturnmycourse> listGroup(String params) {
		List<Byreturnmycourse> Group = new ArrayList<Byreturnmycourse>();				
			String strJson=webservice.rundata("returnmycourse",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byreturnmycourse obj=new Byreturnmycourse();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursepicture=info.getString("coursepicture");
					obj.coursename=info.getString("coursename");
					obj.courseteachername=info.getString("courseteachername");
					obj.courseorganizationname=info.getString("courseorganizationname");
					obj.progress=info.getString("progress");
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
