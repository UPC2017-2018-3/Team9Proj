package webservice;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.annotation.SuppressLint;
import android.widget.Toast;

public class webservice {

private static String URL="http://59.110.235.44:94/Service.asmx";
	
	private static String NAMESPACE="http://tempuri.org/";
	
	public webservice(){
		
	}
		
	public static String rundata(String Methodname,String Params){
		String strRet="";
		
		try{
			String METHOD_NAME=Methodname;
			String SOAP_ACTION = NAMESPACE+METHOD_NAME;
			SoapObject rpc=new SoapObject(NAMESPACE, METHOD_NAME);
			
			String[] strList=Params.split("\\|");
			for(int i=0;i<strList.length;i++){
				if(strList[i].equals("")){}
				else {				
				String[] strKV=strList[i].split("\\:");				
				rpc.addProperty(strKV[0], strKV[1]);
				}				
				
			}
			
			//设置调用WebService方法的SOAP请求信息,并指定SOAP的版本
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.bodyOut=rpc;
			//设置是否调用的是dotNet开发的WebService 
			envelope.dotNet=true;
			envelope.setOutputSoapObject(rpc);			
			
			HttpTransportSE ht= new HttpTransportSE(URL);
			ht.debug=true;
			ht.call(SOAP_ACTION, envelope);
//			ht.call(null, envelope);
			
			
//			Object soapObject = (Object) envelope.getResponse();
//			 strRetString = soapObject.toString();
//			 SoapObject soapObject = (SoapObject) envelope.bodyIn;
//			 strRetString = soapObject.getProperty(0).toString();
			
			///接收返回的对象
			 Object object = (Object) envelope.getResponse();
			    try{
			    	SoapObject soapObject=(SoapObject)object;
			    	if(soapObject!=null)
			    	{
			    		strRet=soapObject.getProperty(0).toString();
			    	}	    	
			    }catch(Exception e){
			    	strRet=object.toString();
			    }
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return strRet;
	}
	public static float rundata2(String Methodname,String Params){
		float strRet = 0 ;
		
		try{
			String METHOD_NAME=Methodname;
			String SOAP_ACTION = NAMESPACE+METHOD_NAME;
			SoapObject rpc=new SoapObject(NAMESPACE, METHOD_NAME);
			
			String[] strList=Params.split("\\|");
			for(int i=0;i<strList.length;i++){
				if(strList[i].equals("")){}
				else {				
				String[] strKV=strList[i].split("\\:");				
				rpc.addProperty(strKV[0], strKV[1]);
				}				
				
			}
			
			//设置调用WebService方法的SOAP请求信息,并指定SOAP的版本
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.bodyOut=rpc;
			//设置是否调用的是dotNet开发的WebService 
			envelope.dotNet=true;
			envelope.setOutputSoapObject(rpc);			
			
			HttpTransportSE ht= new HttpTransportSE(URL);
			ht.debug=true;
			ht.call(SOAP_ACTION, envelope);
//			ht.call(null, envelope);
			
			
//			Object soapObject = (Object) envelope.getResponse();
//			 strRetString = soapObject.toString();
//			 SoapObject soapObject = (SoapObject) envelope.bodyIn;
//			 strRetString = soapObject.getProperty(0).toString();
			
			///接收返回的对象
			 Object object = (Object) envelope.getResponse();
			    try{
			    	SoapObject soapObject=(SoapObject)object;
			    	if(soapObject!=null)
			    	{
			    		strRet= (float) soapObject.getProperty(0);
			    	}	    	
			    }catch(Exception e){
			    	strRet= (float) object;
			    }
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return strRet;
	}
	
}
