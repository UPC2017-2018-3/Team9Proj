package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;



public class Byteacherreturncourse {
	
	public String coursename;
	

		
		public static List<Byteacherreturncourse> listGroup(String params) {
			List<Byteacherreturncourse> Group = new ArrayList<Byteacherreturncourse>();
				
				String strJson=webservice.rundata("teacherreturncourse",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byteacherreturncourse obj=new Byteacherreturncourse();
						JSONObject info=arrJson.getJSONObject(i);
						obj.coursename=info.getString("coursename");
						
						
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
