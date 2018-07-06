package teacherpart;

import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import webservice.Bychangeteachericon;
import webservice.Byrenwucontent;

public class teacher_student_renwu extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_student_renwu);
		Button fanhuibt = (Button) findViewById(R.id.teacher_student_renwurb);
		TextView teacher_student_renwutv = (TextView) findViewById(R.id.teacher_student_renwutv);
		
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_student_renwu.this, teacher_renwuxiangqing.class);
				startActivity(intent);
			}
		});
		String course = ApkEntity.getrenwucourse();
		String renwu = ApkEntity.getrenwutitle();
		String account = ApkEntity.getstudent_account();
		String strParams = "course:" + course
				+ "|renwu:" + renwu
				+ "|account:" + account;  
		String retString=Byrenwucontent.LogSelect(strParams);
		teacher_student_renwutv.setText(retString);
		
	}

}
