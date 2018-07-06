package com.zhy.tree_view;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.example.student.student_MainActivity;
import com.example.student.youke_MainActivity;
import com.example.student.youkekecheng_MainActivity;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

public class ceshi extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		        .detectDiskReads()
		        .detectDiskWrites()
		        .detectNetwork()   // or .detectAll() for all detectable problems
		        .penaltyLog()
		        .build());
		   	 StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		        .detectLeakedSqlLiteObjects()
		        .detectLeakedClosableObjects()
		        .penaltyLog()
		      /*  .penaltyDeath()*/
		        .build());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ceshi);
		Button teacher = (Button) findViewById(R.id.button1);
		Button jiaowu = (Button) findViewById(R.id.button2);
		Button student = (Button) findViewById(R.id.button3);
		
		student.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ceshi.this,youke_MainActivity.class);
				startActivity(intent);
			}
		});
		teacher.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ceshi.this, teacherpart.teacherpage.class);
				startActivity(intent);
			}
		});
		jiaowu.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ceshi.this, teachingpart.teachingpage.class);
				startActivity(intent);
			}
		});
		
	}

}
