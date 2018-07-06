package webservice;

public class Byjsrenwufinish {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("jsrenwufinish", params);
		return result;
	}

}
