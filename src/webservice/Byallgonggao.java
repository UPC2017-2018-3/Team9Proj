package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallgonggao {
	 public String gonggaotitle;	
		public static List<Byallgonggao> listGroup(String params) {
			List<Byallgonggao> Group = new ArrayList<Byallgonggao>();
				
				String strJson=webservice.rundata("allgonggao",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byallgonggao obj=new Byallgonggao();
						JSONObject info=arrJson.getJSONObject(i);
						obj.gonggaotitle=info.getString("gonggaotitle");
						
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
