package webservice;

public class BystudentChangePassword {
	public static String studentChangePasswordSelect(){
		return studentChangePasswordSelect("");
	}
	public static String studentChangePasswordSelect(String params){
		String result = webservice.rundata("studentChangePassword", params);
		return result;
	}

}
