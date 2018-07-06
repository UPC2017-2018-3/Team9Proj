package com.example.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.dati.MainActivity;
import com.example.videopaly.video;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byabilityfiles;
import webservice.Byallpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class kechengzhishidian_Fragment2 extends Fragment{


	String coursename = ApkEntity.getcoursename();
	String teacher_account = ApkEntity.getteacher_account();
	
    @Override
    public void onAttach(Activity activity) {
    	
    	Log.i("liujun", "kechengzhishidian_Fragment2--onAttach");
    	
        super.onAttach(activity);
     
    }


	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		Log.i("liujun", "kechengzhishidian_Fragment2--onCreate");		
		super.onCreate(savedInstanceState);
		
		

		
	}

	ListView list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Log.i("liujun", "kechengzhishidian_Fragment2--onCreateView");
		

		View parentView = inflater.inflate(R.layout.kechengxiangqing_zhi, container, false);
		list = (ListView)parentView.findViewById(R.id.kecheng_zhi_listview);
        Button zonghelianxi = (Button) parentView.findViewById(R.id.zonghelianxi);
        Button shixun = (Button) parentView.findViewById(R.id.shixun);
        
        shixun.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent0 = new Intent(getActivity()
		                .getApplicationContext(), student_shixunjihua.class);
				startActivity(intent0);
			}
		});
        
        //按钮跳转事件
		zonghelianxi.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((ApkEntity) getActivity().getApplication()).setzhuangtai("练习");
				Intent intent0 = new Intent(getActivity()
		                .getApplicationContext(), MainActivity.class);
				startActivity(intent0);
			}
		});

		    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
		    android.R.layout.simple_list_item_1,getData());
		    list.setAdapter(arrayAdapter);
		    list.setOnItemClickListener(new OnItemClickListener(){  
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					//获取当前item的数据
					String strParams = "account:" + teacher_account + "|course:" + coursename;
				    List<Byallpoint> lgroup=Byallpoint.listGroup(strParams);
				    String vodiourl = lgroup.get(position).vediopath;
				    String vodioname = lgroup.get(position).knowledge;
				    ((ApkEntity) getActivity().getApplication()).setvodiourl(vodiourl);
				    ((ApkEntity) getActivity().getApplication()).setvodioname(vodioname);
					Intent intent = new Intent(getActivity()
			                .getApplicationContext(),video.class);  
		            startActivity(intent);  
				}                                 
		    });
		    return parentView;
		// return super.onCreateView(, container, savedInstanceState);
	}
	
	ArrayList<ApkEntity> apk_list;
	String strParams = "account:" + teacher_account + "|course:" + coursename;
    List<Byallpoint> lgroup=Byallpoint.listGroup(strParams);	
	private List<String> getData(){
		List<String> data = new ArrayList<String>();	
		for(int i =0;i < lgroup.size();i++) {
		    data.add(lgroup.get(i).knowledge);
	    }
		 return data;
		}

	@Override
	public void onDestroy() {
		
		Log.i("liujun", "kechengzhishidian_Fragment2--onDestroy");
		
		super.onDestroy();
		
	}


	@Override
	public void onDestroyView() {
		Log.i("liujun", "kechengzhishidian_Fragment2--onDestroyView");
		super.onDestroyView();
	}


	@Override
	public void onDetach() {
		Log.i("liujun", "kechengzhishidian_Fragment2--onDetach");
		super.onDetach();
	}


	@Override
	public void onStop() {
		Log.i("liujun", "kechengzhishidian_Fragment2--onStop");
		
		super.onStop();
	}

}
