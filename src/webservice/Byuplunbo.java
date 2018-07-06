package webservice;

public class Byuplunbo {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("uplunbo", params);
		return result;
	}

}
