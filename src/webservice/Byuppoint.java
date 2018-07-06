package webservice;

public class Byuppoint {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("uppoint", params);
		return result;
	}

}
