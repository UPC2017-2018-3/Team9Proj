package webservice;

public class Byjsstudentnum {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("jsstudentnum", params);
		return result;
	}

}
