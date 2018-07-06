package webservice;

public class Bydastudyability {

	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("dastudyability", params);
		return result;
	}
}
