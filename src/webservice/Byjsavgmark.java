package webservice;

public class Byjsavgmark {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("jsavgmark", params);
		return result;
	}

}
