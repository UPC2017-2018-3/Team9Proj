package webservice;

public class Bychangecourseicon {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("changecourseicon", params);
		return result;
	}


}
