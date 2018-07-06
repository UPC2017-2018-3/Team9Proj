package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bystudentrenwuhead {
	public String renwucourse;
    public String renwustate;	
    
	public static List<Bystudentrenwuhead> listGroup(String params) {
		List<Bystudentrenwuhead> Group = new ArrayList<Bystudentrenwuhead>();				
			String strJson=webservice.rundata("studentrenwuhead",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bystudentrenwuhead obj=new Bystudentrenwuhead();
					JSONObject info=arrJson.getJSONObject(i);
					obj.renwucourse=info.getString("renwucourse");
					obj.renwustate=info.getString("renwustate");
					
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
