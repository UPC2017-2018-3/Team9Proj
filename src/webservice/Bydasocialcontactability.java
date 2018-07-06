package webservice;

public class Bydasocialcontactability {
	
	public static String LogSelect(){
		return LogSelect("");
	}
	public static String LogSelect(String params){
		String result = webservice.rundata("dasocialcontactability", params);
		return result;
	}

}
