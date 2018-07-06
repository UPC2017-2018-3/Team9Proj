package com.imooc.systemwork;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import teachingpart.teachingpage;
import webservice.Bydeletetcourse;
import webservice.Bydepartmentlist;
import webservice.Byupdepartment;

import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

public class department_management extends Activity implements IReflashListener,ILoadListener {
	
	final Context context = this;
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.department_management);
		Button fanhuibt = (Button) findViewById(R.id.department_returnbt);
		Button tianjia = (Button) findViewById(R.id.management_add);

		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(department_management.this, teachingpage.class);
				startActivity(intent);
			}
		});
		
		// add button listener
		tianjia.setOnClickListener(new Button.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						// get prompts.xml view
						LayoutInflater li = LayoutInflater.from(context);
						View promptsView = li.inflate(R.layout.prompts, null);

						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
								context);

						// set prompts.xml to alertdialog builder
						alertDialogBuilder.setView(promptsView);

						final EditText userInput = (EditText) promptsView
								.findViewById(R.id.editTextDialogUserInput);

						// set dialog message
						alertDialogBuilder
							.setCancelable(false)
							.setPositiveButton("OK",
							  new DialogInterface.OnClickListener() {
							    public void onClick(DialogInterface dialog,int id) {
								// get user input and set it to result
								// edit text
							    	String deadline=userInput.getText().toString();
							    	String str = "name:" + deadline;
									String retString=Byupdepartment.LogSelect(str);
									if (retString.equals("1")) {
							    		
										
										Toast.makeText(context,"院系添加成功",
												Toast.LENGTH_LONG).show();
										
									}
							    	else {
							    		Toast.makeText(context,"请重新添加！",
												Toast.LENGTH_LONG).show();
							    	}
							    }
							  })
							.setNegativeButton("Cancel",
							  new DialogInterface.OnClickListener() {
							    public void onClick(DialogInterface dialog,int id) {
								dialog.cancel();
							    }
							  });

						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();

						// show it
						alertDialog.show();
						alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
						alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
					}
				});
	}

	departmentAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.department_listview);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new departmentAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	
	String organization = ApkEntity.getorganization();
	String strParams = "organization:" + organization;
	List<Bydepartmentlist> lgroup=Bydepartmentlist.listGroup(strParams);

	private void setData() {
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setdepartment_t1(lgroup.get(i).departmentname);
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
