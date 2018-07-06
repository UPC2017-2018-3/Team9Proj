package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byonezixun1 {
	public String zixuntitle;
    public String zixunpicture;	
	public static List<Byonezixun1> listGroup(String params) {
		List<Byonezixun1> Group = new ArrayList<Byonezixun1>();				
			String strJson=webservice.rundata("onezixun1",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byonezixun1 obj=new Byonezixun1();
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
