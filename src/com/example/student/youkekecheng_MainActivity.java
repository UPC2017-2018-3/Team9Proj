package com.example.student;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Bycoursedetailpicture;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;

public class youkekecheng_MainActivity extends FragmentActivity{
	//Ƭ��ѡ�����
			private FragmentTabHost mTabHost;
			
			//��ѡ��ť��
			private RadioGroup mTabRg;
			String coursename = ApkEntity.getcoursename();
			String teacher_account = ApkEntity.getteacher_account();
			//�ײ�ѡ����Ƭ����
			private final Class[] fragments = { youke_Fragment1.class, youke_Fragment2.class,youke_Fragment3.class};

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				
				super.onCreate(savedInstanceState);				
				
				//ȡ��������
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);
				
				setContentView(R.layout.youkekecheng);
				Toast.makeText(getApplicationContext(), coursename, Toast.LENGTH_LONG).show();
				String strParams = "organization:" + "哈佛大学" + "|course:" + coursename+ "|account:" + teacher_account;
				String retString=Bycoursedetailpicture.LogSelect(strParams);
				String strURL = retString;

				ImageView imageView1_youkekecheng=(ImageView) findViewById(R.id.imageView1_youkekecheng);	  		
		  		
			  		try {
						Bitmap bitmap = getBitmap(strURL);
						imageView1_youkekecheng.setImageBitmap(bitmap);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	  		
			  	
				
				//��ʼ��
				initView();
				
				Button youkekecheng_backw=(Button) findViewById(R.id.youkekecheng_backw);
				youkekecheng_backw.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						Intent intent = new Intent();  
		                intent.setClass(youkekecheng_MainActivity.this,youke_MainActivity.class);
		                startActivity(intent);
					}
				});
				
				ImageView youkekecheng_img2=(ImageView) findViewById(R.id.youkekecheng_img2);
				youkekecheng_img2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						Intent intent = new Intent();  
		                intent.setClass(youkekecheng_MainActivity.this, yuanxiaoActivity.class);
		                startActivity(intent);
					}
				});
			}
			
			private Bitmap getBitmap(String strURL) throws IOException {
				
				try {
					URL url = new URL(strURL);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					if (conn.getResponseCode() == 200) {
						InputStream inputStream = conn.getInputStream();
						Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
						return bitmap;
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				return null;
			}
			
			/**
			 * ��ʼ��
			 */
			private void initView() {
				
				//��Ƭ����
				mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
				
				//������Ƭ��ʾ����
				mTabHost.setup(this, this.getSupportFragmentManager(), R.id.realtabcontent_youkekecheng);
				
				int count = fragments.length;
				
				for (int i = 0; i < count; i++) {
					
					TabSpec tabSpec = mTabHost.newTabSpec(i + "").setIndicator(i + "");
					
					//�����������Ƭ��������
					mTabHost.addTab(tabSpec, fragments[i], null);
					
				}
				
				//��ӵײ������˵���ť�ĵ���¼�
				mTabRg = (RadioGroup) findViewById(R.id.tab_rg_menu_youkekecheng);
				//�л�ͨ����Ƭ�����л���Ƭ
				mTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						
						switch (checkedId) {
						
						case R.id.tab_rb_1_youkekecheng:
							
							mTabHost.setCurrentTab(0);
							
							break;
							
						case R.id.tab_rb_2_youkekecheng:
							
							mTabHost.setCurrentTab(1);

							break;
							
						case R.id.tab_rb_3_youkekecheng:

							mTabHost.setCurrentTab(2);
							
							break;

						}
					}
				});

				//����Ĭ�ϵĵ����˵�ѡ�е���Ƭ
				mTabHost.setCurrentTab(0);
				
			}


}
