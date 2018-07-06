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
import webservice.Byshixunjihua;
import webservice.Byshixunzongjie;

public class teacher_trainingsummary extends Activity{
	
	private EditText teacher_trainingsummaryet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_trainingsummary);
		teacher_trainingsummaryet = (EditText)findViewById(R.id.teacher_trainingsummaryet);
		Button teacher_trainingsummaryb1 = (Button) findViewById(R.id.teacher_trainingsummaryb1);
		Button fanhuibt = (Button) findViewById(R.id.teacher_trainingsummaryrb);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_trainingsummary.this, teacher_course.class);
				startActivity(intent);
			}
		});
		
		teacher_trainingsummaryb1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String summar=teacher_trainingsummaryet.getText().toString();
				String coursename = ApkEntity.getcoursename();
				String strParams = "account:" + "12345678909"+"|coursename:" + coursename+"|content:" + summar;
				String retString=Byshixunzongjie.LogSelect(strParams);
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
