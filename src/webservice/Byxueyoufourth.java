package webservice;

public class Byxueyoufourth {
	public static String xueyoufourthSelect(){
		return xueyoufourthSelect("");
	}
	public static String xueyoufourthSelect(String params){
		String result = webservice.rundata("xueyoufourth", params);
		return result;
	}
}
