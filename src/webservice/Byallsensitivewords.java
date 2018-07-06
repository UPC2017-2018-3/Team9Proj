package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallsensitivewords {
	
	public String wordid;
	public String word;
	public String organization;
		

		
		public static List<Byallsensitivewords> listGroup(String params) {
			List<Byallsensitivewords> Group = new ArrayList<Byallsensitivewords>();
				
				String strJson=webservice.rundata("allsensitivewords",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byallsensitivewords obj=new Byallsensitivewords();
						JSONObject info=arrJson.getJSONObject(i);
						obj.wordid=info.getString("wordid");
						obj.word=info.getString("word");
						obj.organization=info.getString("organization");
						
						
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
