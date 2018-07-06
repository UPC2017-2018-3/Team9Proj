package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.example.videopaly.video1;
import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.ReFlashListView;
import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import teachingpart.teachingpage;
import teachingpart.teachingpageAdapter;
import webservice.Byalllivepath;
import webservice.Bychangeicon1;
import webservice.Bysearchexercise;

public class zhibolist extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	String account = ApkEntity.getaccount();
	String organization = ApkEntity.getorganization();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhibolist);
		Button fanhuibt = (Button) findViewById(R.id.zhibolistrb);
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(zhibolist.this, student_MainActivity.class);
				startActivity(intent);
			}
		});
		
		listview.setOnItemClickListener(new OnItemClickListener(){  
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				//获取当前item的数据
				String strParams = "organization:" + organization;
				List<Byalllivepath> lgroup=Byalllivepath.listGroup(strParams);
			    String vodiourl = lgroup.get(position-1).teacheraccount;
			    String teachername = lgroup.get(position-1).teachername;
			    ((ApkEntity) getApplication()).setliveurl(vodiourl);
			    ((ApkEntity) getApplication()).setteachername(teachername);
				Intent intent = new Intent(); 
				intent.setClass(zhibolist.this, video1.class);
	            startActivity(intent);  
			}                                 
	    });
		
	}
	teachingpageAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.zhibolistlv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teachingpageAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
    
	private void setData() {
		String strParams = "organization:" + organization;
		List<Byalllivepath> lgroup=Byalllivepath.listGroup(strParams);
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.sethomepagelv_name(lgroup.get(i).teachername+"正在直播");
			apk_list.add(entity);
		}
	}

	private void setReflashData() {
		for (int i = 0; i < 2; i++) {
			ApkEntity entity = new ApkEntity();
			entity.sethomepagelv_name("《AE基础操作入门》");
			apk_list.add(0,entity);
		}
	}
	private void getLoadData() {
		for (int i = 0; i < 2; i++) {
			ApkEntity entity = new ApkEntity();
			entity.sethomepagelv_name("《PS基础操作入门》");
			apk_list.add(entity);
		}
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

