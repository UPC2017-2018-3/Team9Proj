package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bycoursedetailothers {
	public String coursename;
    public String courseorganizationname;	
    public String courseteachername;
    public String summary;
	public static List<Bycoursedetailothers> listGroup(String params) {
		List<Bycoursedetailothers> Group = new ArrayList<Bycoursedetailothers>();				
			String strJson=webservice.rundata("coursedetailothers",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bycoursedetailothers obj=new Bycoursedetailothers();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursename=info.getString("coursename");
					obj.courseorganizationname=info.getString("courseorganizationname");
					obj.courseteachername=info.getString("courseteachername");
					obj.summary=info.getString("summary");
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
