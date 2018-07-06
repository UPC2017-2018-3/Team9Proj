package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bystudystudentlist {
	
	public String coursestudentaccount;
	public String coursestudentname;	

		
		public static List<Bystudystudentlist> listGroup(String params) {
			List<Bystudystudentlist> Group = new ArrayList<Bystudystudentlist>();
				
				String strJson=webservice.rundata("studystudentlist",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Bystudystudentlist obj=new Bystudystudentlist();
						JSONObject info=arrJson.getJSONObject(i);
						obj.coursestudentaccount=info.getString("coursestudentaccount");
						obj.coursestudentname=info.getString("coursestudentname");

						
						
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
