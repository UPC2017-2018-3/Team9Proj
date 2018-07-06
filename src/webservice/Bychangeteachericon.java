package webservice;


public class Bychangeteachericon {
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("changeteachericon", params);
		return result;
	}

}
