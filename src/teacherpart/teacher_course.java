package teacherpart;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import webservice.Bychangecourseicon;


public class teacher_course extends Activity{
	String coursename;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_course);
		TextView title =(TextView) findViewById(R.id.teacher_courseti1);
		ImageView head2 = (ImageView) 
				findViewById(R.id.teacher_courset);
		coursename = ApkEntity.getcoursename();
		title.setText(coursename);
		String account = ApkEntity.getaccount();
		String strParams = "name:" + coursename+"|account:" + account;
		String retString=Bychangecourseicon.LogSelect(strParams);
		String strURL = retString;
		try {
			Bitmap bitmap = getBitmap(strURL);
			head2.setImageBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Button fanhuibt = (Button) findViewById(R.id.teacher_courserb);
		Button quanzibt = (Button) findViewById(R.id.teacher_coursemanagementtj);
		Button button1 = (Button) findViewById(R.id.teacher_coursetbt1);
		Button button2 = (Button) findViewById(R.id.teacher_coursetbt2);
		Button button3 = (Button) findViewById(R.id.teacher_coursetbt3);
		Button button4 = (Button) findViewById(R.id.teacher_coursetbt4);
		Button button5 = (Button) findViewById(R.id.teacher_coursetbt5);
		Button button6 = (Button) findViewById(R.id.teacher_coursetbt6);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_coursemanagement.class);
				startActivity(intent);
			}
		});
		quanzibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_commun_area.class);
				startActivity(intent);
			}
		});
		button1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_trainingplan.class);
				startActivity(intent);
			}
		});
		button2.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_trainingsummary.class);
				startActivity(intent);
			}
		});
		button3.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_studentstudy.class);
				startActivity(intent);
			}
		});
		button4.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_coursemanagement.class);
				startActivity(intent);
			}
		});
		button5.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_combinedtraining.class);
				startActivity(intent);
			}
		});
		button6.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_course.this, teacher_knowledge.class);
				startActivity(intent);
			}
		});
	}
	
	public Bitmap getBitmap(String path) throws IOException {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				InputStream inputStream = conn.getInputStream();
				Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
				return bitmap;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
