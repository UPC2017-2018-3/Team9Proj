package webservice;


public class Bylogin {
	public static String loginSelect(){
		return loginSelect("");
	}
	public static String loginSelect(String params){
		String result = webservice.rundata("login", params);
		return result;
	}

}
