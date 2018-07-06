package webservice;

public class Bydeletestudent {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletestudent", params);
		return result;
	}


}
