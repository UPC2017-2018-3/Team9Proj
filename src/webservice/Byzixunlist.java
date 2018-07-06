package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byzixunlist {
	 public String zixuntitle;
	    public String zixunpicture;		
		public static List<Byzixunlist> listGroup(String params) {
			List<Byzixunlist> Group = new ArrayList<Byzixunlist>();				
				String strJson=webservice.rundata("zixunlist",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byzixunlist obj=new Byzixunlist();
						JSONObject info=arrJson.getJSONObject(i);
						obj.zixuntitle=info.getString("zixuntitle");
						obj.zixunpicture=info.getString("zixunpicture");
						
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
