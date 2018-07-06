package com.example.student;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Bygonggaofirst;
import webservice.Bygonggaofourth;
import webservice.Bygonggaosecond;
import webservice.Bygonggaothird;
import webservice.Byonezixun1;
import webservice.Bystudentschool;
import webservice.Byxueyoufirst;
import webservice.Byxueyoufourth;
import webservice.Byxueyousecond;
import webservice.Byxueyouthird;
import webservice.Byzixuncontent;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class yuanxiaozhuye_Activity extends Activity{
	private ViewPager mViewPaper;
	private List<ImageView> images;
	private List<View> dots;
	private int currentItem;
	//��¼��һ�ε��λ��
	private int oldPosition = 0;
	//���ͼƬ��id  
	private int[] imageIds = new int[]{
			R.drawable.a,
			R.drawable.b,
			R.drawable.c
	};
	//���ͼƬ�ı���
	private String[]  titles = new String[]{
        	"雪景",	
        	"雪",	
        	"夜"
        };
	private TextView title,text_yuanxiaozhuye,tv1_youketongzhi,tv2_youketongzhi,tv3_youketongzhi,tv4_youketongzhi;
	private TextView tv1_youkexueyou,tv2_youkexueyou,tv3_youkexueyou,tv4_youkexueyou;
	private ViewPagerAdapter adapter;
	private ScheduledExecutorService scheduledExecutorService;
	String organization = ApkEntity.getorganization();
	String strParams2 = "organization:" + organization;
	String strURL;
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yuanxiaozhuye);
		mViewPaper = (ViewPager) findViewById(R.id.vp);
		
		text_yuanxiaozhuye=(TextView) findViewById(R.id.text_yuanxiaozhuye);
		text_yuanxiaozhuye.setText(organization);
		
		tv1_youketongzhi=(TextView) findViewById(R.id.tv1_youketongzhi);
		String retString2=Bygonggaofirst.gonggaofirstSelect(strParams2);
		tv1_youketongzhi.setText(retString2);
		
		tv2_youketongzhi=(TextView) findViewById(R.id.tv2_youketongzhi);
		String retString3=Bygonggaosecond.gonggaosecondSelect(strParams2);
		tv2_youketongzhi.setText(retString3);
		
		tv3_youketongzhi=(TextView) findViewById(R.id.tv3_youketongzhi);
		String retString4=Bygonggaothird.gonggaothirdSelect(strParams2);
		tv3_youketongzhi.setText(retString4);
		
		tv4_youketongzhi=(TextView) findViewById(R.id.tv4_youketongzhi);
		String retString5=Bygonggaofourth.gonggaofourthSelect(strParams2);
		tv4_youketongzhi.setText(retString5);
		
		tv1_youkexueyou=(TextView) findViewById(R.id.tv1_youkexueyou);
		String retString11=Byxueyoufirst.xueyoufirstSelect(strParams2);
		tv1_youkexueyou.setText(retString11);
		
		tv2_youkexueyou=(TextView) findViewById(R.id.tv2_youkexueyou);
		String retString12=Byxueyousecond.xueyousecondSelect(strParams2);
		tv2_youkexueyou.setText(retString12);
		
		tv3_youkexueyou=(TextView) findViewById(R.id.tv3_youkexueyou);
		String retString13=Byxueyouthird.xueyouthirdSelect(strParams2);
		tv3_youkexueyou.setText(retString13);
		
		tv4_youkexueyou=(TextView) findViewById(R.id.tv4_youkexueyou);
		String retString14=Byxueyoufourth.xueyoufourthSelect(strParams2);
		tv4_youkexueyou.setText(retString14);
		
		List<Byonezixun1> lgroup=Byonezixun1.listGroup(strParams2);
    	for (int i = 0; i < lgroup.size(); i++) {
			
			TextView onezixun_title=(TextView) findViewById(R.id.onezixun_title);
	        ImageView onezixun_img2=(ImageView) findViewById(R.id.onezixun_img2);
	        
	        onezixun_title.setText(lgroup.get(i).zixuntitle);	  		
	  		strURL=lgroup.get(i).zixunpicture;
	  		
	  		try {
				Bitmap bitmap = getBitmap(strURL);
				onezixun_img2.setImageBitmap(bitmap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		
		}
		
//    	List<Bytop4gonggao> lgroup=Bytop4gonggao.listGroup(strParams);
//    	for (int i = 0; i < lgroup.size(); i++) {
//			
//			TextView tv1_youketongzhi=(TextView) findViewById(R.id.tv1_youketongzhi);
//			TextView tv2_youketongzhi=(TextView) findViewById(R.id.tv2_youketongzhi);
//			TextView tv3_youketongzhi=(TextView) findViewById(R.id.tv3_youketongzhi);
//			TextView tv4_youketongzhi=(TextView) findViewById(R.id.tv4_youketongzhi);
//			tv1_youketongzhi.setText(lgroup.get(i).gonggaotitle);
//			tv2_youketongzhi.setText(lgroup.get(i).gonggaotitle);
//			tv3_youketongzhi.setText(lgroup.get(i).gonggaotitle);
//			tv4_youketongzhi.setText(lgroup.get(i).gonggaotitle);
//	  		
//		}
//		
		Button tongzhi_btn = (Button)findViewById(R.id.tongzhi_btn);
		tongzhi_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaozhuye_Activity.this, tongzhi_lvActivity.class);
                startActivity(intent);
			}
		});
		
		Button xueyouquan_btn = (Button)findViewById(R.id.xueyouquan_btn);
		xueyouquan_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaozhuye_Activity.this, xueyouquan_lvActivity.class);
                startActivity(intent);
			}
		});
		
		Button xiaoneizixun_btn = (Button)findViewById(R.id.xiaoneizixun_btn);
		xiaoneizixun_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaozhuye_Activity.this, zixun_lvActivity.class);
                startActivity(intent);
			}
		});
		
		TextView login_youkexueyou = (TextView) findViewById(R.id.login_youkexueyou);
		login_youkexueyou.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaozhuye_Activity.this, loginActivity.class);
                startActivity(intent);
			}
		});
		
		Button yuanxiaozhuye_backw = (Button)findViewById(R.id.yuanxiaozhuye_backw);
		yuanxiaozhuye_backw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(yuanxiaozhuye_Activity.this, yuanxiaoActivity.class);
                startActivity(intent);
			}
		});
		
		
		
		
		//��ʾ��ͼƬ 
		images = new ArrayList<ImageView>();
		for(int i = 0; i < imageIds.length; i++){
			ImageView imageView = new ImageView(this);
			imageView.setBackgroundResource(imageIds[i]);
			images.add(imageView);
		}
		//��ʾ��С�� 
		dots = new ArrayList<View>();
		dots.add(findViewById(R.id.dot_0));
		dots.add(findViewById(R.id.dot_1));
		dots.add(findViewById(R.id.dot_2));
//		dots.add(findViewById(R.id.dot_3));
		
		title = (TextView) findViewById(R.id.title);
		title.setText(titles[0]);
		
		adapter = new ViewPagerAdapter();
		mViewPaper.setAdapter(adapter);
		
		mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			

			@Override
			public void onPageSelected(int position) {
				title.setText(titles[position]);
				dots.get(position).setBackgroundResource(R.drawable.dot_focused);
				dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				
				oldPosition = position;
				currentItem = position;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �Զ���Adapter ���
	 *
	 */
	private class ViewPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			// TODO Auto-generated method stub
//			super.destroyItem(container, position, object);
//			view.removeView(view.getChildAt(position));
//			view.removeViewAt(position);
			view.removeView(images.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			// TODO Auto-generated method stub
			view.addView(images.get(position));
			return images.get(position);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * �����̳߳ض�ʱִ�ж����ֲ�
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(
				new ViewPageTask(), 
				2, 
				2, 
				TimeUnit.SECONDS);
	}
	
	/** 
	 * ͼƬ�ֲ����� 
	 * 
	 */  
	private class ViewPageTask implements Runnable{

		@Override
		public void run() {
			currentItem = (currentItem + 1) % imageIds.length;
			mHandler.sendEmptyMessage(0);
		}
	}
	
	/**
	 * �������̴߳��ݹ��������� 
	 */
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			mViewPaper.setCurrentItem(currentItem);
		};
	};
	
	/** 
	 * ֹͣ�̳߳ص�ִ�У��ͷ��̳߳���Դ
	 * 
	 */ 
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
		
}
