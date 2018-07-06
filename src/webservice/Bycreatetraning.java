package webservice;

public class Bycreatetraning {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("createtraning", params);
		return result;
	}

}
