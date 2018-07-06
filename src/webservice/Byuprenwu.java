package webservice;

public class Byuprenwu {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("uprenwu", params);
		return result;
	}

}
