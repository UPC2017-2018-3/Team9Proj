package com.example.student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.example.student.MyAdapter.ChangeTextView;
import com.imooc.systemwork.ApkEntity;
import com.example.bean.Payment;

import com.zhy.tree_view.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import teacherpart.SearchDemo;
import teacherpart.SlidingMenu;
import webservice.Byfourcourse;
import webservice.Byreturnmycourse;

public class youke_MainActivity extends Activity{
	private ViewPager mViewPaper;
	private List<ImageView> images;
	private List<View> dots;
	private int currentItem;
	private SlidingMenu mMenu;
	private EditText mEditText;    
	private ImageView mImageView2;   
	private ImageView mImageView3; 
	private ListView mListView;    
	Context context;    
    Cursor cursor; 
    private ListView lv_doubleList;
	private MyAdapter myAdapter;
	private List<Payment> dataList;
	private String coursename[] = {"高数", "网站开发设计", "数据库原理", "数据结构"};

	//��¼��һ�ε��λ��
	private int oldPosition = 0;
	//���ͼƬ��id  
	private int[] imageIds = new int[]{
			R.drawable.zhuye1,
			R.drawable.zhuye2,
			R.drawable.zhuye3
	};
	private ViewPagerAdapter adapter;
	private ScheduledExecutorService scheduledExecutorService;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		        .detectDiskReads()
		        .detectDiskWrites()
		        .detectNetwork()   // or .detectAll() for all detectable problems
		        .penaltyLog()
		        .build());
		   	 StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		        .detectLeakedSqlLiteObjects()
		        .detectLeakedClosableObjects()
		        .penaltyLog()
		      /*  .penaltyDeath()*/
		        .build());
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.youke_main);
		
		//禁止自动弹出软键盘
				getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		//ģ����ѯ
		context = this;
		initView();
		
		mViewPaper = (ViewPager) findViewById(R.id.youke_vp);
		mMenu = (SlidingMenu) findViewById(R.id.id_menu);
		//�����
		
		
		/*ImageView youke_img2=(ImageView) findViewById(R.id.youke_img2);
		youke_img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(youke_MainActivity.this, youkekecheng_MainActivity.class);
                startActivity(intent);
			}
		});*/
		
		TextView login_youkezhuye=(TextView) findViewById(R.id.login_youkezhuye);
		login_youkezhuye.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(youke_MainActivity.this, yuanxiaoActivity.class);
                startActivity(intent);
			}
		});
		ImageView youke_menu_img2=(ImageView) findViewById(R.id.youke_menu_img2);
		youke_menu_img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(youke_MainActivity.this, yuanxiaoActivity.class);
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
		dots.add(findViewById(R.id.youke_dot_0));
		dots.add(findViewById(R.id.youke_dot_1));
		dots.add(findViewById(R.id.youke_dot_2));
//		dots.add(findViewById(R.id.dot_3));
		
		adapter = new ViewPagerAdapter();
		mViewPaper.setAdapter(adapter);
		
		mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			

			@Override
			public void onPageSelected(int position) {
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
		
		lv_doubleList = (ListView) findViewById(R.id.lv_doubleList);
		initData();
		myAdapter = new MyAdapter(dataList, getApplicationContext(), new ChangeTextView() {
			
			@Override
			public void changeTheText(int position) {
				String showText = dataList.get(position).getCharge();
				Toast.makeText(getApplicationContext(), showText, 1).show();
				for (Payment payment : dataList) {
					payment.setStatus(false);
				}
				dataList.get(position).setStatus(true);
				myAdapter.notifyDataSetChanged();
			}
		});
		lv_doubleList.setAdapter(myAdapter);
		
	}
	
	

	private void initData() {
		dataList = new ArrayList<Payment>();
		for (int i = 0; i < 4; i++) {
			Payment payment = new Payment();
			payment.setDescription(coursename[i]);
			/*payment.setCharge(lgroup.get(i).coursepicture);*/
			dataList.add(payment);
		}
	}

	public void EditTextClick(View v) {
		Intent intent = new Intent();  
        intent.setClass(youke_MainActivity.this, SearchDemo.class);
        startActivity(intent);
		}
	private void initView() {
		// TODO Auto-generated method stub   
	     mEditText = (EditText) findViewById(R.id.youke_edittext);    
	     mImageView2 = (ImageView) findViewById(R.id.youke_imageview2);
	     mImageView3 = (ImageView) findViewById(R.id.youke_imageview3);
	     mListView = (ListView) findViewById(R.id.youke_listview);
	     
	   //����ɾ��ͼƬ�ĵ���¼�    
	     mImageView2.setOnClickListener(new View.OnClickListener() {    
	            @Override    
	            public void onClick(View v) {    
	                //��EditText��������Ϊ��    
	                mEditText.setText("");    
	                //��ListView����    
	                mListView.setVisibility(View.GONE);    
	            }    
	      });  
	       
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
	
	public void toggleMenu(View view)
	{
		mMenu.toggle();
	}


}
