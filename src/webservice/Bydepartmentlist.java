package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bydepartmentlist {
	
	public String departmentname;


		
		public static List<Bydepartmentlist> listGroup(String params) {
			List<Bydepartmentlist> Group = new ArrayList<Bydepartmentlist>();
				
				String strJson=webservice.rundata("departmentlist",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Bydepartmentlist obj=new Bydepartmentlist();
						JSONObject info=arrJson.getJSONObject(i);
						obj.departmentname=info.getString("departmentname");
						
						
						
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
