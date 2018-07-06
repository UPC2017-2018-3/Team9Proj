package com.example.student;


import webservice.BystudentChangePassword;
import webservice.BystudentRegister;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class setpwdActivity extends Activity{
	public EditText edit_setpwd_pwd1,edit_setpwd_pwd2;
	String account = ApkEntity.getaccount();
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.setpwd);
//	        getActionBar().hide();
	       edit_setpwd_pwd1 = (EditText) findViewById(R.id.edit_setpwd_phone_name);
	        edit_setpwd_pwd2 = (EditText) findViewById(R.id.edit_findpwd);
	        
	        Button btn_setpwd_confirm=(Button) findViewById(R.id.btn_setpwd_confirm);
	        btn_setpwd_confirm.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					   
               String password=edit_setpwd_pwd1.getText().toString();
               String newpassword=edit_setpwd_pwd2.getText().toString();
               String strParams = "account:" + account
   					+ "|password:" + password+"|newpassword:" + newpassword;
               String retString=BystudentChangePassword.studentChangePasswordSelect(strParams);	
               if(retString.equals("1")){
   				  Toast.makeText(getApplicationContext(), "修改失败", Toast.LENGTH_LONG).show();
   			   }else if(retString.equals("0")){
   				  Toast.makeText(getApplicationContext(), "修改失败！", Toast.LENGTH_LONG).show();
   				
   			   }else if(retString.equals("2")){
   				  Toast.makeText(getApplicationContext(), "原始密码错误", Toast.LENGTH_LONG).show();
   				
   			   }		
			
				}
				});
	        
	        Button setpwd_backw=(Button) findViewById(R.id.setpwd_backw);
	        setpwd_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent();
					intent.setClass(setpwdActivity.this,student_MainActivity.class);
	                startActivity(intent);
					
				}
			});
	        
		}

}
