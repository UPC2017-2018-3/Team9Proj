package com.example.dati;



import java.util.List;

import com.example.fragment.QuestionItemFragment;
import com.example.student.allkechengActivity;
import com.example.student.student_MainActivity;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import webservice.Byexanswer;
import webservice.Byshixunanswer;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @version 1.0
 * @author hzc
 * @date 2015-6-24
 */

public class ResultReportActivity extends FragmentActivity  {
	LocalBroadcastManager mLocalBroadcastManager;
	int count = MainActivity.questionlist.size();
	
	int[] mIds = new int[count];
    String p ;
    String[] a =new String[1000];
    String coursename = ApkEntity.getcoursename();
	String teacher_account = ApkEntity.getteacher_account();
    int Number ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_report);
		
		a=QuestionItemFragment.number;
		
		String zhuangtai = ApkEntity.getzhuangtai();
        if(zhuangtai.equals("练习"))
        {
        	String strParams = "account:" + teacher_account + "|course:" + coursename;
            List<Byexanswer> lgroup=Byexanswer.listGroup(strParams);
            Number = 0;
		for(int i = 0; i < lgroup.size(); i++)
		{
			
			if(a[i].equals(lgroup.get(i).answer))
			{
				Number++;
			}
			else 
			{
				p="失败";
			}
		}
        }
        else 
        {
        	String strParams = "account:" + teacher_account + "|course:" + coursename;
            List<Byshixunanswer> lgroup=Byshixunanswer.listGroup(strParams);
            Number = 0;
    		for(int i = 0; i < lgroup.size(); i++)
    		{
    			
    			if(a[i].equals(lgroup.get(i).answer))
    			{
    				Number++;
    			}
    			else 
    			{
    				p="失败";
    			}
    		}
            
        	
        }
		initData();
		 mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
		GridView gv = (GridView) findViewById(R.id.report_gv);
		TextView tv_report_total_question = (TextView) findViewById(R.id.tv_report_total_question);
		Button tv_back = (Button) findViewById(R.id.tv_back);
		tv_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(ResultReportActivity.this, student_MainActivity.class);
                startActivity(intent);
			}
		});
		TextView tv_report_exam_type = (TextView) findViewById(R.id.tv_report_exam_type);
		TextView tv_report_question_number = (TextView) findViewById(R.id.tv_report_question_number);
		RelativeLayout rl_result_panel = (RelativeLayout) findViewById(R.id.rl_result_panel);
		//设置scrollview 自动置顶
		rl_result_panel.setFocusable(true);
		rl_result_panel.setFocusableInTouchMode(true);
		rl_result_panel.requestFocus();
		
		tv_report_question_number.setText(""+Number);
		
		tv_report_total_question.setText("道/"+count+"道");
		MyAdapter adapter = new MyAdapter(this);
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO跳转到相应的viewpager 页面
				  Intent intent = new Intent("com.leyikao.jumptopage");
                 intent.putExtra("index", position);
                 mLocalBroadcastManager.sendBroadcast(intent);
			}
		});
	}
	private void initData() {
		for (int i = 0; i < count; i++) {
			mIds[i] = i + 1;
		}
	}
	
	private class MyAdapter extends BaseAdapter {
		private Context mContext;

		public MyAdapter(Context context) {
			this.mContext = context;
		}

		@Override
		public int getCount() {
			return mIds.length;
		}

		@Override
		public Object getItem(int position) {
			return mIds[position];
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = new TextView(mContext);
			tv.setGravity(Gravity.CENTER);
			tv.setLayoutParams(new GridView.LayoutParams(70, 70));
			tv.setPadding(8, 8, 8, 8);

			tv.setText(mIds[position] + "");
			tv.setBackgroundResource(R.drawable.option_btn_single_normal);
			return tv;
		}

	}
 
}
