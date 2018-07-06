package webservice;

public class Bychangestudentname {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("changestudentname", params);
		return result;
	}

}
