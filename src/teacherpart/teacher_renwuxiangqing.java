package teacherpart;

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
import webservice.Byallrenwu;
import webservice.Bygoodstudent;

public class teacher_renwuxiangqing extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_renwuxiangqing);
		Button fanhuibt = (Button) findViewById(R.id.teacher_renwuxiangqingrb);
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_renwuxiangqing.this, teacher_task_management.class);
				startActivity(intent);
			}
		});
		listview.setOnItemClickListener(new OnItemClickListener(){  
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				//获取当前item的数据
				String strParams = "course:" + course+"|renwu:" + renwu;
				List<Bygoodstudent> lgroup=Bygoodstudent.listGroup(strParams);
				((ApkEntity) getApplication()).setstudent_account(lgroup.get(position-1).studentaccount);
				Intent intent = new Intent(teacher_renwuxiangqing.this,teacher_student_renwu.class);  
	            startActivity(intent);  
		        		
			}                                 
	    });
	}
	teacher_renwuxiangqingAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.teacher_renwuxiangqinglv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teacher_renwuxiangqingAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}

	String course = ApkEntity.getrenwucourse();
	String renwu = ApkEntity.getrenwutitle();
	
	private void setData() {
		String strParams = "course:" + course+"|renwu:" + renwu;
		List<Bygoodstudent> lgroup=Bygoodstudent.listGroup(strParams);
		
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i <lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setteacher_renwuxiangqingtv(lgroup.get(i).studentname);
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

