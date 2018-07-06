package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

  public class Byabilityfiles {
	    public String coursename;
	    public String type;		
		public static List<Byabilityfiles> listGroup(String params) {
			List<Byabilityfiles> Group = new ArrayList<Byabilityfiles>();
				
				String strJson=webservice.rundata("abilityfiles",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byabilityfiles obj=new Byabilityfiles();
						JSONObject info=arrJson.getJSONObject(i);
						obj.coursename=info.getString("coursename");
						obj.type=info.getString("type");
						
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
