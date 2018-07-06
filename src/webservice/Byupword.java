package webservice;

public class Byupword {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("upword", params);
		return result;
	}

}
