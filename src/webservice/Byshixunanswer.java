package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byshixunanswer {
	
	public String question;
	public String A;
	public String B;
	public String C;
	public String D;
	public String aa;
	public String ab;
	public String ac;
    public String ad;		
    public String answer;
	public static List<Byshixunanswer> listGroup(String params) {
		List<Byshixunanswer> Group = new ArrayList<Byshixunanswer>();
			
			String strJson=webservice.rundata("shixunanswer",params);
			try {
//				JSONObject dataJson=new JSONObject(strJson);
//				JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
				JSONArray arrJson = new JSONArray(strJson);
						
				for(int i=0;i<arrJson.length();i++)
				{
					Byshixunanswer obj=new Byshixunanswer();
					JSONObject info=arrJson.getJSONObject(i);
					obj.question=info.getString("question");
					obj.A=info.getString("A");
					obj.B=info.getString("B");
					obj.C=info.getString("C");
					obj.D=info.getString("D");
					obj.aa=info.getString("aa");
					obj.ab=info.getString("ab");
					obj.ac=info.getString("ac");
					obj.ad=info.getString("ad");
					obj.answer=info.getString("answer");
					
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
