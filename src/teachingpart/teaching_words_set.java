package teachingpart;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.ReFlashListView;
import com.imooc.systemwork.departmentAdapter;
import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import webservice.Byallsensitivewords;
import webservice.Byupword;

public class teaching_words_set  extends Activity implements IReflashListener,ILoadListener{
	
	private EditText teaching_words_settjet;
	String organization = ApkEntity.getorganization();
	ArrayList<ApkEntity> apk_list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teaching_words_set);
		Button fanhuibt = (Button) findViewById(R.id.teaching_words_setrb);
		Button teaching_words_setbt = (Button) findViewById(R.id.teaching_words_setbt);
		teaching_words_settjet = (EditText)findViewById(R.id.teaching_words_settjet);
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teaching_words_set.this, teachingpage.class);
				startActivity(intent);
			}
		});
		teaching_words_setbt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String word=teaching_words_settjet.getText().toString();
				String str = "word:" + word+"|organization:" + organization;
				String retString=Byupword.LogSelect(str);
				if (retString.equals("1")) {
					
					Toast.makeText(getApplicationContext(),"添加成功",
							Toast.LENGTH_LONG).show();
					setData();
					showList(apk_list);
					adapter.notifyDataSetChanged();
					
				}
				else if (retString.equals("2")) {
					
					Toast.makeText(getApplicationContext(),"敏感词已添加",
							Toast.LENGTH_LONG).show();
					setData();
					showList(apk_list);
					adapter.notifyDataSetChanged();
					
				} 
		    	else {
		    		Toast.makeText(getApplicationContext(),"请重新添加！",
							Toast.LENGTH_LONG).show();
		    	}
			}
		});
	}
	private teaching_words_setAdapter adapter;
	private ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.teaching_words_setlv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teaching_words_setAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	
	
	

	private void setData() {
		String strParams = "organization:" + organization;
		List<Byallsensitivewords> lgroup=Byallsensitivewords.listGroup(strParams);
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.setteaching_words_setlv_t1(lgroup.get(i).word);
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

