package webservice;

public class Byrenwucontent {
	
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("renwucontent", params);
		return result;
	}

}
