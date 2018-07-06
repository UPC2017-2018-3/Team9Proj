package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byorgananalysis {
	
	
	public String coursename;
	public String teacheraccount;
	public String xuankerenshu;
	public String pingjunchengji;
	public String jigerenshu;
	public String youxiurenshu;

	
	public static List<Byorgananalysis> listGroup(String params) {
		List<Byorgananalysis> Group = new ArrayList<Byorgananalysis>();
			
			String strJson=webservice.rundata("organanalysis",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byorgananalysis obj=new Byorgananalysis();
					JSONObject info=arrJson.getJSONObject(i);
					obj.coursename=info.getString("coursename");
					obj.teacheraccount=info.getString("teacheraccount");
					obj.xuankerenshu=info.getString("xuankerenshu");
					obj.pingjunchengji=info.getString("pingjunchengji");
					obj.jigerenshu=info.getString("jigerenshu");
					obj.youxiurenshu=info.getString("youxiurenshu");
					
					
					
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
