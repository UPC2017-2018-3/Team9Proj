package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byabilityfiles;
import webservice.Byallxueyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class xueyouquan_lvActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	public static String xueyouquan_theme = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.xueyouquan_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xueyouquan);
		
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
				TextView tv1_item_xueyouquan = (TextView)view.findViewById(R.id.tv1_item_xueyouquan);
				String xueyouquan_theme = tv1_item_xueyouquan.getText().toString();
				((ApkEntity) getApplication()).setxueyouquan_theme(xueyouquan_theme);
				Intent intent = new Intent();  
                intent.setClass(xueyouquan_lvActivity.this, xueyouquanxiangqingActivity.class);    
                startActivity(intent);  				
			}			
		});
		
		 Button xueyouquan_backw = (Button)findViewById(R.id.xueyouquan_backw);
		 xueyouquan_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(xueyouquan_lvActivity.this, yuanxiaozhuye_Activity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	xueyouquan_lvActivityAdapter adapter;
	ListView listview;
	String organization = ApkEntity.getorganization();
	String strParams = "organization:" + organization;
	List<Byallxueyou> lgroup=Byallxueyou.listGroup(strParams);
	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv1_item_xueyouquan(lgroup.get(i).xueyoutitle);
				apk_list.add(entity);
				
			}
		}	
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.xueyouquan_listview);
			adapter = new xueyouquan_lvActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	

}
