package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byteacherlist {
	public String teacheraccount;
	public String teachername;


	
	public static List<Byteacherlist> listGroup(String params) {
		List<Byteacherlist> Group = new ArrayList<Byteacherlist>();
			
			String strJson=webservice.rundata("teacherlist",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byteacherlist obj=new Byteacherlist();
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
