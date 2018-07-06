package com.example.student;


import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byzixunlist;
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

public class zixun_yuanxiaoActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	ApkEntity entity = new ApkEntity();
	public static String title = null;
	public static String theme = null;
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
				TextView tv = (TextView)view.findViewById(R.id.zixun_title);
				@SuppressWarnings("unused")
				String theme = tv.getText().toString();
				((ApkEntity) getApplication()).settheme(theme);
//				Toast.makeText(getApplicationContext(),
//						 theme, Toast.LENGTH_LONG).show();
				Intent intent = new Intent();  
                intent.setClass(zixun_yuanxiaoActivity.this, zixunxiangqingActivity.class);    
                startActivity(intent);  
				
			}
			
		});
		
		 Button zixun_backw = (Button)findViewById(R.id.zixun_backw);
		 zixun_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(zixun_yuanxiaoActivity.this, yuanxiaozhuye_Activity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	zixun_lvActivityAdapter adapter;
	ListView listview;
	String strParams = "organization:" + "上天大学";
   List<Byzixunlist> lgroup=Byzixunlist.listGroup(strParams);
	
	//д������
			private void setData() {
				apk_list = new ArrayList<ApkEntity>();
				for (int i = 0; i < lgroup.size(); i++) {
					ApkEntity entity = new ApkEntity();
					entity.setzixun_title(lgroup.get(i).zixuntitle);	
					entity.setzixun_img2(lgroup.get(i).zixunpicture);
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
