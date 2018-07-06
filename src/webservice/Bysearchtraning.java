package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bysearchtraning {
	
public String question;
	

	
	public static List<Bysearchtraning> listGroup(String params) {
		List<Bysearchtraning> Group = new ArrayList<Bysearchtraning>();
			
			String strJson=webservice.rundata("searchtraning",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Bysearchtraning obj=new Bysearchtraning();
					JSONObject info=arrJson.getJSONObject(i);
					obj.question=info.getString("question");
					
					
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
