package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.example.videopaly.video;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byallpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class youke_Fragment2 extends Fragment{
	
	String coursename = ApkEntity.getcoursename();
	String teacher_account = ApkEntity.getteacher_account();
	
	 @Override
	    public void onAttach(Activity activity) {
	    	
	    	Log.i("liujun", "youke_Fragment2--onAttach");
	    	
	        super.onAttach(activity);
	     
	    }


		@Override
		public void onCreate(Bundle savedInstanceState) {
			
			Log.i("liujun", "youke_Fragment2--onCreate");
			
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			Log.i("liujun", "youke_Fragment2--onCreateView");
			
			//����Ƭ�ζ�Ӧ�Ĳ����ļ�
			View parentView = inflater.inflate(R.layout.youkekecheng_zhi, container, false);
			ListView list = (ListView)parentView.findViewById(R.id.youke_zhi_listview);
			    //����������
			    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
			    android.R.layout.simple_list_item_1,getData());
			    list.setAdapter(arrayAdapter);
			    list.setOnItemClickListener(new OnItemClickListener(){  
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// TODO Auto-generated method stub
						//获取当前item的数据
						Toast.makeText(getActivity().getApplicationContext(), "请先登录", Toast.LENGTH_LONG).show();
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
			
			Log.i("liujun", "youke_Fragment2--onDestroy");
			
			super.onDestroy();
			
		}


		@Override
		public void onDestroyView() {
			Log.i("liujun", "youke_Fragment2--onDestroyView");
			super.onDestroyView();
		}


		@Override
		public void onDetach() {
			Log.i("liujun", "youke_Fragment2--onDetach");
			super.onDetach();
		}


		@Override
		public void onStop() {
			Log.i("liujun", "youke_Fragment2--onStop");
			
			super.onStop();
		}

}
