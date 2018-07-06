package webservice;

public class Bydeletetcomment {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletetcomment", params);
		return result;
	}

}
