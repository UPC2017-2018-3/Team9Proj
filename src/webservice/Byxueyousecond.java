package webservice;

public class Byxueyousecond {
	public static String xueyousecondSelect(){
		return xueyousecondSelect("");
	}
	public static String xueyousecondSelect(String params){
		String result = webservice.rundata("xueyousecond", params);
		return result;
	}
}
