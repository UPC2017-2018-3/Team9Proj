package com.example.student;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Bycoursedetailothers;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class youke_Fragment1 extends Fragment{
	
	String coursename = ApkEntity.getcoursename();
	String teacher_account = ApkEntity.getteacher_account();
	public TextView tv_youkejianjie1,tv_youkejianjie2,tv_youkejianjie3,ltv_youkejian1,ltv_youkejian2;
	 @Override
	    public void onAttach(Activity activity) {
	    	
	    	Log.i("liujun", "youke_Fragment1--onAttach");
	    	
	        super.onAttach(activity);
	     
	    }


		@Override
		public void onCreate(Bundle savedInstanceState) {
			
			Log.i("liujun", "youke_Fragment1--onCreate");
			
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			Log.i("liujun", "youke_Fragment1--onCreateView");
			
			//����Ƭ�ζ�Ӧ�Ĳ����ļ�
			View parentView = inflater.inflate(R.layout.youkekecheng_jian, container, false);
			tv_youkejianjie1=(TextView)parentView.findViewById(R.id.tv_youkejianjie1);
			tv_youkejianjie2=(TextView)parentView.findViewById(R.id.tv_youkejianjie2);
			tv_youkejianjie3=(TextView)parentView.findViewById(R.id.tv_youkejianjie3);
			ltv_youkejian1=(TextView)parentView.findViewById(R.id.ltv_youkejian1);
			ltv_youkejian2=(TextView)parentView.findViewById(R.id.ltv_youkejian2);
	        getData();
			return parentView;
			// return super.onCreateView(, container, savedInstanceState);
		}
		ArrayList<ApkEntity> apk_list;
		String strParams = "organization:" + "哈佛大学" + "|course:" + coursename+ "|account:" + teacher_account;
	    List<Bycoursedetailothers> lgroup=Bycoursedetailothers.listGroup(strParams);
		
		private void getData() {
			
			for(int i =0;i < lgroup.size();i++) {
				tv_youkejianjie1.setText(lgroup.get(i).coursename);
				tv_youkejianjie2.setText(lgroup.get(i).courseorganizationname);
				ltv_youkejian1.setText(lgroup.get(i).courseteachername);
				ltv_youkejian2.setText(lgroup.get(i).summary);
		    }
		}


		@Override
		public void onDestroy() {
			
			Log.i("liujun", "youke_Fragment1--onDestroy");
			
			super.onDestroy();
			
		}


		@Override
		public void onDestroyView() {
			Log.i("liujun", "youke_Fragment1--onDestroyView");
			super.onDestroyView();
		}


		@Override
		public void onDetach() {
			Log.i("liujun", "youke_Fragment1--onDetach");
			super.onDetach();
		}


		@Override
		public void onStop() {
			Log.i("liujun", "youke_Fragment1--onStop");
			
			super.onStop();
		}

}
