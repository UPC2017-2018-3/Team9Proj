package webservice;

public class Byshixunjihua {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("shixunjihua", params);
		return result;
	}
}
