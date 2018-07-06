package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byrenwustate {
	 public String renwu;
	    public String renwustate;		
		public static List<Byrenwustate> listGroup(String params) {
			List<Byrenwustate> Group = new ArrayList<Byrenwustate>();
				
				String strJson=webservice.rundata("renwustate",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byrenwustate obj=new Byrenwustate();
						JSONObject info=arrJson.getJSONObject(i);
						obj.renwu=info.getString("renwu");
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
