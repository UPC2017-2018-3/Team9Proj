package webservice;

public class Bychangeteachername {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("changeteachername", params);
		return result;
	}

}
