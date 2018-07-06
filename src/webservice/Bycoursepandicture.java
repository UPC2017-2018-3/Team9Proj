package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bycoursepandicture {
	
	public String coursename;
    public String courseteacheraccount;	
    public String courseteachername;
    public String coursepicture;
	public static List<Bycoursepandicture> listGroup(String params) {
		List<Bycoursepandicture> Group = new ArrayList<Bycoursepandicture>();
			
			String strJson=webservice.rundata("coursepandicture",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bycoursepandicture obj=new Bycoursepandicture();
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
