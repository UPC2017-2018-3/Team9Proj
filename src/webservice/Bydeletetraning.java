package webservice;

public class Bydeletetraning {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deletetraning", params);
		return result;
	}

}
