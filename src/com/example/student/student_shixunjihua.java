package com.example.student;

import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class student_shixunjihua extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_shixunjihua);
		TextView tv = (TextView) findViewById(R.id.shixunjihua);
		Button shixunjihuarb = (Button)findViewById(R.id.shixunjihuarb);
		shixunjihuarb.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent0 = new Intent(student_shixunjihua.this, kecheng_MainActivity.class);
				startActivity(intent0);
			}
		});
		
	}
	
	

}
