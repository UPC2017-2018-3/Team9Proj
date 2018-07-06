package webservice;

public class Bydastudytime {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("dastudytime", params);
		return result;
	}

}
