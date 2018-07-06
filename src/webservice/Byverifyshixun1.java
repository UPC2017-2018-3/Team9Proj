package webservice;

public class Byverifyshixun1 {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("verifyshixun1", params);
		return result;
	}

}
