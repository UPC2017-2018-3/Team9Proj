package com.example.student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.bean.Payment;
import com.example.student.MyAdapter1.ChangeTextView;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import teacherpart.SearchDemo;
import teacherpart.SlidingMenu;
import webservice.Bychangeteachericon;
import webservice.Byfourcourse;
import webservice.Bystudentnicheng;

public class student_MainActivity extends Activity{
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
   	private MyAdapter1 myAdapter;
   	private List<Payment> dataList;
   	String account = ApkEntity.getaccount();
   	String organization = ApkEntity.getorganization();
   	
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
		
				
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.student_activity_main);
		//禁止自动弹出软键盘
		getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		//ģ����ѯ
		context = this;
		initView();  
		
		mViewPaper = (ViewPager) findViewById(R.id.student_vp);
		mMenu = (SlidingMenu) findViewById(R.id.student_id_menu);
		//�����
		Button student_imageview= (Button) findViewById(R.id.student_imageview);
		student_imageview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mMenu.toggle();
			}
		});
		
		String strParams = "account:" + account; 
		String retString=Bystudentnicheng.studentRegisterSelect(strParams);
		((ApkEntity) getApplication()).setaccount_name(retString);
		
		
		TextView student_chakan=(TextView) findViewById(R.id.student_chakan);
		student_chakan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, allkechengActivity.class);
                startActivity(intent);
			}
		});
		TextView stu_textView1=(TextView) findViewById(R.id.stu_textView1);
		TextView stu_textView2=(TextView) findViewById(R.id.stu_textView2);
		stu_textView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, gerenxinxi_Activity.class);
                startActivity(intent);
			}
		});
        stu_textView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, xiaoxi_lvActivity.class);
                startActivity(intent);
			}
		});
        TextView stu_t1=(TextView) findViewById(R.id.stu_t1);
        stu_t1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, wodekecheng_lvActivity.class);
                startActivity(intent);
			}
		});
        TextView stu_t2=(TextView) findViewById(R.id.stu_t2);
        stu_t2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, zongheshixun_lvActivity.class);
                startActivity(intent);
			}
		});
        TextView stu_t3=(TextView) findViewById(R.id.stu_t3);
        stu_t3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, renwu_lvActivity.class);
                startActivity(intent);
			}
		});
        TextView stu_t4=(TextView) findViewById(R.id.stu_t4);
        stu_t4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, chengji_lvActivity.class);
                startActivity(intent);
			}
		});
        
        TextView stu_t5=(TextView) findViewById(R.id.stu_t5);
        stu_t5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, nengli_lvActivity.class);
                startActivity(intent);
			}
		});
        TextView stu_t6=(TextView) findViewById(R.id.stu_t6);
        stu_t6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, zixun_student_lvActivity.class);
                startActivity(intent);
			}
		});
        TextView stu_t7=(TextView) findViewById(R.id.stu_t7);
        stu_t7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(student_MainActivity.this, zhibolist.class);
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
		dots.add(findViewById(R.id.student_dot_0));
		dots.add(findViewById(R.id.student_dot_1));
		dots.add(findViewById(R.id.student_dot_2));
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
		
		lv_doubleList = (ListView) findViewById(R.id.lv_doubleList1);
		initData();
		myAdapter = new MyAdapter1(dataList, getApplicationContext(), new ChangeTextView() {
			
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
		String strParams = "organization:" + organization;	
		List<Byfourcourse> lgroup=Byfourcourse.listGroup(strParams);
		dataList = new ArrayList<Payment>();
		for (int i = 0; i < 4; i++) {
			Payment payment = new Payment();
			payment.setDescription(lgroup.get(i).coursename);
			payment.setCharge(lgroup.get(i).coursepicture);
			dataList.add(payment);
		}
	}
	

	
	private void initView() {
		// TODO Auto-generated method stub   
	     mEditText = (EditText) findViewById(R.id.student_edittext);    
	     mImageView2 = (ImageView) findViewById(R.id.student_imageview2);
	     mImageView3 = (ImageView) findViewById(R.id.student_imageview3);
	     mListView = (ListView) findViewById(R.id.student_listview);
	     
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
	     
	     
	     
//	   //EditText��Ӽ���    
//	   mEditText.addTextChangedListener(new TextWatcher() {    
//	                
//	            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}//�ı��ı�֮ǰִ��    
//	    
//	            @Override    
//	            //�ı��ı��ʱ��ִ��    
//	            public void onTextChanged(CharSequence s, int start, int before, int count) {    
//	                //�������Ϊ0    
//	                if (s.length() == 0) {    
//	                    //���ء�ɾ����ͼƬ    
//	                    mImageView2.setVisibility(View.GONE);    
//	                } else {//���Ȳ�Ϊ0    
//	                    //��ʾ��ɾ��ͼƬ��    
//	                    mImageView2.setVisibility(View.VISIBLE);    
//	                    //��ʾListView    
//	                    showListView();    
//	                }    
//	            }
//
//				@Override
//				public void afterTextChanged(Editable arg0) {
//					// TODO Auto-generated method stub
//					//�ı��ı��ִ��
//				}
//	        }); 
//	   
//	   //��������¼�
//	   mImageView3.setOnClickListener(new View.OnClickListener() {    
//           
//           public void onClick(View v) {    
//               //������������Ϊ�գ���ʾ��������������    
//               if(TextUtils.isEmpty(mEditText.getText().toString().trim())){    
//                   ToastUtils.showToast(context,"��������Ҫ����������");    
//               }else {    
//                   //�ж�cursor�Ƿ�Ϊ��    
//                   if (cursor != null) {    
//                       int columnCount = cursor.getCount();    
//                       if (columnCount == 0) {    
//                           ToastUtils.showToast(context, "�Բ���û����Ҫ����������");    
//                       }    
//                   }    
//               }    
//   
//           }    
//       });    
	}
	
	public void EditTextClick1(View v) {
		Intent intent = new Intent();  
        intent.setClass(student_MainActivity.this, SearchDemo.class);
        startActivity(intent);
        
		}
	
	
//	 private void showListView() {    
//	        mListView.setVisibility(View.VISIBLE);    
//	        //������������    
//	        String str = mEditText.getText().toString().trim();    
//	        //��ȡ���ݿ����    
////	        MyOpenHelper myOpenHelper = new MyOpenHelper(getApplicationContext());    
////	        SQLiteDatabase db = myOpenHelper.getReadableDatabase();    
	        //�õ�cursor    
//	        cursor = db.rawQuery("select * from course where name like '%" + str + "%'", null);    
//	        MyListViewCursorAdapter adapter = new MyListViewCursorAdapter(context, cursor);    
//	    
//	        mListView.setAdapter(adapter);    
//	    
//	        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {    
//	            @Override    
//	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {    
//	                //��cursor�ƶ���ָ����    
//	                cursor.moveToPosition(position);    
//	                String name = cursor.getString(cursor.getColumnIndex("name"));    
//	                ToastUtils.showToast(context, name);    
//	            }    
//	        });    
//	    }    

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
