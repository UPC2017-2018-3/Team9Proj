package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byalllivepath {
	
	public String teacheraccount;
	public String teachername;
		

		
		public static List<Byalllivepath> listGroup(String params) {
			List<Byalllivepath> Group = new ArrayList<Byalllivepath>();
				
				String strJson=webservice.rundata("alllivepath",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byalllivepath obj=new Byalllivepath();
						JSONObject info=arrJson.getJSONObject(i);
						obj.teacheraccount=info.getString("teacheraccount");
						obj.teachername=info.getString("teachername");
						
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
