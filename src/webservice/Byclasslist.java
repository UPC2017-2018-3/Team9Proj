package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byclasslist {
	
	public String cla;


	
	public static List<Byclasslist> listGroup(String params) {
		List<Byclasslist> Group = new ArrayList<Byclasslist>();
			
			String strJson=webservice.rundata("classlist",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byclasslist obj=new Byclasslist();
					JSONObject info=arrJson.getJSONObject(i);
					obj.cla=info.getString("cla");
					
					
					
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
