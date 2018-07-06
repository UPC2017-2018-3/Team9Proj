package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.example.dati.MainActivity;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byabilityfiles;
import webservice.Byallstudentcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import teacherpart.teacher_course;
import teacherpart.teacher_coursemanagement;

public class zongheshixun_lvActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	String account = ApkEntity.getaccount();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.zongheshixun_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zongheshixun);
		
		setData();
		showList(apk_list);
	
		 Button zongheshixun_backw = (Button)findViewById(R.id.zongheshixun_backw);
		 zongheshixun_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(zongheshixun_lvActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			});
		 listview.setOnItemClickListener(new OnItemClickListener(){  
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					//获取当前item的数据
					TextView tv = (TextView)view.findViewById(R.id.tv1_item_shixun1);
					String coursename = tv.getText().toString();
					((ApkEntity)getApplication()).setzhuangtai("实训");
					((ApkEntity) getApplication()).setcoursename(coursename);
					Intent intent = new Intent(zongheshixun_lvActivity.this,MainActivity.class);  
		            startActivity(intent);  
				}                                 
		    });
		
	
	}
	zongheshixun_lvActivityAdapter adapter;
	ListView listview;
	String strParams = "account:" + account;
    List<Byallstudentcourse> lgroup=Byallstudentcourse.listGroup(strParams);
	
	//д������
			private void setData() {
				apk_list = new ArrayList<ApkEntity>();
				for (int i = 0; i < lgroup.size(); i++) {
					ApkEntity entity = new ApkEntity();
					entity.settv1_item_shixun1(lgroup.get(i).coursename);
					apk_list.add(entity);
					
				}
			}	
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.zongheshixun_listview);
			adapter = new zongheshixun_lvActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}


}
