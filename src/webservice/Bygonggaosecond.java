package webservice;

public class Bygonggaosecond {
	public static String gonggaosecondSelect(){
		return gonggaosecondSelect("");
	}
	public static String gonggaosecondSelect(String params){
		String result = webservice.rundata("gonggaosecond", params);
		return result;
	}
}
