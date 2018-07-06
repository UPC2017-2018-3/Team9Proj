package teacherpart;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.ReFlashListView;
import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import webservice.Byteacherreturncourse;

public class comprehensive_training_course extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comprehensive_training_course);
		Button fanhuibt = (Button) findViewById(R.id.comprehensive_training_courserb);
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(comprehensive_training_course.this, teacherpage.class);
				startActivity(intent);
			}
		});
		listview.setOnItemClickListener(new OnItemClickListener(){  
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				//获取当前item的数据
				TextView tv = (TextView)view.findViewById(R.id.teacher_coursemanagementt1);
				final String coursename = tv.getText().toString();
				 new AlertDialog.Builder(view.getContext()).setTitle("提示").setMessage("请确定是否开始添加综合实训试题，开始后将不能二次修改")                  
		         .setPositiveButton("确定", new DialogInterface.OnClickListener()
		        		 {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				((ApkEntity) getApplication()).setcoursename(coursename);
				Intent intent = new Intent(comprehensive_training_course.this,comprehensive_training.class);  
	            startActivity(intent);  
				}
		        		 }).show().getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
			}                                 
	    });
	}
	teacher_coursemanagementrbAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.comprehensive_training_courselv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teacher_coursemanagementrbAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}

	String account = ApkEntity.getaccount();
	String strParams = "account:" + account;
	List<Byteacherreturncourse> lgroup=Byteacherreturncourse.listGroup(strParams);
	private void setData() {
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setteacher_coursemanagementt1(lgroup.get(i).coursename);
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
