package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallxueyou {
	 public String xueyoutitle;	
		public static List<Byallxueyou> listGroup(String params) {
			List<Byallxueyou> Group = new ArrayList<Byallxueyou>();
				
				String strJson=webservice.rundata("allxueyou",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byallxueyou obj=new Byallxueyou();
						JSONObject info=arrJson.getJSONObject(i);
						obj.xueyoutitle=info.getString("xueyoutitle");						
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
