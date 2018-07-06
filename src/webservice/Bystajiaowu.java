package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bystajiaowu {
	
	public String tn;
	public String sn;
	public String cn;


	
	public static List<Bystajiaowu> listGroup(String params) {
		List<Bystajiaowu> Group = new ArrayList<Bystajiaowu>();
			
			String strJson=webservice.rundata("stajiaowu",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bystajiaowu obj=new Bystajiaowu();
					JSONObject info=arrJson.getJSONObject(i);
					obj.tn=info.getString("tn");
					obj.sn=info.getString("sn");
					obj.cn=info.getString("cn");
					
					
					
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
