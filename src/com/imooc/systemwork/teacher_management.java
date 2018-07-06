package com.imooc.systemwork;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import teachingpart.teachingpage;
import webservice.Bydepartmentlist;
import webservice.Byteacherlist;

public class teacher_management extends Activity implements IReflashListener,ILoadListener{
	
	ArrayList<ApkEntity> apk_list;
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_management);
		Button fanhuibt = (Button) findViewById(R.id.teacher_returnbt);


		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_management.this, teachingpage.class);
				startActivity(intent);
			}
		});
		
		
	}

	teacherAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.teacher_listview);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teacherAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	String organization = ApkEntity.getorganization();
	String strParams = "organization:" + organization;
	List<Byteacherlist> lgroup=Byteacherlist.listGroup(strParams);

	private void setData() {
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setteacher_1(lgroup.get(i).teachername);
			/*entity.setDes("锟斤拷锟斤拷�?锟斤拷锟斤拷锟斤拷锟接︼拷锟�?");
			entity.setInfo("50w锟矫伙拷");*/
			apk_list.add(entity);
		}
	}

	private void setReflashData() {
		
	}
	private void getLoadData() {
		
	}
	@Override
	public void onReflash() {
		// TODO Auto-generated method stub\
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷
				setReflashData();
				//通知锟斤拷锟斤拷锟斤拷示
				showList(apk_list);
				//通知listview 刷锟斤拷锟斤拷锟斤拷锟斤拷希锟�
				listview.reflashComplete();
			}
		}, 2000);
		
	}
	public void onLoad() {
		// TODO Auto-generated method stub
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getLoadData();
				showList(apk_list);
				listview.loadComplete();
			}
		}, 2000);
	}

}