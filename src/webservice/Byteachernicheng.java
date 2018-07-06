package webservice;

public class Byteachernicheng {
	
	public static String studentRegisterSelect(){
		return studentRegisterSelect("");
	}
	public static String studentRegisterSelect(String params){
		String result = webservice.rundata("teachernicheng", params);
		return result;
	}

}
