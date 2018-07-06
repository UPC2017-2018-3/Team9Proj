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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import webservice.Byshixunplanlist;

public class review_training_plan extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_training_plan);
		Button fanhuibt = (Button) findViewById(R.id.review_training_planrb);
		TextView review_t2 = (TextView) findViewById(R.id.review_t2);
		
		String organization = ApkEntity.getorganization();
		String strParams = "organization:" + organization;
		final List<Byshixunplanlist> lgroup=Byshixunplanlist.listGroup(strParams);
		
		review_t2.setText("目前有"+lgroup.size()+"项实训计划待审核");
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(review_training_plan.this, teachingpage.class);
				startActivity(intent);
			}
		});
		listview.setOnItemClickListener(new OnItemClickListener(){  
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				
				String shixuncourse =lgroup.get(position-1).shixuncourse;
				String shixunteacher =lgroup.get(position-1).shixunteacher;
				String shixuncontent =lgroup.get(position-1).shixuncontent;
				((ApkEntity) getApplication()).setshixuncourse(shixuncourse);
				((ApkEntity) getApplication()).setshixunteacher(shixunteacher);
				((ApkEntity) getApplication()).setshixuncontent(shixuncontent);
				Intent intent = new Intent(review_training_plan.this,review_training_planmain.class);  
	            startActivity(intent);  
	            
			}                                 
	    });
	}
	review_training_planAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.review_training_planlv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new review_training_planAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	
	String organization = ApkEntity.getorganization();
	String strParams = "organization:" + organization;
	List<Byshixunplanlist> lgroup=Byshixunplanlist.listGroup(strParams);
	

	private void setData() {
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setreview_training_planlvt1(lgroup.get(i).shixuncourse+"实训计划");
			entity.setreview_training_planlvt2(lgroup.get(i).shixunteachername);
			entity.setreview_training_planlvt3(lgroup.get(i).shixuntime);
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

