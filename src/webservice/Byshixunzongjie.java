package webservice;

public class Byshixunzongjie {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("shixunzongjie", params);
		return result;
	}

}
