package com.example.student;

import webservice.Bylogin;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import teacherpart.teacherpage;
import teachingpart.teachingpage;

import com.imooc.systemwork.ApkEntity;

public class loginActivity extends Activity{
	
	  public EditText edit_login_username,edit_loginpwd;
	  public RadioButton radioButton1,radioButton2,radioButton3;
	  public RadioGroup radgActButton01;
	  public Button btn_login,btn_regist,btn_forgetpwd,login_backw;
	  public String account,identity,password;
	  public String m_strSharedFileName="SharedFileName";
	  public String username= "username";	
	  public String pwd="password";
	  public static int m_nMode=Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE;
	  protected void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login); 
	        
	        edit_login_username=(EditText) findViewById(R.id.edit_login_username);
	        edit_loginpwd=(EditText) findViewById(R.id.edit_loginpwd); 
	        SharedPreferences clsSharedPreferences = getSharedPreferences(m_strSharedFileName, m_nMode);
			String user = clsSharedPreferences.getString(username, "");
			edit_login_username.setText(user);
			String pass = clsSharedPreferences.getString(pwd, "");
			edit_loginpwd.setText(pass);
	        
	        
	        radgActButton01=(RadioGroup) findViewById(R.id.radgActButton01);
	        radioButton1=(RadioButton) findViewById(R.id.radioButton1);
	        radioButton2=(RadioButton) findViewById(R.id.radioButton2);
	        radioButton3=(RadioButton) findViewById(R.id.radioButton3);
	        radgActButton01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	                if (radioButton1.getId() == checkedId) {
	                	identity = radioButton1.getText().toString();
	                } else if (radioButton2.getId() == checkedId) {
	                	identity = radioButton2.getText().toString();
	                }
	                else if (radioButton3.getId() == checkedId) {
	                	identity = radioButton3.getText().toString();
	                }
	            }
	        });
	       
	        
	        
	        btn_login=(Button) findViewById(R.id.btn_login);
	        btn_login.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					account=edit_login_username.getText().toString().trim();
					password=edit_loginpwd.getText().toString().trim();
					String strParams = "identity:" + identity+"|account:" + account
							+ "|password:" + password;
					String retString=Bylogin.loginSelect(strParams);
					if(retString.equals("1")){
						 ((ApkEntity) getApplication()).setaccount(account);
						Toast.makeText(getApplicationContext(), "登陆成功即将进入学生主页", Toast.LENGTH_LONG).show();
						Intent intent = new Intent();  
		                intent.setClass(loginActivity.this,student_MainActivity.class);
		                startActivity(intent);
					}else if(retString.equals("2")){
						 ((ApkEntity) getApplication()).setaccount(account);
						Toast.makeText(getApplicationContext(), "登陆成功即将进入教师主页", Toast.LENGTH_LONG).show();
						Intent intent = new Intent();  
		                intent.setClass(loginActivity.this,teacherpage.class);
		                startActivity(intent);
					}else if(retString.equals("3")){
						 ((ApkEntity) getApplication()).setaccount(account);
						Toast.makeText(getApplicationContext(), "登陆成功即将进入教务主页", Toast.LENGTH_LONG).show();
						Intent intent = new Intent();  
		                intent.setClass(loginActivity.this,teachingpage.class);
		                startActivity(intent);
					}else if(retString.equals("0")){
						Toast.makeText(getApplicationContext(), "登陆失败请检查登陆", Toast.LENGTH_LONG).show();
						edit_login_username.setText("");
						edit_loginpwd.setText("");
					}
					
					
				}
			});
	        
	        btn_regist=(Button) findViewById(R.id.btn_regist);
	        btn_regist.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(loginActivity.this, registActivity.class);
	                startActivity(intent);
				}
			});
	        
	        btn_forgetpwd=(Button) findViewById(R.id.btn_forgetpwd);
	        btn_forgetpwd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(loginActivity.this, findpwdActivity.class);
	                startActivity(intent);
				}
			});
	        login_backw=(Button) findViewById(R.id.login_backw);
	        login_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(loginActivity.this, yuanxiaozhuye_Activity.class);
	                startActivity(intent);
				}
			});
	        
}
}
