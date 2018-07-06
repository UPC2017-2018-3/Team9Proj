package com.example.student;

import java.util.ArrayList;

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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class xiaoxi_lvActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.xiaoxi_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiaoxi);
		
		setData();
		showList(apk_list);
				
		 Button xiaoxi_backw = (Button)findViewById(R.id.xiaoxi_backw);
		 xiaoxi_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(xiaoxi_lvActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	xiaoxi_lvAdapter adapter;
	ListView listview;
	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < 10; i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv_xiaoxi1("教师端");
				entity.settv_xiaoxi3("作业以发布");
				apk_list.add(entity);
			}
		}
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.xiaoxi_listview);
			adapter = new xiaoxi_lvAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
}
