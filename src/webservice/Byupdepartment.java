package webservice;

public class Byupdepartment {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("updepartment", params);
		return result;
	}

}
