package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byseecomment {
	
	public String jiaoliuID;
	public String jiaoliutext;
	public String jiaoliuwriter;
	public String jiaoliutime;
	public String jiaoliushixun;
	public String writername;
    
		

		
		public static List<Byseecomment> listGroup(String params) {
			List<Byseecomment> Group = new ArrayList<Byseecomment>();
				
				String strJson=webservice.rundata("seecomment",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byseecomment obj=new Byseecomment();
						JSONObject info=arrJson.getJSONObject(i);
						obj.jiaoliuID=info.getString("jiaoliuID");
						obj.jiaoliutext=info.getString("jiaoliutext");
						obj.jiaoliuwriter=info.getString("jiaoliuwriter");
						obj.jiaoliutime=info.getString("jiaoliutime");
						obj.jiaoliushixun=info.getString("jiaoliushixun");
						obj.writername=info.getString("writername");
						
						
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
