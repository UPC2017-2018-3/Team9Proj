package webservice;

public class Bychangeicon1 {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("changeicon1", params);
		return result;
	}

}
