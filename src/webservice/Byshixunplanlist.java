package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byshixunplanlist {
	
public String shixunID;
public String shixunteacher;
public String shixuncourse;
public String shixuntime;
public String shixuncontent;
public String shixunsummary;
public String shixunorganization;
public String state;
public String shixunteachername;


	
	public static List<Byshixunplanlist> listGroup(String params) {
		List<Byshixunplanlist> Group = new ArrayList<Byshixunplanlist>();
			
			String strJson=webservice.rundata("shixunplanlist",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byshixunplanlist obj=new Byshixunplanlist();
					JSONObject info=arrJson.getJSONObject(i);
					obj.shixunID=info.getString("shixunID");
					obj.shixunteacher=info.getString("shixunteacher");
					obj.shixuncourse=info.getString("shixuncourse");
					obj.shixuntime=info.getString("shixuntime");
					obj.shixuncontent=info.getString("shixuncontent");
					obj.shixunsummary=info.getString("shixunsummary");
					obj.shixunorganization=info.getString("shixunorganization");
					obj.state=info.getString("state");
					obj.shixunteachername=info.getString("shixunteachername");

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
