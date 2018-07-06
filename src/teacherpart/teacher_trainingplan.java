package teacherpart;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import webservice.Bychangecourseicon;
import webservice.Byshixunjihua;

public class teacher_trainingplan extends Activity{
	
	private EditText teacher_trainingplanet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_trainingplan);
		teacher_trainingplanet = (EditText)findViewById(R.id.teacher_trainingplanet);
		Button fanhuibt = (Button) findViewById(R.id.teacher_trainingplanrb);
		Button teacher_trainingplanb1 = (Button) findViewById(R.id.teacher_trainingplanb1);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_trainingplan.this, teacher_course.class);
				startActivity(intent);
			}
		});
		
		
		
		teacher_trainingplanb1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String plan=teacher_trainingplanet.getText().toString();
				String account = ApkEntity.getaccount();
				String coursename = ApkEntity.getcoursename();
				String strParams = "account:" + account+"|coursename:" + coursename+"|content:" + plan;
				String retString=Byshixunjihua.LogSelect(strParams);
				if (retString.equals("1")) {
		    		
					
					Toast.makeText(getApplicationContext(), "实训计划发布成功", Toast.LENGTH_LONG).show();
					
				}
		    	else {
		    		Toast.makeText(getApplicationContext(), "实训计划发布失败了", Toast.LENGTH_SHORT).show();
		    	}
				
			}
		});
		
	}

}
