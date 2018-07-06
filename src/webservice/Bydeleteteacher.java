package webservice;

public class Bydeleteteacher {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deleteteacher", params);
		return result;
	}


}
