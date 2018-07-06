package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bygonggaodetial {
	public String gonggaotitle;
    public String gonggaotime;
    public String gonggaowriter;
    public String gonggaotext;
	public static List<Bygonggaodetial> listGroup(String params) {
		List<Bygonggaodetial> Group = new ArrayList<Bygonggaodetial>();				
			String strJson=webservice.rundata("gonggaodetial",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bygonggaodetial obj=new Bygonggaodetial();
					JSONObject info=arrJson.getJSONObject(i);
					obj.gonggaotitle=info.getString("gonggaotitle");
					obj.gonggaotime=info.getString("gonggaotime");
					obj.gonggaowriter=info.getString("gonggaowriter");
					obj.gonggaotext=info.getString("gonggaotext");
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
