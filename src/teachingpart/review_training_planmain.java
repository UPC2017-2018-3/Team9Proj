package teachingpart;

import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import webservice.Bychangeteachericon;
import webservice.Byshixunplanlist;
import webservice.Byverifyshixun;
import webservice.Byverifyshixun1;

public class review_training_planmain extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_training_planmain);
		TextView user_edit_buju2 = (TextView) findViewById(R.id.user_edit_buju2);
		Button fanhuibt = (Button) findViewById(R.id.review_training_planmainrb);
		Button daiding = (Button) findViewById(R.id.daiding);
		Button querenfabu = (Button) findViewById(R.id.querenfabu);
		
		user_edit_buju2.setText(ApkEntity.getshixuncontent());
		
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(review_training_planmain.this, review_training_plan.class);
				startActivity(intent);
			}
		});
		querenfabu.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String shixuncourse = ApkEntity.getshixuncourse();
				String shixunteacher = ApkEntity.getshixunteacher();
				String strParams = "course:" + shixuncourse+"|teacher:" + shixunteacher;
				String retString=Byverifyshixun.LogSelect(strParams);
                if (retString.equals("1")) {
	        		
					
					Toast.makeText(getApplicationContext(), "发布教师实训计划成功！", Toast.LENGTH_LONG).show();
					
				    }
	        	else if(retString.equals("0"))
	        	    {						
						Toast.makeText(getApplicationContext(), "发布教师实训计划失败！", Toast.LENGTH_SHORT).show();
						
					}
				
			}
		});
		daiding.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String shixuncourse = ApkEntity.getshixuncourse();
				String shixunteacher = ApkEntity.getshixunteacher();
				String strParams = "course:" + shixuncourse+"|teacher:" + shixunteacher;
				String retString=Byverifyshixun1.LogSelect(strParams);
                if (retString.equals("1")) {
	        		
					
					Toast.makeText(getApplicationContext(), "发布教师实训计划成功！", Toast.LENGTH_LONG).show();
					
				    }
	        	else if(retString.equals("0"))
	        	    {						
						Toast.makeText(getApplicationContext(), "发布教师实训计划失败！", Toast.LENGTH_SHORT).show();
						
					}
				
			}
		});
		
	}

}
