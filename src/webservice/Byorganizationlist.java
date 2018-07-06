package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byorganizationlist {
	 public String organizationname;
	 
	 public static List<Byorganizationlist>listGroup()
	 {
		 return listGroup("");
	 }
		public static List<Byorganizationlist> listGroup(String params) {
			List<Byorganizationlist> Group = new ArrayList<Byorganizationlist>();
				
				String strJson=webservice.rundata("organizationlist",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byorganizationlist obj=new Byorganizationlist();
						JSONObject info=arrJson.getJSONObject(i);
						obj.organizationname=info.getString("organizationname");						
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
