package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byxueyoudetial {
	public String xueyoutitle;
    public String xueyouwriter;
    public String xueyoutime;
    public String xueyoucontent;
	public static List<Byxueyoudetial> listGroup(String params) {
		List<Byxueyoudetial> Group = new ArrayList<Byxueyoudetial>();				
			String strJson=webservice.rundata("xueyoudetial",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byxueyoudetial obj=new Byxueyoudetial();
					JSONObject info=arrJson.getJSONObject(i);
					obj.xueyoutitle=info.getString("xueyoutitle");
					obj.xueyouwriter=info.getString("xueyouwriter");
					obj.xueyoutime=info.getString("xueyoutime");
					obj.xueyoucontent=info.getString("xueyoucontent");
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
