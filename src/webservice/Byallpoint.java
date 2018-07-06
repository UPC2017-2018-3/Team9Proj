package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallpoint {

public String knowledge;
public String vediopath;	

	
	public static List<Byallpoint> listGroup(String params) {
		List<Byallpoint> Group = new ArrayList<Byallpoint>();
			
			String strJson=webservice.rundata("allpoint",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byallpoint obj=new Byallpoint();
					JSONObject info=arrJson.getJSONObject(i);
					obj.knowledge=info.getString("knowledge");
					obj.vediopath=info.getString("vediopath");
					
					
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
