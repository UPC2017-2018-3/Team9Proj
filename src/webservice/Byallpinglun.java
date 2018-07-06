package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byallpinglun {
	
	public String jiaoliuwriter;
	public String writericon;
	public String jiaoliutext;


	
	public static List<Byallpinglun> listGroup(String params) {
		List<Byallpinglun> Group = new ArrayList<Byallpinglun>();
			
			String strJson=webservice.rundata("allpinglun",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byallpinglun obj=new Byallpinglun();
					JSONObject info=arrJson.getJSONObject(i);
					obj.jiaoliuwriter=info.getString("jiaoliuwriter");
					obj.writericon=info.getString("writericon");
					obj.jiaoliutext=info.getString("jiaoliutext");
					
					
					
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
