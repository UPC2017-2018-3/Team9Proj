package webservice;

public class Bydeleteexercise {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deleteexercise", params);
		return result;
	}

}
