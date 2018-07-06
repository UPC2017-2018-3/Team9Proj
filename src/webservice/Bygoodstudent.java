package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bygoodstudent {
	
	public String studentname;
    public String studentaccount;	

	public static List<Bygoodstudent> listGroup(String params) {
		List<Bygoodstudent> Group = new ArrayList<Bygoodstudent>();				
			String strJson=webservice.rundata("goodstudent",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bygoodstudent obj=new Bygoodstudent();
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
