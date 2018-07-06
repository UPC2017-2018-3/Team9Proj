package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

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
import webservice.Bycoursepandicture;
import webservice.Bystudystudentlist;

public class allkechengActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	String organization = ApkEntity.getorganization();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.allkecheng_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allkecheng);
		
		setData();
		showList(apk_list);
		
		 Button allkecheng_backw = (Button)findViewById(R.id.allkecheng_backw);
		 allkecheng_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(allkechengActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			});  
		 listview.setOnItemClickListener(new OnItemClickListener(){  
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					//获取当前item的数据
					String strParams = "organization:" + organization;
					List<Bycoursepandicture> lgroup=Bycoursepandicture.listGroup(strParams);
					String teacher_account = lgroup.get(position).courseteacheraccount;
					String coursename = lgroup.get(position).coursename;
					((ApkEntity) getApplication()).setteacher_account(teacher_account);
					((ApkEntity) getApplication()).setcoursename(coursename);
					Intent intent = new Intent(allkechengActivity.this,kecheng_MainActivity.class);  
		            startActivity(intent);  
				}                                 
		    });
		
	
	}
	allkecheng_ActivityAdapter adapter;
	ListView listview;
		

	   

	  //д������
		private void setData() {
			String strParams = "organization:" + organization;
			List<Bycoursepandicture> lgroup=Bycoursepandicture.listGroup(strParams);
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv_chengjiitem1(lgroup.get(i).coursename);
				entity.setpictureUrls(lgroup.get(i).coursepicture);
				apk_list.add(entity);
				
			}
		}
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.allkecheng_listview);
			adapter = new allkecheng_ActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	

}
