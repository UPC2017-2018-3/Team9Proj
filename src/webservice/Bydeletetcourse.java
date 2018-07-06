package webservice;

public class Bydeletetcourse {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletetcourse", params);
		return result;
	}

}
