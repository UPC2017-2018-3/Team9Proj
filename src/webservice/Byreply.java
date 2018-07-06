package webservice;

public class Byreply {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("reply", params);
		return result;
	}

}
