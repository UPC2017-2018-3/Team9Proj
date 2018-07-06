package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byzixuncontent {
	public String zixuntitle;
    public String zixunpicture;	
    public String zixuntext;
    public String zixunorganization;
	public static List<Byzixuncontent> listGroup(String params) {
		List<Byzixuncontent> Group = new ArrayList<Byzixuncontent>();				
			String strJson=webservice.rundata("zixuncontent",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byzixuncontent obj=new Byzixuncontent();
					JSONObject info=arrJson.getJSONObject(i);
					obj.zixuntitle=info.getString("zixuntitle");
					obj.zixunpicture=info.getString("zixunpicture");
					obj.zixuntext=info.getString("zixuntext");
					obj.zixunorganization=info.getString("zixunorganization");
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
