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
import teacherpart.teacher_file;
import teacherpart.teacher_fileAdapter;
import teacherpart.teacher_student_zhuwang;
import teacherpart.teacherpage;
import webservice.Byallpinglun;
import webservice.Byorgananalysis;

public class finished_course extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finished_course);
		Button fanhuibt = (Button) findViewById(R.id.finished_courserb);
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(finished_course.this, teachingpage.class);
				startActivity(intent);
			}
		});
		
	}
	finished_courseAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.finished_courselv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new finished_courseAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}

	String organization = ApkEntity.getorganization();
	String strParams = "organization:" + organization;
	List<Byorgananalysis> lgroup=Byorgananalysis.listGroup(strParams);
	
	private void setData() {
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < 10; i++) {
			ApkEntity entity = new ApkEntity();
			entity.setteaching_class_t1("课程名字:"+lgroup.get(i).coursename);
			entity.setteaching_class_t2(lgroup.get(i).teacheraccount);
			entity.setteaching_class_t3("选课人数:"+lgroup.get(i).xuankerenshu);
			entity.setteaching_class_t4("平均成绩:"+lgroup.get(i).pingjunchengji);
			entity.setteaching_class_t5("及格人数:"+lgroup.get(i).jigerenshu);
			entity.setteaching_class_t6("优秀人数:"+lgroup.get(i).youxiurenshu);
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


