package webservice;

public class Byxueyouthird {
	public static String xueyouthirdSelect(){
		return xueyouthirdSelect("");
	}
	public static String xueyouthirdSelect(String params){
		String result = webservice.rundata("xueyouthird", params);
		return result;
	}
}
