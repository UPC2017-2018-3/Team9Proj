package webservice;

public class Byverifyshixun {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("verifyshixun", params);
		return result;
	}

}
