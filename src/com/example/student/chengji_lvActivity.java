package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byallmark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;


public class chengji_lvActivity extends Activity {
	ArrayList<ApkEntity> apk_list;
	String account = ApkEntity.getaccount();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.chengji_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chengjichaxun);
		
		setData();
		showList(apk_list);
		
		 Button chengji_backw = (Button)findViewById(R.id.chengji_backw);
		 chengji_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(chengji_lvActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	chengji_lvActivityAdapter adapter;
	ListView listview;
		
//	String account = ApkEntity.getaccount();
	String strParams = "account:" + account;
	List<Byallmark> lgroup=Byallmark.listGroup(strParams);

	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv_chengjiitem1(lgroup.get(i).coursename);
				entity.settv_chengjiitem3(lgroup.get(i).mark);
				apk_list.add(entity);
				
			}
		}
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.chengji_listview);
			adapter = new chengji_lvActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
}
