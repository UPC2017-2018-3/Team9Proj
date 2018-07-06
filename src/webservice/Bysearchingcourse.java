package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bysearchingcourse {
	
public String courseteacheraccount;
public String courseteachername;
public String coursepicture;

	

	
	public static List<Bysearchingcourse> listGroup(String params) {
		List<Bysearchingcourse> Group = new ArrayList<Bysearchingcourse>();
			
			String strJson=webservice.rundata("searchingcourse",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bysearchingcourse obj=new Bysearchingcourse();
					JSONObject info=arrJson.getJSONObject(i);
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
