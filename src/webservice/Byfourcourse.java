package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byfourcourse {
	
	public String coursename;
    public String courseteacheraccount;	
    public String courseteachername;
    public String coursepicture;
	public static List<Byfourcourse> listGroup(String params) {
		List<Byfourcourse> Group = new ArrayList<Byfourcourse>();
			
			String strJson=webservice.rundata("fourcourse",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byfourcourse obj=new Byfourcourse();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursename=info.getString("coursename");
					obj.courseteacheraccount=info.getString("courseteacheraccount");
					obj.courseteachername=info.getString("courseteachername");
					obj.coursepicture=info.getString("coursepicture");
					
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
