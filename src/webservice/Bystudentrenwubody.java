package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bystudentrenwubody {
	public String renwutime;
    public String renwudeadline;	
    public String renwutype;
    public String renwudetail;
    public String renwuteacher;
    
	public static List<Bystudentrenwubody> listGroup(String params) {
		List<Bystudentrenwubody> Group = new ArrayList<Bystudentrenwubody>();				
			String strJson=webservice.rundata("studentrenwubody",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bystudentrenwubody obj=new Bystudentrenwubody();
					JSONObject info=arrJson.getJSONObject(i);
					obj.renwutime=info.getString("renwutime");
					obj.renwudeadline=info.getString("renwudeadline");
					obj.renwutype=info.getString("renwutype");
					obj.renwudetail=info.getString("renwudetail");
					obj.renwuteacher=info.getString("renwuteacher");
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
