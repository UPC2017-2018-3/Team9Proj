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

public class cuoti_lvActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.xiaoneizixun_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiaoneizixun);
		
		setData();
		showList(apk_list);
//		parent �������������AdapterView;
//		view ��AdapterView�б��������ͼ(������adapter�ṩ��һ����ͼ);
//        position ��ͼ��adapter�е�λ��;
//        id �����Ԫ�ص���id;
		listview.setOnItemClickListener(new OnItemClickListener(){

			@Override

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(getApplicationContext(),
						 "你点击的是" + position + "项", Toast.LENGTH_LONG).show();
				Intent intent = new Intent();  
                intent.setClass(cuoti_lvActivity.this, zixunxiangqingActivity.class);    
                startActivity(intent);  
				
			}
			
		});
		
		 Button zixun_backw = (Button)findViewById(R.id.zixun_backw);
		 zixun_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(cuoti_lvActivity.this, yuanxiaozhuye_Activity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	zixun_lvActivityAdapter adapter;
	ListView listview;
	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < 10; i++) {
				ApkEntity entity = new ApkEntity();
//				entity.setzixun_img2(R.id.zixun_img2);
				entity.setzixun_title("第三届校园征集");
				apk_list.add(entity);
			}
		}
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.xiaoneizixun_listview);
			adapter = new zixun_lvActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}

}
