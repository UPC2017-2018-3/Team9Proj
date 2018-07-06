package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bystudentlist {

	public String studentaccount;
	public String studentname;


	
	public static List<Bystudentlist> listGroup(String params) {
		List<Bystudentlist> Group = new ArrayList<Bystudentlist>();
			
			String strJson=webservice.rundata("studentlist",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bystudentlist obj=new Bystudentlist();
					JSONObject info=arrJson.getJSONObject(i);
					obj.studentaccount=info.getString("studentaccount");
					obj.studentname=info.getString("studentname");
					
					
					
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
