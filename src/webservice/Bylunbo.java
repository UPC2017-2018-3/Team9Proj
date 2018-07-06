package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bylunbo {
	
	public String lb;



	
	public static List<Bylunbo> listGroup(String params) {
		List<Bylunbo> Group = new ArrayList<Bylunbo>();
			
			String strJson=webservice.rundata("lunbo",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bylunbo obj=new Bylunbo();
					JSONObject info=arrJson.getJSONObject(i);
					obj.lb=info.getString("lb");					
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
