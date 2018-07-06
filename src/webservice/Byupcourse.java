package webservice;

public class Byupcourse {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("upcourse", params);
		return result;
	}

}
