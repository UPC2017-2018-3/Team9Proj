package com.example.student;

import webservice.BystudentRegister;

import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registActivity extends Activity{
	public EditText edit_regist_username,edit_registpwd,edit_registpwd2;
	public Button btn_regist;
	public String account,password,password2;
	public String m_strSharedFileName="SharedFileName";
	public static int m_nMode=Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE;
	public String username= "username";	
	public String pwd="password";

	 protected void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.regist); 

	        edit_regist_username=(EditText) findViewById(R.id.edit_regist_username);
	        edit_registpwd=(EditText) findViewById(R.id.edit_registpwd);
	        edit_registpwd2=(EditText) findViewById(R.id.edit_registpwd2);
	        
	        
			btn_regist=(Button) findViewById(R.id.btn_regist1);
			Button regist_backw=(Button) findViewById(R.id.regist_backw);
			regist_backw.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();  
		                intent.setClass(registActivity.this, loginActivity.class);
		                startActivity(intent);
					}
				});
			btn_regist.setOnClickListener(new OnClickListener() {
				 
				 @Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
					 account=edit_regist_username.getText().toString().trim();
				        password=edit_registpwd.getText().toString().trim();
				        password2=edit_registpwd2.getText().toString().trim();
					
					 String strParams = "account:" + account
								+ "|password:" + password+"|password2:" + password2;
						String retString=BystudentRegister.studentRegisterSelect(strParams);
			if(retString.equals("1")){
				Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
				
				SharedPreferences clsSharedPreferences = getSharedPreferences(m_strSharedFileName, m_nMode);
        		clsSharedPreferences.edit()
        		.putString(username,edit_regist_username.getText().toString().trim())
        		.putString(pwd, edit_registpwd.getText().toString().trim())
        		.commit();//һ��Ҫ�ύ����Ч
       		
				Intent intent = new Intent();  
                intent.setClass(registActivity.this,loginActivity.class);
                startActivity(intent);
                
			}else if(retString.equals("0")){
				Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_LONG).show();
				
			}else if(retString.equals("2")){
				Toast.makeText(getApplicationContext(), "用户已存在，请重新注册", Toast.LENGTH_LONG).show();
				
			}
				 }
			 });
			
}
}
