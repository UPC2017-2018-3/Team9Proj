package webservice;

public class Byupclass {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("upclass", params);
		return result;
	}

}
