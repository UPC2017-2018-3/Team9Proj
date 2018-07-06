package teachingpart;

import java.util.ArrayList;

import com.example.zhuwangtu.RadarChartView;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import teacherpart.teacher_file;
import webservice.Bydaaplyability;
import webservice.Bydaselfcontrolability;
import webservice.Bydasocialcontactability;
import webservice.Bydastudyability;
import webservice.Bydastudytime;

public class teaching_student_zhuwang extends Activity {
	
	String ret1;
	String ret2;
	String ret3;
	String ret4;
	String ret5;
	float weight1;
	float weight2;
	float weight3;
	float weight4;
	float weight5;
	String organization = ApkEntity.getorganization();
	String student_account = ApkEntity.getstudent_account();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teaching_student_zhuwang);
		com.example.zhuwangtu.RadarChartView teacher_zhuwangtu= (RadarChartView) findViewById(R.id.teaching_zhuwangtu);
		Button fanhuibt = (Button) findViewById(R.id.teachingzhuwangtu_setupfh);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teaching_student_zhuwang.this, teaching_dangan.class);
				startActivity(intent);
			}
		});
		 String strParams = "account:" + student_account+"|organization:" + organization;
		 String strParams2 = "account:" + student_account;
		 ret1=Bydasocialcontactability.LogSelect(strParams2);
		 ret2=Bydaselfcontrolability.LogSelect(strParams2);
		 ret3=Bydastudytime.LogSelect(strParams);		 
		 ret4=Bydaaplyability.LogSelect(strParams2);
		 ret5=Bydastudyability.LogSelect(strParams2);
		 
		 weight1=Float.parseFloat(ret1);
		 weight2=Float.parseFloat(ret2);
		 weight3=Float.parseFloat(ret3);
		 weight4=Float.parseFloat(ret4);
		 weight5=Float.parseFloat(ret5);

		 ArrayList<Float> tmp = new ArrayList<Float>();   
     	tmp.add(weight1);
     	tmp.add(weight2);
     	tmp.add(weight3);
     	tmp.add(weight4);
     	tmp.add(weight5);
       
        teacher_zhuwangtu.setzhuwangData(tmp);
	}
	

}

