package webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Byorganstudentmark {
	
	public String coursename;
	 public String mark;	 

			public static List<Byorganstudentmark> listGroup(String params) {
				List<Byorganstudentmark> Group = new ArrayList<Byorganstudentmark>();
					
					String strJson=webservice.rundata("organstudentmark",params);
					try {
//						JSONObject dataJson=new JSONObject(strJson);
//						JSONArray arrJson=dataJson.getJSONArray("tbGroup1");
						JSONArray arrJson = new JSONArray(strJson);
								
						for(int i=0;i<arrJson.length();i++)
						{
							Byorganstudentmark obj=new Byorganstudentmark();
							JSONObject info=arrJson.getJSONObject(i);
							obj.coursename=info.getString("coursename");	
							obj.mark=info.getString("mark");	
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
