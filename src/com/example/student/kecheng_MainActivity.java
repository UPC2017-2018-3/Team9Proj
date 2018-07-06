package com.example.student;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Bychangeicon1;
import webservice.Bycoursedetailpicture;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;

public class kecheng_MainActivity extends FragmentActivity{
	//Ƭ��ѡ�����
		private FragmentTabHost mTabHost;
		
		//��ѡ��ť��
		private RadioGroup mTabRg;

	
		
		//�ײ�ѡ����Ƭ����
		private final Class[] fragments = { kechengjianjie_Fragment1.class, kechengzhishidian_Fragment2.class,kechengping_Fragment3.class};

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			
			super.onCreate(savedInstanceState);
			
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			
			setContentView(R.layout.kechengxiangqing);
			String organization = ApkEntity.getorganization();
			String coursename = ApkEntity.getcoursename();
			String teacher_account = ApkEntity.getteacher_account();
			String strParams = "organization:" + organization + "|course:" + coursename+ "|account:" + teacher_account;
			String retString=Bycoursedetailpicture.LogSelect(strParams);
			String strURL = retString;

		        ImageView kechengxiangqing_img1=(ImageView) findViewById(R.id.kechengxiangqing_img1);	  		
	  		
		  		try {
					Bitmap bitmap = getBitmap(strURL);
					kechengxiangqing_img1.setImageBitmap(bitmap);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			Button kechengxiangqing_backw = (Button)findViewById(R.id.kechengxiangqing_backw);
			 kechengxiangqing_backw.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();  
		                intent.setClass(kecheng_MainActivity.this, student_MainActivity.class);
		                startActivity(intent);
					}
				});     
			
			//��ʼ��
			initView();
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
				// TODO Auto-generated catch block
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
			mTabHost.setup(this, this.getSupportFragmentManager(), R.id.realtabcontent);
			
			int count = fragments.length;
			
			for (int i = 0; i < count; i++) {
				
				TabSpec tabSpec = mTabHost.newTabSpec(i + "").setIndicator(i + "");
				
				//�����������Ƭ��������
				mTabHost.addTab(tabSpec, fragments[i], null);
				
			}
			
			//��ӵײ������˵���ť�ĵ���¼�
			mTabRg = (RadioGroup) findViewById(R.id.tab_rg_menu);
			//�л�ͨ����Ƭ�����л���Ƭ
			mTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					
					switch (checkedId) {
					
					case R.id.tab_rb_1:
						
						mTabHost.setCurrentTab(0);
						
						break;
						
					case R.id.tab_rb_2:
						
						mTabHost.setCurrentTab(1);

						break;
						
					case R.id.tab_rb_3:

						mTabHost.setCurrentTab(2);
						
						break;

					}
				}
			});

			//����Ĭ�ϵĵ����˵�ѡ�е���Ƭ
			mTabHost.setCurrentTab(0);
			
		}
		
		public interface MyTouchListener {  
		    public void onTouchEvent(MotionEvent event);  
		}
		private ArrayList<MyTouchListener> myTouchListeners = new ArrayList<kecheng_MainActivity.MyTouchListener>(); 
		public void registerMyTouchListener(MyTouchListener listener) {  
		     myTouchListeners.add(listener);  
		}
		public void unRegisterMyTouchListener(MyTouchListener listener) {  
		    myTouchListeners.remove( listener );  
		} 
		public boolean dispatchTouchEvent(MotionEvent ev) {   
		    for (MyTouchListener listener : myTouchListeners) {  
		    listener.onTouchEvent(ev);  
		    }  
		    return super.dispatchTouchEvent(ev);  
		} 

}
