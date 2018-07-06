package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byreturnshixunplan {
	
public String teacherpicture;
public String shixuncontent;
	

	
	public static List<Byreturnshixunplan> listGroup(String params) {
		List<Byreturnshixunplan> Group = new ArrayList<Byreturnshixunplan>();
			
			String strJson=webservice.rundata("returnshixunplan",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byreturnshixunplan obj=new Byreturnshixunplan();
					JSONObject info=arrJson.getJSONObject(i);
					obj.teacherpicture=info.getString("teacherpicture");
					obj.shixuncontent=info.getString("shixuncontent");
					
					
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
