package webservice;

public class BystudentRegister {
	public static String studentRegisterSelect(){
		return studentRegisterSelect("");
	}
	public static String studentRegisterSelect(String params){
		String result = webservice.rundata("studentRegister", params);
		return result;
	}
}
