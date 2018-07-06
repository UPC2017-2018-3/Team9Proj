package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallrenwu {
	
public String renwucourse;
public String renwutype;
public String renwutime;
public String renwudeadline;
public String renwuclass;
public String renwutext;	

	
	public static List<Byallrenwu> listGroup(String params) {
		List<Byallrenwu> Group = new ArrayList<Byallrenwu>();
			
			String strJson=webservice.rundata("allrenwu",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byallrenwu obj=new Byallrenwu();
					JSONObject info=arrJson.getJSONObject(i);
					obj.renwucourse=info.getString("renwucourse");
					obj.renwutype=info.getString("renwutype");
					obj.renwutime=info.getString("renwutime");
					obj.renwudeadline=info.getString("renwudeadline");
					obj.renwuclass=info.getString("renwuclass");
					obj.renwutext=info.getString("renwutext");
					
					
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
