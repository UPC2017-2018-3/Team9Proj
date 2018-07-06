package webservice;

import webservice.webservice;

public class Bydeletewords {

	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletewords", params);
		return result;
	}
}
