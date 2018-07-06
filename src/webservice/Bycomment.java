package webservice;

public class Bycomment {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("comment", params);
		return result;
	}

}
