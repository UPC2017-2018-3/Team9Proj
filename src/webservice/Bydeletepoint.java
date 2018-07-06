package webservice;

public class Bydeletepoint {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletepoint", params);
		return result;
	}

}
