package webservice;

public class Bygonggaofourth {
	public static String gonggaofourthSelect(){
		return gonggaofourthSelect("");
	}
	public static String gonggaofourthSelect(String params){
		String result = webservice.rundata("gonggaofourth", params);
		return result;
	}
}
