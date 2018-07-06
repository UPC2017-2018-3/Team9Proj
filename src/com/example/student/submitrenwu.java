package com.example.student;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class submitrenwu extends Activity{
	
	private EditText submitrenwuet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submitrenwu);
		submitrenwuet = (EditText)findViewById(R.id.submitrenwuet);
		Button fanhuibt = (Button) findViewById(R.id.submitrenwurb);
		Button teacher_trainingplanb1 = (Button) findViewById(R.id.teacher_trainingplanb1);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(submitrenwu.this, renwuxiangqingActivity.class);
				startActivity(intent);
			}
		});
		
		
		
		teacher_trainingplanb1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String plan=submitrenwuet.getText().toString();
				/*String account = ApkEntity.getaccount();
				String coursename = ApkEntity.getcoursename();
				String strParams = "account:" + account+"|coursename:" + coursename+"|content:" + plan;*/
				/*String retString=Byshixunjihua.LogSelect(strParams);*/
				if (/*retString.equals("1")*/1==1) {
		    		
					
					Toast.makeText(getApplicationContext(), "实训计划发布成功", Toast.LENGTH_LONG).show();
					
				}
		    	else {
		    		Toast.makeText(getApplicationContext(), "实训计划发布失败了", Toast.LENGTH_SHORT).show();
		    	}
				
			}
		});
		
	}

}
