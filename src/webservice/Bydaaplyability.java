package webservice;

public class Bydaaplyability {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("daaplyability", params);
		return result;
	}


}
