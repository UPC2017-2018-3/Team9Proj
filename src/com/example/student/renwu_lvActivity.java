package com.example.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byrenwustate;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class renwu_lvActivity extends Activity {
	
	String account = ApkEntity.getaccount();
	ArrayList<ApkEntity> apk_list;
	public ImageView iv_renwuitem1;
	public TextView textView1_renwu;
	public static String renwu_theme = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.renwu_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.woderenwu);
		
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
				TextView tv_renwuitem2 = (TextView)view.findViewById(R.id.tv_renwuitem2);
				String renwu_theme = tv_renwuitem2.getText().toString();
				((ApkEntity) getApplication()).setxueyouquan_theme(renwu_theme);
				Intent intent = new Intent();  
                intent.setClass(renwu_lvActivity.this, renwuxiangqingActivity.class);    
                startActivity(intent);  				
			}			
		});
		
		 Button renwu_backw = (Button)findViewById(R.id.renwu_backw);
		 renwu_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(renwu_lvActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	renwu_lvActivityAdapter adapter;
	ListView listview;
	String strParams = "account:" + account;
	List<Byrenwustate> lgroup=Byrenwustate.listGroup(strParams);
	
	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				iv_renwuitem1=(ImageView) findViewById(R.id.iv_renwuitem1);
				if(lgroup.get(i).renwustate=="1"){
					iv_renwuitem1.setBackgroundResource(R.drawable.done);
				}
				else if(lgroup.get(i).renwustate=="0"){
					iv_renwuitem1.setBackgroundResource(R.drawable.doing);
				}
				entity.settv_renwuitem2(lgroup.get(i).renwu);				
				apk_list.add(entity);
			}
		}
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.renwu_listview);
			adapter = new renwu_lvActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
}
