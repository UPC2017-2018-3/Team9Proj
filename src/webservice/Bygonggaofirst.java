package webservice;

public class Bygonggaofirst {
	public static String gonggaofirstSelect(){
		return gonggaofirstSelect("");
	}
	public static String gonggaofirstSelect(String params){
		String result = webservice.rundata("gonggaofirst", params);
		return result;
	}
}
