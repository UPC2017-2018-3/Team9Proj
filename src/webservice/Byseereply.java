package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byseereply {
	
	public String replyID;
	public String replywriter;
	public String replyrecieve;
	public String replycontent;
	public String coursename;
	public String writername;
	public String oldtime;
    
		

		
		public static List<Byseereply> listGroup(String params) {
			List<Byseereply> Group = new ArrayList<Byseereply>();
				
				String strJson=webservice.rundata("seereply",params);
				try {
//					JSONObject dataJson=new JSONObject(strJson);
//					JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
					JSONArray arrJson = new JSONArray(strJson);
							
					for(int i=0;i<arrJson.length();i++)
					{
						Byseereply obj=new Byseereply();
						JSONObject info=arrJson.getJSONObject(i);
						obj.replyID=info.getString("replyID");
						obj.replywriter=info.getString("replywriter");
						obj.replyrecieve=info.getString("replyrecieve");
						obj.replycontent=info.getString("replycontent");
						obj.coursename=info.getString("coursename");
						obj.writername=info.getString("writername");
						obj.oldtime=info.getString("oldtime");
						
						
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
