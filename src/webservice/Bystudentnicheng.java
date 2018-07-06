package webservice;

public class Bystudentnicheng {
	
	public static String studentRegisterSelect(){
		return studentRegisterSelect("");
	}
	public static String studentRegisterSelect(String params){
		String result = webservice.rundata("studentnicheng", params);
		return result;
	}

}
