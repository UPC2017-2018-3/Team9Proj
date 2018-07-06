package com.example.student;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byallmark;
import webservice.Byreturnmycourse;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class wodekecheng_lvActivity extends Activity{
	ArrayList<ApkEntity> apk_list;
	String strURL;
	ImageView img_wodekecheng;
	String account = ApkEntity.getaccount();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.kecheng_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wodekecheng);
		
		setData();
		showList(apk_list);
//		parent �������������AdapterView;
//		view ��AdapterView�б��������ͼ(������adapter�ṩ��һ����ͼ);
//        position ��ͼ��adapter�е�λ��;
//        id �����Ԫ�ص���id;
		listview.setOnItemClickListener(new OnItemClickListener(){

			@Override

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				String strParams = "account:" + account;
				List<Byreturnmycourse> lgroup=Byreturnmycourse.listGroup(strParams);
				((ApkEntity) getApplication()).setcoursename(lgroup.get(position).coursename);
				((ApkEntity) getApplication()).setteacher_account(lgroup.get(position).courseteacheraccount);
				Toast.makeText(getApplicationContext(), lgroup.get(position).coursename, Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();  
                intent.setClass(wodekecheng_lvActivity.this, kecheng_MainActivity.class);    
                startActivity(intent);  
				
			}
			
		});
		
		 Button kecheng_backw = (Button)findViewById(R.id.kecheng_backw);
		 kecheng_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(wodekecheng_lvActivity.this, student_MainActivity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	wodekecheng_Adapter adapter;
	ListView listview;
	String strParams = "account:" + account;
	List<Byreturnmycourse> lgroup=Byreturnmycourse.listGroup(strParams);

	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv1_wodekecheng(lgroup.get(i).coursename);
				entity.settv2_wodekecheng(lgroup.get(i).courseteachername);
				entity.settv3_wodekecheng(lgroup.get(i).courseorganizationname);
				entity.settv5_wodekecheng(lgroup.get(i).progress);
				entity.setpictureUrls(lgroup.get(i).coursepicture);
//				strURL=lgroup.get(i).coursepicture;
//				img_wodekecheng=(ImageView)findViewById(R.id.img_wodekecheng);
//		  		try {
//					Bitmap bitmap = getBitmap(strURL);
//					img_wodekecheng.setImageBitmap(bitmap);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				apk_list.add(entity);
				
			}
		}
	
//		private Bitmap getBitmap(String strURL) throws IOException {
//			
//			try {
//				URL url = new URL(strURL);
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.setConnectTimeout(5000);
//				conn.setRequestMethod("GET");
//				if (conn.getResponseCode() == 200) {
//					InputStream inputStream = conn.getInputStream();
//					Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//					return bitmap;
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return null;
//		}


	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.kecheng_listview);
			adapter = new wodekecheng_Adapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}


}
