package webservice;

public class Byjsyoulianglv {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("jsyoulianglv", params);
		return result;
	}

}
