package webservice;

public class Bydeletedepartment {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletedepartment", params);
		return result;
	}

}
