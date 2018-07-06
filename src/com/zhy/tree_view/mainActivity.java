package com.zhy.tree_view;



import com.imooc.systemwork.department_management;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class mainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button buttondepartment = (Button) findViewById(R.id.system_b1);
		Button buttonclass = (Button) findViewById(R.id.system_b2);
		Button buttonteacher = (Button) findViewById(R.id.system_b3);
		Button buttonstudent = (Button) findViewById(R.id.system_b4);
		Button buttoncourse = (Button) findViewById(R.id.system_b5);
		
		buttondepartment.setOnClickListener(new Button.OnClickListener() {			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setClass(mainActivity.this, com.imooc.systemwork.department_management.class);
					startActivity(intent);
				}
			});
		buttonclass.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(mainActivity.this, com.imooc.systemwork.class_management.class);
				startActivity(intent);
			}
		});
		buttonteacher.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(mainActivity.this, com.imooc.systemwork.teacher_management.class);
				startActivity(intent);
			}
		});
		buttonstudent.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(mainActivity.this, com.imooc.systemwork.student_management.class);
				startActivity(intent);
			}
		});
		buttoncourse.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(mainActivity.this, com.imooc.systemwork.course_management.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
