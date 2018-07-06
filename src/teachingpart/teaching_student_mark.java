package teachingpart;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.ReFlashListView;
import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import webservice.Byorganstudentmark;
import webservice.Byshixunplanlist;

public class teaching_student_mark extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_training_plan);
		Button fanhuibt = (Button) findViewById(R.id.review_training_planrb);
		TextView review_t2 = (TextView) findViewById(R.id.review_t2);
		
		String account = ApkEntity.getstudent_account();
		String strParams = "account:" + account;
		List<Byorganstudentmark> lgroup=Byorganstudentmark.listGroup(strParams);
		
		review_t2.setText("该同学已完成"+lgroup.size()+"门课程");
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teaching_student_mark.this, student_mark.class);
				startActivity(intent);
			}
		});
		
	}
	teaching_student_markAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.review_training_planlv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teaching_student_markAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	
	String account = ApkEntity.getstudent_account();
	String strParams = "account:" + account;
	List<Byorganstudentmark> lgroup=Byorganstudentmark.listGroup(strParams);
	

	private void setData() {
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setteaching_student_mark_t1(lgroup.get(i).coursename+":");
			entity.setteaching_student_mark_t2(lgroup.get(i).mark);
			apk_list.add(entity);
		}
	}

	private void setReflashData() {
		
	}
	private void getLoadData() {
		
	}
	@Override
	public void onReflash() {
		// TODO Auto-generated method stub\
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷
				setReflashData();
				//通知锟斤拷锟斤拷锟斤拷示
				showList(apk_list);
				//通知listview 刷锟斤拷锟斤拷锟斤拷锟斤拷希锟�
				listview.reflashComplete();
			}
		}, 2000);
		
	}
	public void onLoad() {
		// TODO Auto-generated method stub
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getLoadData();
				showList(apk_list);
				listview.loadComplete();
			}
		}, 2000);
	}

}
