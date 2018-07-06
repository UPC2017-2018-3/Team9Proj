package webservice;

public class Bygonggaothird {
	public static String gonggaothirdSelect(){
		return gonggaothirdSelect("");
	}
	public static String gonggaothirdSelect(String params){
		String result = webservice.rundata("gonggaothird", params);
		return result;
	}
}
