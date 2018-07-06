package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.example.zhuwangtu.RadarChartView;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byabilityfiles;
import webservice.Bycoursenumber;
import webservice.Bydaaplyability;
import webservice.Bydaselfcontrolability;
import webservice.Bydasocialcontactability;
import webservice.Bydastudyability;
import webservice.Bydastudytime;
import webservice.Byshixunjihua;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class nengli_lvActivity extends Activity {
	ArrayList<ApkEntity> apk_list;
	final Context context = this;
	String ret1;
	String ret2;
	String ret3;
	String ret4;
	String ret5;
	float weight1;
	float weight2;
	float weight3;
	float weight4;
	float weight5;
	String account = ApkEntity.getaccount();
	String organization = ApkEntity.getorganization();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nenglidangan);
		

		com.example.zhuwangtu.RadarChartView student_zhuwangtu= (RadarChartView) findViewById(R.id.student_zhuwangtu);

		 Button nengli_backw = (Button)findViewById(R.id.nengli_backw);
		 nengli_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent intent = new Intent();  
	                intent.setClass(nengli_lvActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			}); 

		 String strParams = "account:" + account+"|organization:" + organization;
		 String strParams2 = "account:" + account;
		 ret1=Bydasocialcontactability.LogSelect(strParams2);
		 ret2=Bydaselfcontrolability.LogSelect(strParams2);
		 ret3=Bydastudytime.LogSelect(strParams);		 
		 ret4=Bydaaplyability.LogSelect(strParams2);
		 ret5=Bydastudyability.LogSelect(strParams2);
		 
		 weight1=Float.parseFloat(ret1);
		 weight2=Float.parseFloat(ret2);
		 weight3=Float.parseFloat(ret3);
		 weight4=Float.parseFloat(ret4);
		 weight5=Float.parseFloat(ret5);

		 ArrayList<Float> tmp = new ArrayList<Float>();   
     	tmp.add(weight1);
     	tmp.add(weight2);
     	tmp.add(weight3);
     	tmp.add(weight4);
     	tmp.add(weight5);
    
     	student_zhuwangtu.setzhuwangData(tmp);
	
	}
	
		
}
