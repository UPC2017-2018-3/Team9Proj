package webservice;

public class Bydeleteclass {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("deleteclass", params);
		return result;
	}


}
