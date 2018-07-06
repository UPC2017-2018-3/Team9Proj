package teacherpart;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;
import webservice.Bycreateexercises;
import webservice.Bycreatetraning;

public class addcomprehensive_training extends Activity{
	
	int flag1 = 0;
	int flag2 = 0;
	int flag3 = 0;
	int flag4 = 0;
	private EditText et,et1,et2,et3,et4;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addcomprehensive_training);
		Button rt = (Button) findViewById(R.id.addcomprehensive_trainingrb);
		Button tj = (Button) findViewById(R.id.addcomprehensive_trainingbt);
		et =(EditText) findViewById(R.id.addcomprehensive_trainingt1);
		et1 =(EditText) findViewById(R.id.addcomprehensive_traininget1);
		et2 =(EditText) findViewById(R.id.addcomprehensive_traininget2);
		et3 =(EditText) findViewById(R.id.addcomprehensive_traininget3);
		et4 =(EditText) findViewById(R.id.addcomprehensive_traininget4);
		final CheckedTextView checkedTextView1 = (CheckedTextView) findViewById(R.id.addcomprehensive_trainingct1);
		final CheckedTextView checkedTextView2 = (CheckedTextView) findViewById(R.id.addcomprehensive_trainingct2);
		final CheckedTextView checkedTextView3 = (CheckedTextView) findViewById(R.id.addcomprehensive_trainingct3);
		final CheckedTextView checkedTextView4 = (CheckedTextView) findViewById(R.id.addcomprehensive_trainingct4);
		
		((ApkEntity) getApplication()).setaa(flag1);
		((ApkEntity) getApplication()).setaa(flag2);
		((ApkEntity) getApplication()).setaa(flag3);
		((ApkEntity) getApplication()).setaa(flag4);
		
		String desctiption=et.getText().toString();
		String A=et1.getText().toString();
		String B=et2.getText().toString();
		String C=et3.getText().toString();
		String D=et4.getText().toString();
		
		checkedTextView1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(flag1){
				case 0:
					checkedTextView1.setBackgroundResource(R.drawable.option_btn_single_checked);
					flag1 = 1;
					break;
				case 1:
					checkedTextView1.setBackgroundResource(R.drawable.option_btn_single_normal);
					flag1 = 0;
					break;
					}
			}
		});
		checkedTextView2.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(flag2){
				case 0:
					checkedTextView2.setBackgroundResource(R.drawable.option_btn_single_checked);
					flag2 = 1;
					break;
				case 1:
					checkedTextView2.setBackgroundResource(R.drawable.option_btn_single_normal);
					flag2 = 0;
					break;
					}
			}
		});
		checkedTextView3.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(flag3){
				case 0:
					checkedTextView3.setBackgroundResource(R.drawable.option_btn_single_checked);
					flag3 = 1;
					break;
				case 1:
					checkedTextView3.setBackgroundResource(R.drawable.option_btn_single_normal);
					flag3 = 0;
					break;
					}
			}
		});
		checkedTextView4.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(flag4){
				case 0:
					checkedTextView4.setBackgroundResource(R.drawable.option_btn_single_checked);
					flag4 = 1;
					break;
				case 1:
					checkedTextView4.setBackgroundResource(R.drawable.option_btn_single_normal);
					flag4 = 0;
					break;
					}
			}
		});
		
		rt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(addcomprehensive_training.this, teacherpart.comprehensive_training.class);
				startActivity(intent);
			}
		});
		tj.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String coursename = ApkEntity.getcoursename();
				String account = ApkEntity.getaccount();
				flag1 = ApkEntity.getaa();
				flag2 = ApkEntity.getab();
				flag3 = ApkEntity.getac();
				flag4 = ApkEntity.getad();
				String desctiption=et.getText().toString();
				String A=et1.getText().toString();
			    String B=et2.getText().toString();
				String C=et3.getText().toString();
				String D=et4.getText().toString();
				String strParams = "account:" + account+"|name:" + coursename+"|question:" + desctiption
						+"|a:" + A+"|b:" + B+"|c:" + C+"|d:" + D
						+"|aa:" + flag1+"|ab:" + flag2+"|ac:" + flag3+"|ad:" + flag4;
				String retString=Bycreatetraning.LogSelect(strParams);
                if (retString.equals("1")) {
		    		
					
					Toast.makeText(getApplicationContext(), "添加试题成功", Toast.LENGTH_LONG).show();
					
				}
		    	else {
		    		Toast.makeText(getApplicationContext(), "添加试题失败了", Toast.LENGTH_SHORT).show();
		    	}
			}
		});
	}
	
	

}

