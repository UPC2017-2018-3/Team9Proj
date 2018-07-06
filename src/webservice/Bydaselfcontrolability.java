package webservice;

public class Bydaselfcontrolability {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("daselfcontrolability", params);
		return result;
	}

}
