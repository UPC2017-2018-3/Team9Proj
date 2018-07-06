package webservice;

public class Byadminnicheng {
	
	public static String studentRegisterSelect(){
		return studentRegisterSelect("");
	}
	public static String studentRegisterSelect(String params){
		String result = webservice.rundata("adminnicheng", params);
		return result;
	}

}
