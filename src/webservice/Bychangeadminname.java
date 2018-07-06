package webservice;

public class Bychangeadminname {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("changeadminname", params);
		return result;
	}

}
