package webservice;

public class Byuplivepath {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("uplivepath", params);
		return result;
	}

}
