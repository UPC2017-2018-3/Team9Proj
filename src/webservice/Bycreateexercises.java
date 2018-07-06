package webservice;

public class Bycreateexercises {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("createexercises", params);
		return result;
	}
	

}
