package webservice;



public class Bycoursenumber {
	public static String coursenumberSelect(){
		return coursenumberSelect("");
	}
	public static String coursenumberSelect(String params){
		String result = webservice.rundata("coursenumber", params);
		return result;
	}
	

}
