package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byallxueyou;
import webservice.Byorganizationlist;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import teacherpart.teacher_course;
import teacherpart.teacher_coursemanagement;


public class yuanxiaoActivity extends Activity{

	ArrayList<ApkEntity> apk_list;

	/** Called when the activity is first created. */
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		
//		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//        .detectDiskReads()
//        .detectDiskWrites()
//        .detectNetwork()   // or .detectAll() for all detectable problems
//        .penaltyLog()
//        .build());
//   	 StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//        .detectLeakedSqlLiteObjects()
//        .detectLeakedClosableObjects()
//        .penaltyLog()
//        .penaltyDeath()
//        .build());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yuanxiaoxuanze);
		listview = (ListView) findViewById(R.id.yuanxiaoxuanze_listview);
		
		setData();
		showList(apk_list);
		
		Button yuanxiao_backw=(Button) findViewById(R.id.yuanxiao_backw);
		yuanxiao_backw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaoActivity.this,youke_MainActivity.class);
                startActivity(intent);
			}
		});
		
		listview.setOnItemClickListener(new OnItemClickListener(){  
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				//获取当前item的数据
				TextView tv = (TextView)view.findViewById(R.id.tv1_item_yuanxiaoxuanze);
				String organization = tv.getText().toString();
				((ApkEntity) getApplication()).setorganization(organization);
				Intent intent = new Intent(yuanxiaoActivity.this,yuanxiaozhuye_Activity.class);  
	            startActivity(intent);  
			}                                 
	    });
		
		/*Button btn_yuanxiao_confirm=(Button) findViewById(R.id.btn_yuanxiao_confirm);*/
		/*btn_yuanxiao_confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaoActivity.this,yuanxiaozhuye_Activity.class);
                startActivity(intent);
			}
		});*/

	}
	yuanxiaoActivityAdapter adapter;
	ListView listview;
	List<Byorganizationlist> lgroup=Byorganizationlist.listGroup();
	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv1_item_yuanxiaoxuanze(lgroup.get(i).organizationname);
				apk_list.add(entity);
				
			}
		}	
	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.yuanxiaoxuanze_listview);
			adapter = new yuanxiaoActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
}
