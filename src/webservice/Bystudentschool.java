package webservice;

public class Bystudentschool {
	public static String studentschoolSelect(){
		return studentschoolSelect("");
	}
	public static String studentschoolSelect(String params){
		String result = webservice.rundata("studentschool", params);
		return result;
	}
}
