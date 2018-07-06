package webservice;

public class Byxueyoufirst {
	public static String xueyoufirstSelect(){
		return xueyoufirstSelect("");
	}
	public static String xueyoufirstSelect(String params){
		String result = webservice.rundata("xueyoufirst", params);
		return result;
	}
}
