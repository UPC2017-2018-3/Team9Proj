package webservice;

public class Bydeletelivepath {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletelivepath", params);
		return result;
	}


}
