package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byorganstudent {
	
 public String studentname;
 public String studentaccount;	 

		public static List<Byorganstudent> listGroup(String params) {
			List<Byorganstudent> Group = new ArrayList<Byorganstudent>();
				
				String strJson=webservice.rundata("organstudent",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byorganstudent obj=new Byorganstudent();
						JSONObject info=arrJson.getJSONObject(i);
						obj.studentname=info.getString("studentname");	
						obj.studentaccount=info.getString("studentaccount");	
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
