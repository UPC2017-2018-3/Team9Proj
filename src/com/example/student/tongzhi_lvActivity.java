package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byabilityfiles;
import webservice.Byallgonggao;
import webservice.Byallxueyou;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class tongzhi_lvActivity extends Activity {
	ArrayList<ApkEntity> apk_list;
	public static String tongzhi_theme = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		listview = (ListView) findViewById(R.id.tongzhigonggao_listview);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tongzhigonggao);
		
		setData();
		showList(apk_list);
//		parent �������������AdapterView;
//		view ��AdapterView�б��������ͼ(������adapter�ṩ��һ����ͼ);
//        position ��ͼ��adapter�е�λ��;
//        id �����Ԫ�ص���id;
		listview.setOnItemClickListener(new OnItemClickListener(){

			@Override

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				TextView tv1_item_tongzhi2 = (TextView)view.findViewById(R.id.tv1_item_tongzhi2);
				String tongzhi_theme = tv1_item_tongzhi2.getText().toString();
				((ApkEntity) getApplication()).settongzhi_theme(tongzhi_theme);
				Intent intent = new Intent();  
                intent.setClass(tongzhi_lvActivity.this, gonggaoxiangqingActivity.class);    
                startActivity(intent);  
				
			}
			
		});
		
		 Button tongzhi_backw = (Button)findViewById(R.id.tongzhi_backw);
		 tongzhi_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(tongzhi_lvActivity.this, yuanxiaozhuye_Activity.class);
	                startActivity(intent);
				}
			});        
		
	
	}
	tongzhi_lvActivityAdapter adapter;
	ListView listview;
	String organization = ApkEntity.getorganization();
	String strParams = "organization:" + organization;
	List<Byallgonggao> lgroup=Byallgonggao.listGroup(strParams);
	  //д������
		private void setData() {
			apk_list = new ArrayList<ApkEntity>();
			for (int i = 0; i < lgroup.size(); i++) {
				ApkEntity entity = new ApkEntity();
				entity.settv1_item_tongzhi2(lgroup.get(i).gonggaotitle);
				apk_list.add(entity);
				
			}
		}	

	//��ʾ����
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ListView) findViewById(R.id.tongzhigonggao_listview);
			adapter = new tongzhi_lvActivityAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	
  

	

}

